package projetodrone;

import java.util.Iterator;
import java.util.ArrayList;

public class DroneLista {

    private ArrayList<DroneModel> listaDrones;

    public DroneLista() {
        listaDrones = new ArrayList<DroneModel>();
    }

    public ArrayList<DroneModel> getListaDrone() {
        return listaDrones;
    }

    public void insereDrone(DroneModel d) {
        listaDrones.add(d);
    }

    public void limparLista() {
        listaDrones.clear();
    }

    public void calcularLista(DroneModel d) {
        menorDistancia(d);
        maiorDistancia(d);
        cargaLivre(d);
    }

    public String maiorDistancia(DroneModel d) {
        Iterator<DroneModel> it = listaDrones.iterator();
        double maiorDistancia = 0;
        String maiorDrone = "";
        while (it.hasNext()) {
            d = it.next();
            if (d.autonomia() > maiorDistancia) {
                maiorDistancia = d.autonomia();
                maiorDrone = d.getCodDrone();
            }
        }
        return maiorDrone;
    }

    public String menorDistancia(DroneModel d) {
        Iterator<DroneModel> it = listaDrones.iterator();
        double menorDistancia = 100000;
        String menorDrone = "";
        while (it.hasNext()) {
            d = it.next();
            if (d.autonomia() < menorDistancia) {
                menorDistancia = d.autonomia();
                menorDrone = d.getCodDrone();
            }
        }
        return menorDrone;
    }

    public double cargaLivre(DroneModel d) {
        double soma = 0;
        
        Iterator<DroneModel> it = listaDrones.iterator();
        
        while (it.hasNext()) {
            soma = soma + it.next().getEnergiaAtual();
        }
        
        return soma;
    }
}
