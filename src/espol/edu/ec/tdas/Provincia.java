/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.tdas;

import java.util.LinkedList;

/**
 *
 * @author ROSA
 */
public final class Provincia {
    private LinkedList<String> costa ;
    private LinkedList<String> sierra;
    private LinkedList<String> oriente;
    private LinkedList<String> insular;
    
    public Provincia(){
        this.costa = provCosta();
        this.sierra = provSierra();
        this.oriente = provOriente();
        this.insular = provInsular();
    }

    public LinkedList<String> getCosta() {
        return costa;
    }
    public LinkedList<String> getSierra() {
        return sierra;
    }

    public LinkedList<String> getOriente() {
        return oriente;
    }

    public LinkedList<String> getInsular() {
        return insular;
    }
    
    private LinkedList<String> provCosta(){
        costa = new LinkedList<>();
        costa.add("Esmeraldas");
        costa.add("Santo Domingo");
        costa.add("Manabí");
        costa.add("Los Ríos");
        costa.add("Guayas");
        costa.add("Santa Elena");
        costa.add("El Oro");
        return costa;
    }
    
    private LinkedList<String> provSierra(){
        sierra = new LinkedList<>();
        sierra.add("Pichincha");
        sierra.add("Carchi");
        sierra.add("Tungurahua");
        sierra.add("Chimborazo");
        sierra.add("Cañar");
        sierra.add("Azuay");
        sierra.add("Loja");
        sierra.add("Imbabura");
        sierra.add("Bolívar");
        sierra.add("Cotopaxi");
        return sierra;
    }
    
    private LinkedList<String> provOriente(){
        oriente = new LinkedList<>();
        oriente.add("Sucumbios");
        oriente.add("Orellana");
        oriente.add("Napo");
        oriente.add("Pastaza");
        oriente.add("Morona Santiago");
        oriente.add("Zamora Chinchipe");
        return oriente;
    }
    
    private LinkedList<String> provInsular(){
        insular = new LinkedList<>();
        insular.add("Galápagos");
        return insular;
    }
}