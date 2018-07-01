/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.tdas;

import ec.edu.espol.TDA.Pais;
import static ec.edu.espol.TDA.Pais.buscarPais;
import static ec.edu.espol.TDA.Pais.leerPais;
import ec.edu.espol.TDA.Provincia;
import static ec.edu.espol.TDA.Provincia.buscarProvincia;
import static ec.edu.espol.TDA.Provincia.leerProvincias;
import ec.edu.espol.TDA.RegistroMigratorio;
import static ec.edu.espol.TDA.RegistroMigratorio.leerRegistroMigratorio;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author ROSA
 */
public class Data1 implements Serializable{
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

    public Data1(){}
    
    public Data1(JefaturaMig j, Movimiento m){
        this.m = m;
        this.j = j;
    }
    public Data1(String t, Movimiento m){
        this.m = m;
        this.tipo = t;
    }
    public Data1(JefaturaMig j){
        this.j = j;
    }
    
    public Data1(String t){
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
    
    public HashMap<String, ProcesamMig> CargarEntradasR(String filename) throws IOException{
        HashMap<String, ProcesamMig> d = new HashMap<>();
        List<RegistroMigratorio> list = leerRegistroMigratorio();
        System.out.println(list);
        /*while ((cadena = in.readLine()) != null) {
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
        }        //System.out.println(d);*/
       return d;
    }
   
    public HashMap<String, ProcesamMig> CargarEntradas(String filename) throws IOException{
        HashMap<String, ProcesamMig> d = new HashMap<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "ISO-8859-1"));
        String cadena = in.readLine();
        try {
            while ((cadena = in.readLine()) != null) {
                String[] p1 = cadena.split(";");
                int valor = 1;
                if (p1[0].equalsIgnoreCase("entrada") ){
                    if (!d.containsKey(p1[3].toLowerCase())){
                        d.put(p1[3].toLowerCase(), new ProcesamMig(new JefaturaMig(p1[3],p1[4]),valor));
                    }else{
                        d.get(p1[3].toLowerCase()).setCantidad(d.get(p1[3].toLowerCase()).getCantidad()+1);
                    }  
                }
            }            //System.out.println(d);
        List<RegistroMigratorio> registro = leerRegistroMigratorio();
        List<Provincia> listp = leerProvincias();
        List<Pais> pais = leerPais();
        for (RegistroMigratorio r : registro) {
            for (Pais pa : pais){
                Provincia p = buscarProvincia(listp, r.getCodProv());
                Pais pp = buscarPais(pais, pa.getCodpais());
                if (p.getCodPais() == pp.getCodpais()){
                    int valor = 1;
                    if(pp.getNombre().equalsIgnoreCase("ecuador") && r.getTipo().equalsIgnoreCase("entrada")){
                        if (!d.containsKey(p.getNombre().toLowerCase())){
                            d.put(p.getNombre().toLowerCase(), new ProcesamMig(new JefaturaMig(p.getNombre().toLowerCase()),valor));
                        }else{//int count  = d.get(p.getNombre().toLowerCase()).getCantidad();
                            d.get(p.getNombre().toLowerCase()).setCantidad(d.get(p.getNombre().toLowerCase()).getCantidad()+1);
                            }  
                        }  
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.print(e);
        } finally {
            in.close();
        }            //System.out.println(d);
        return d;
    }
    
    public HashMap<String, ProcesamMig> CargarSalidas(String filename) throws IOException{
        HashMap<String, ProcesamMig> d1 = new HashMap<>();
        
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "ISO-8859-1"));
        String cadena = in.readLine();
        try {
            while ((cadena = in.readLine()) != null) {
                String[] p1 = cadena.split(";");
                int valor = 1;
                if (p1[0].equalsIgnoreCase("salida")){
                    if (!d1.containsKey(p1[3].toLowerCase())){
                        d1.put(p1[3].toLowerCase(), new ProcesamMig(new JefaturaMig(p1[3],p1[4]),valor)); //p1[4] es el cantón
                    }else{
                        d1.get(p1[3].toLowerCase()).setCantidad(d1.get(p1[3].toLowerCase()).getCantidad()+1);
                    } 
                }     
            }
            
            List<RegistroMigratorio> registro = leerRegistroMigratorio();
        List<Provincia> listp = leerProvincias();
        List<Pais> pais = leerPais();
        
        for (RegistroMigratorio r : registro) {
            
            for (Pais pa : pais){
                Provincia p = buscarProvincia(listp, r.getCodProv());
                Pais pp = buscarPais(pais, pa.getCodpais());
                
                if (p.getCodPais() == pp.getCodpais()){
                    int valor = 1;
                    if(pp.getNombre().equalsIgnoreCase("ecuador") && r.getTipo().equalsIgnoreCase("salida")){
                        if (!d1.containsKey(p.getNombre().toLowerCase())){
                            d1.put(p.getNombre().toLowerCase(), new ProcesamMig(new JefaturaMig(p.getNombre().toLowerCase()),valor));
                        }else{
                            //int count  = d.get(p.getNombre().toLowerCase()).getCantidad();
                            //System.out.println(count);
                            d1.get(p.getNombre().toLowerCase()).setCantidad(d1.get(p.getNombre().toLowerCase()).getCantidad()+1);
                            }  
                        }  
                    }
                }
            }
        
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        } finally {
            in.close();
        }        //System.out.println(d1);
    return d1;
    }  
}