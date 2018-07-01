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
public final class ListaProvincias {
    private LinkedList<String> costa ;
    private LinkedList<String> sierra;
    private LinkedList<String> oriente;
    private LinkedList<String> insular;
    
    public ListaProvincias(){
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
        costa.add("esmeraldas");
        costa.add("santo domingo");
        costa.add("manabí");
        costa.add("manabi");
        costa.add("los ríos");
        costa.add("los rios");
        costa.add("guayas");
        costa.add("santa elena");
        costa.add("el oro");
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
        sierra.add("pichincha");
        sierra.add("carchi");
        sierra.add("tungurahua");
        sierra.add("chimborazo");
        sierra.add("cañar");
        sierra.add("azuay");
        sierra.add("loja");
        sierra.add("imbabura");
        sierra.add("bolívar");
        sierra.add("bolivar");
        sierra.add("cotopaxi");
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
        oriente.add("sucumbios");
        oriente.add("orellana");
        oriente.add("napo");
        oriente.add("pastaza");
        oriente.add("morona santiago");
        oriente.add("zamora chinchipe");
        return oriente;
    }
    
    private LinkedList<String> provInsular(){
        insular = new LinkedList<>();
        insular.add("Galápagos");
        insular.add("galápagos");
        insular.add("galapagos");
        return insular;
    }
}