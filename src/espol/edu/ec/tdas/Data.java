/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.tdas;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author ROSA
 */
public class Data implements Serializable{
    private String filename;
    Movimiento m;
    String tipo;
    //Migrante mi;
    //NacionalidadT n;
    //Transporte t;
    JefaturaMig j;
    
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Data(){}
    
    public Data(JefaturaMig j, Movimiento m){
        this.m = m;
        this.j = j;
    }
    public Data(String t, Movimiento m){
        this.m = m;
        this.tipo = t;
    }
    public Data(JefaturaMig j){
        this.j = j;
    }
    
    public Data(String t){
        this.tipo = t;
    }

    public Movimiento getM() {
        return m;
    }

    public void setM(Movimiento m) {
        this.m = m;
    }

    public JefaturaMig getJ() {
        return j;
    }

    public void setJ(JefaturaMig j) {
        this.j = j;
    }
    
    @Override
    public String toString() {
        return m.getTipo() ;
    }
    
    public HashMap<String, ProcesamMig> CargarEntradas(String filename) throws IOException{
        HashMap<String, ProcesamMig> d = new HashMap<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "ISO-8859-1"));
        String cadena = in.readLine();
        try {
            while ((cadena = in.readLine()) != null) {
                String[] p1 = cadena.split(";");
                int valor = 1;
                if (p1[0].equals("Entrada") ){
                    if (!d.containsKey(p1[3])){
                        d.put(p1[3], new ProcesamMig(new JefaturaMig(p1[3],p1[4]),valor));
                    }else{
                        d.get(p1[3]).setCantidad(d.get(p1[3]).getCantidad()+1);
                    }  
                }
            }
        } catch (IOException | NumberFormatException e) {

        } finally {
            in.close();
        }        //System.out.println(d);
       return d;
    }
    /**
     *
     * @param filename
     * @return
     * @throws IOException
     */
    public HashMap<String, ProcesamMig> CargarSalidas(String filename) throws IOException{
        HashMap<String, ProcesamMig> d1 = new HashMap<>();
        
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "ISO-8859-1"));
        String cadena = in.readLine();
        try {
            while ((cadena = in.readLine()) != null) {
                String[] p1 = cadena.split(";");
                int valor = 1;
                if (p1[0].equals("Salida")){
                    if (!d1.containsKey(p1[3])){
                        d1.put(p1[3], new ProcesamMig(new JefaturaMig(p1[3],p1[4]),valor));
                    }else{
                        d1.get(p1[3]).setCantidad(d1.get(p1[3]).getCantidad()+1);
                    } 
                }     
            }
        } catch (IOException | NumberFormatException e) {

        } finally {
            in.close();
        }        //System.out.println(d1);
    return d1;
    }  
}