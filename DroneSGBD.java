package projetodrone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DroneSGBD {

    private String URL_DB = "jdbc:derby://localhost:1527/DRONEBD";
    private Connection conexaoDB;

    public DroneSGBD() {
        try {//usuário: drone / senha: drone
            conexaoDB = DriverManager.getConnection(URL_DB, "drone", "drone");
            System.out.println("Conexao bem sucedida");
        } catch (SQLException e) {
            System.out.println("Houve erro na Conexao e=" + e);
        }
    }

    public void insereDrone(DroneModel d) {
        try {
            Statement comando = conexaoDB.createStatement();
            String sqlInsere = "INSERT INTO DRONE_TB(COD_DRONE,"
                                + "ENERGIA_ATUAL,"
                                + "EFICIENCIA) "
                                + "VALUES('"
                                + d.getCodDrone()
                                + "', "
                                + d.getEnergiaAtual()
                                + ", "
                                + d.getEficienciaDrone()
                                + ")";
            
            System.out.println("Executando: " + sqlInsere);
            comando.executeLargeUpdate(sqlInsere);
            System.out.println("Dado inserido Adequadamente");
            comando.close();
        } catch (SQLException e) {
            System.out.println("Erro na inserção do dado :" + e);
        }
    }

    public void removeDrone(){
        try {
            Statement comando = conexaoDB.createStatement();
            String sqlRemove = "DELETE "
                             + "FROM DRONE_TB ";
            
                System.out.println("Executando: " + sqlRemove);
                comando.executeUpdate(sqlRemove);                
                System.out.println("Dado Removido Adequadamente");
                comando.close();   
        } catch (SQLException e) {
              System.out.println("Erro na remocao do dado :"+e); 
        }
    }
    
    public void lerListaDrone(DroneLista dlista){
        try {
            dlista.limparLista();
            Statement comando = conexaoDB.createStatement();
            String sqlListaTodos = "SELECT COD_DRONE,"
                                        + "ENERGIA_ATUAL,"
                                        + "EFICIENCIA "
                                 + "FROM DRONE_TB";
                                         
            ResultSet resultado;                            
            resultado = comando.executeQuery(sqlListaTodos);
            
            while(resultado.next()){
                String codigo     = resultado.getString(1);
                double energia    = resultado.getDouble(2);
                double eficiencia = resultado.getDouble(3);
                DroneModel d = new DroneModel(codigo, energia, eficiencia);
                dlista.insereDrone(d);                
            }
            comando.close();
            
        } catch (SQLException e) {
            System.out.println("Houve erro na Leitura e=" +e);  
        }
        
        
    }
    
}