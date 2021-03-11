package projetodrone;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DroneControl {

//Criando variáveis do tipo view, lista e banco de dados   
    private DroneView droneView;
    private DroneLista droneLista;
    private DroneSGBD droneSGBD;

    private class insereListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Criando um objeto dm que vai receber o valor do retorno do método obterDrone lá na view
            DroneModel dm = droneView.obterDrone();
            if (dm == null) {
                System.out.println("Não foi inserido nada na lista/banco");
            } else {
                //Esse valor está sendo passado como parâmetro no método insere lá na lista
                droneLista.insereDrone(dm);

                //E também está sendo passado pra a view
                droneView.insereDroneLista(dm);

                droneSGBD.insereDrone(dm);
            }
        }
    }

    private class limpaListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            droneLista.limparLista();
            droneView.limpaListaVisual();
            droneSGBD.removeDrone();
            droneView.calcularListaVisual("", "", 0);
        }
    }

    private class calcularListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DroneModel d = new DroneModel();
            DroneLista dl = new DroneLista();

            String menorDrone = droneLista.menorDistancia(d);
            String maiorDrone = droneLista.maiorDistancia(d);
            double cargaLivre = droneLista.cargaLivre(d);

            droneLista.calcularLista(d);
            droneView.calcularListaVisual(menorDrone, maiorDrone, cargaLivre);
            

            droneView.mostraListaVisual(droneLista.getListaDrone());
        }
    }

    public void executar() {

        droneSGBD = new DroneSGBD();
        droneView = new DroneView();
        droneLista = new DroneLista();

        insereListener x = new insereListener();
        droneView.addInsereListener(x);

        droneView.addLimpaLista(new limpaListener());

        droneView.addCalcularLista(new calcularListener());
        
        droneView.setVisible(true);
       
        droneSGBD.lerListaDrone(droneLista);
        
        droneView.mostraListaVisual(droneLista.getListaDrone());
        
    }
}
