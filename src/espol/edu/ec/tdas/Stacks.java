/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.tdas;

import java.io.IOException;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author ROSA
 */
public class Stacks {
    static String path = "src/espol/edu/ec/tdas";
    Deque<ProcesamMig> costa_E = new LinkedList<>();
    Deque<ProcesamMig> costa_S = new LinkedList<>();
    Deque<ProcesamMig> sierra_E = new LinkedList<>();
    Deque<ProcesamMig> sierra_S = new LinkedList<>();
    Deque<ProcesamMig> oriente_E = new LinkedList<>();
    Deque<ProcesamMig> oriente_S = new LinkedList<>();
    Deque<ProcesamMig> insular_E = new LinkedList<>();
    Deque<ProcesamMig> insular_S = new LinkedList<>();
    Deque<ProcesamMig> CS_E = new LinkedList<>();
    Deque<ProcesamMig> OI_E = new LinkedList<>();
    Deque<ProcesamMig> CS_S = new LinkedList<>();
    Deque<ProcesamMig> OI_S = new LinkedList<>();
    Deque<ProcesamMig> pila_E = new LinkedList<>();
    Deque<ProcesamMig> pila_S = new LinkedList<>();

    public Deque<ProcesamMig> getCosta_E() {
        return ordenarDeque(costa_E);
    }

    public Deque<ProcesamMig> getCosta_S() {
        return ordenarDeque(costa_S);
    }

    public Deque<ProcesamMig> getSierra_E() {
        return ordenarDeque(sierra_E);
    }

    public Deque<ProcesamMig> getSierra_S() {
        return ordenarDeque(sierra_S);
    }

    public Deque<ProcesamMig> getOriente_E() {
        return ordenarDeque(oriente_E);
    }

    public Deque<ProcesamMig> getOriente_S() {
        return ordenarDeque(oriente_S);
    }
     
    public Deque<ProcesamMig> getInsular_E() {
        return ordenarDeque(insular_E);
    }

    public Deque<ProcesamMig> getInsular_S() {
        return ordenarDeque(insular_S);
    }
        
    ListaProvincias listProvincia = new ListaProvincias();
    Data d = new Data();
    HashMap<String, ProcesamMig> mapa_Entradas  = d.CargarEntradas(path+"/migraciones.csv");
    HashMap<String, ProcesamMig> mapa_Salidas  = d.CargarSalidas(path+"/migraciones.csv");

    public Deque<ProcesamMig> getPila_E() {
        return pila_E;
    }

    public Deque<ProcesamMig> getPila_S() {
        return pila_S;
    }
        
    public Stacks() throws IOException {
        Deque<ProcesamMig> c_E = pilaxProvincia(costa_E, mapa_Entradas, listProvincia.getCosta());
        Deque<ProcesamMig> s_E = pilaxProvincia(sierra_E, mapa_Entradas, listProvincia.getSierra());
        Deque<ProcesamMig> o_E = pilaxProvincia(oriente_E, mapa_Entradas, listProvincia.getOriente());
        Deque<ProcesamMig> i_E = pilaxProvincia(insular_E, mapa_Entradas, listProvincia.getInsular());
        this.CS_E = ordenar(c_E, s_E); 
        this.OI_E = ordenar(o_E, i_E); 
        this.pila_E = ordenar(CS_E, OI_E); 
        Deque<ProcesamMig> c_S = pilaxProvincia(costa_S, mapa_Salidas, listProvincia.getCosta());
        Deque<ProcesamMig> s_S = pilaxProvincia(sierra_S, mapa_Salidas, listProvincia.getSierra());
        Deque<ProcesamMig> o_S = pilaxProvincia(oriente_S, mapa_Salidas, listProvincia.getOriente());
        Deque<ProcesamMig> i_S = pilaxProvincia(insular_S, mapa_Salidas, listProvincia.getInsular());
        this.CS_S = ordenar(c_S, s_S);
        this.OI_S = ordenar(o_S, i_S);
        this.pila_S = ordenar(CS_S, OI_S); 
    }
    
    public static Deque<ProcesamMig> pilaxProvincia(Deque<ProcesamMig> s1, HashMap<String, ProcesamMig> p, LinkedList listaProvincia){
        for(Map.Entry<String, ProcesamMig> m : p.entrySet()){
            if(listaProvincia.contains(m.getKey())){
                s1.push(m.getValue());
            }
        }
        return ordenarDeque(s1);
    }
            
    public static Deque<ProcesamMig> ordenarDeque(Deque<ProcesamMig> pila_Desordenada){
        Iterator<ProcesamMig> e = pila_Desordenada.iterator();
        Deque<ProcesamMig> pila_Ordenada = new LinkedList<>();
        LinkedList<ProcesamMig> list = new LinkedList<>();
        while(e.hasNext()){
            list.add(e.next());
        }
        Collections.sort(list);
        for(ProcesamMig p : list){
            pila_Ordenada.push(p);
        }        //System.out.println("C!"+pila_Ordenada+"\n");
        return pila_Ordenada;
    }
    
    public static Deque<ProcesamMig> ordenar(Deque<ProcesamMig> s1, Deque<ProcesamMig> s2){
        Deque<ProcesamMig> copys1 = new LinkedList<>();
        Deque<ProcesamMig> copys2 = new LinkedList<>();
        Deque<ProcesamMig> copy1 = new LinkedList<>();
        Deque<ProcesamMig> copy2 = new LinkedList<>();
        Deque<ProcesamMig> c1 = new LinkedList<>();
        Deque<ProcesamMig> c2 = new LinkedList<>();
        Deque<ProcesamMig> s = new LinkedList<>();
        while(!s1.isEmpty()){
            ProcesamMig e = s1.peek();
            c1.push(e);
            copys1.push(e);
            copy1.push(s1.pop());
        }
        while(!s2.isEmpty()){
            ProcesamMig e = s2.peek();
            c2.push(e);
            copys2.push(e);
            copy2.push(s2.pop());
        }
        while(!c1.isEmpty()){
            s1.push(c1.pop());
        }
        while(!c2.isEmpty()){
            s2.push(c2.pop());
        }
        while ((!s1.isEmpty()) && !s2.isEmpty()){
            if(s1.peek().getCantidad() > s2.peek().getCantidad()){
                s.push(s2.pop());
            }else if (s1.peek().getCantidad()==(s2.peek().getCantidad())){
                s.push(s1.pop());
                s.push(s2.pop());
            }else{
                s.push(s1.pop());
            }
        }
        while (!s1.isEmpty()){
            s.push(s1.pop());
        }
        while (!s2.isEmpty()){
            s.push(s2.pop());
        }
        while(!copys1.isEmpty()){
            s1.push(copys1.pop());
        }
        while(!copys2.isEmpty()){
            s2.push(copys2.pop());
        }
        Deque<ProcesamMig> pila = new LinkedList<>();
        while (!s.isEmpty()){
            pila.push(s.pop());
        }
        return pila;
    }
}