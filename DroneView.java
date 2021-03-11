package projetodrone;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class DroneView extends javax.swing.JFrame {

    private DefaultListModel<DroneModel> listaVisual;

    public DroneView() {
        listaVisual = new DefaultListModel<DroneModel>();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        controledeenergiaJlabel = new javax.swing.JLabel();
        codigoJlabel = new javax.swing.JLabel();
        wattsJlabel = new javax.swing.JLabel();
        codigoJtextfield = new javax.swing.JTextField();
        wattsJtextfield = new javax.swing.JTextField();
        jSPLista = new javax.swing.JScrollPane();
        listaVisualJlist = new javax.swing.JList<DroneModel>();
        Binserir = new javax.swing.JButton();
        Blimpar = new javax.swing.JButton();
        Bcalcular = new javax.swing.JButton();
        maiordistanciatextJlabel = new javax.swing.JLabel();
        menordistanciatextJlabel = new javax.swing.JLabel();
        kmwJlabel = new javax.swing.JLabel();
        eficienciaJtextfield = new javax.swing.JTextField();
        maiordistanciaJlabel = new javax.swing.JLabel();
        menordistanciaJlabel = new javax.swing.JLabel();
        cargalivredoesquadraotextJlabel = new javax.swing.JLabel();
        cargalivreJlabel = new javax.swing.JLabel();
        textolistaEnergiaJlabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        controledeenergiaJlabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        controledeenergiaJlabel.setText("Controle de Energia para Esquadrão de Drones");
        getContentPane().add(controledeenergiaJlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 430, 30));

        codigoJlabel.setText("Código: ");
        getContentPane().add(codigoJlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 76, -1, -1));

        wattsJlabel.setText("Watts:");
        getContentPane().add(wattsJlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));
        getContentPane().add(codigoJtextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 73, 112, -1));
        getContentPane().add(wattsJtextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 107, 112, -1));

        listaVisualJlist.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        listaVisualJlist.setModel(listaVisual);
        jSPLista.setViewportView(listaVisualJlist);

        getContentPane().add(jSPLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 252, 380, 227));

        Binserir.setText("Inserir");
        getContentPane().add(Binserir, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        Blimpar.setText("Limpar");
        getContentPane().add(Blimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 497, 82, -1));

        Bcalcular.setText("Calcular");
        getContentPane().add(Bcalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 497, -1, -1));

        maiordistanciatextJlabel.setText("Maior  distância:");
        getContentPane().add(maiordistanciatextJlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 107, -1, -1));

        menordistanciatextJlabel.setText("Menor distância: ");
        getContentPane().add(menordistanciatextJlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 73, -1, -1));

        kmwJlabel.setText("Km/W:");
        getContentPane().add(kmwJlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 148, -1, -1));
        getContentPane().add(eficienciaJtextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 145, 112, -1));

        maiordistanciaJlabel.setText("______");
        getContentPane().add(maiordistanciaJlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 57, -1));

        menordistanciaJlabel.setText("______");
        getContentPane().add(menordistanciaJlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 74, -1, -1));

        cargalivredoesquadraotextJlabel.setText("Carga Livre:");
        getContentPane().add(cargalivredoesquadraotextJlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 148, -1, -1));

        cargalivreJlabel.setText("______");
        getContentPane().add(cargalivreJlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        textolistaEnergiaJlabel.setText("Lista de Energia do Esquadrão de Drones");
        getContentPane().add(textolistaEnergiaJlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 234, 21));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetodrone/Imagens/drone-wallpaper-gradient-1680x1050.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, -50, 1130, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //INSERIR
    public DroneModel obterDrone() {
        String cod = codigoJtextfield.getText();
        double watts = Double.parseDouble(wattsJtextfield.getText());
        double eficiencia = Double.parseDouble(eficienciaJtextfield.getText());

        if (cod.isEmpty() || watts == 0 || eficiencia == 0) {
            JOptionPane.showMessageDialog(null, "Insira os valores na caixa de texto");
        } else {
            //JOptionPane.showMessageDialog(null, "Drone inserido");
            DroneModel d = new DroneModel(cod, watts, eficiencia); //construtor
            return d;
        }
        return null;
    }

    public void addInsereListener(ActionListener l) {
        Binserir.addActionListener(l);
    }

    public void insereDroneLista(DroneModel d) {
//addElement mostra o que o toString na lista
        listaVisual.addElement(d);

//Limpa os campos textfield da tela toda vez que um elemento novo é inserido
        codigoJtextfield.setText("");
        wattsJtextfield.setText("0");
        eficienciaJtextfield.setText("0");

    }

    //RETORNA INFORMAÇÃO DO BANCO NA LISTA
    public void mostraListaVisual(ArrayList<DroneModel> lista) {
        limpaListaVisual();

        codigoJtextfield.setText("");
        wattsJtextfield.setText("0");
        eficienciaJtextfield.setText("0");

        Iterator<DroneModel> it = lista.iterator();
        while (it.hasNext()) {
            DroneModel d = it.next();
            insereDroneLista(d);
        }
    }

    //LIMPAR
    public void addLimpaLista(ActionListener l) {
        Blimpar.addActionListener(l);
    }

    public void limpaListaVisual() {
        listaVisual.clear();
    }

    //CALCULAR
    public void addCalcularLista(ActionListener l) {
        Bcalcular.addActionListener(l);
    }

    public void calcularListaVisual(String menorDrone, String maiorDrone, double cargaLivre) {
        menordistanciaJlabel.setText("" + menorDrone);
        maiordistanciaJlabel.setText("" + maiorDrone);
        cargalivreJlabel.setText("" + cargaLivre);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bcalcular;
    private javax.swing.JButton Binserir;
    private javax.swing.JButton Blimpar;
    private javax.swing.JLabel cargalivreJlabel;
    private javax.swing.JLabel cargalivredoesquadraotextJlabel;
    private javax.swing.JLabel codigoJlabel;
    private javax.swing.JTextField codigoJtextfield;
    private javax.swing.JLabel controledeenergiaJlabel;
    private javax.swing.JTextField eficienciaJtextfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jSPLista;
    private javax.swing.JLabel kmwJlabel;
    private javax.swing.JList<DroneModel> listaVisualJlist;
    private javax.swing.JLabel maiordistanciaJlabel;
    private javax.swing.JLabel maiordistanciatextJlabel;
    private javax.swing.JLabel menordistanciaJlabel;
    private javax.swing.JLabel menordistanciatextJlabel;
    private javax.swing.JLabel textolistaEnergiaJlabel;
    private javax.swing.JLabel wattsJlabel;
    private javax.swing.JTextField wattsJtextfield;
    // End of variables declaration//GEN-END:variables

}
