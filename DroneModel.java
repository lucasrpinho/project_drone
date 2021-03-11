package projetodrone;

public class DroneModel {

    private String codDrone;
    private double energiaAtual;
    private double eficienciaDrone;

    //Construtor vazio
    DroneModel() {

    }

    //Construtor recebendo valores
    public DroneModel(String codDrone, double energiaAtual, double eficienciaDrone) {
        this.codDrone = codDrone;
        this.energiaAtual = energiaAtual;
        this.eficienciaDrone = eficienciaDrone;
    }

    //Calculando a autonomia
    public double autonomia() {
        return energiaAtual * eficienciaDrone;
    }

    //Retornando valor para a view / O que vai aparecer na lista
    @Override
    public String toString() {
        return "Drone: " + codDrone + " - Energia: " + energiaAtual + " Watts / Autonomia: " + autonomia() + " KM";
    }

    public String getCodDrone() {
        return codDrone;
    }

    public double getEnergiaAtual() {
        return energiaAtual;
    }

    public double getEficienciaDrone() {
        return eficienciaDrone;
    }

    public void setCodDrone(String codDrone) {
        this.codDrone = codDrone;
    }

    public void setEficienciaDrone(double eficienciaDrone) {
        this.eficienciaDrone = eficienciaDrone;
    }

    public void setEnergiaAtual(double energiaAtual) {
        this.energiaAtual = energiaAtual;
    }
}
