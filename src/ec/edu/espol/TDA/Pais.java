/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.TDA;

import ec.edu.espol.Modelo.CONSTANTES;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Tiffy
 */
public class Pais {

    private String nombre, continente;
    private int codpais;
    private List<Provincia> provincias = new LinkedList();

    public Pais() {
        
    }
    public Pais(String nombre, String continente){
        this.nombre= nombre;
        this.continente= continente;
        this.codpais=codigoAleatorio();
    }
    public Pais(int cod,String nombre, String continente){
        this.codpais=cod;
        this.nombre= nombre;
        this.continente= continente;
    }
       private int codigoAleatorio(){
    SecureRandom sr= new SecureRandom();
    return sr.nextInt(Integer.MAX_VALUE);
    }
    
    public static void almacenarPais(List<Pais> pa){
     try (BufferedWriter br = new BufferedWriter(new FileWriter(CONSTANTES.pathArchivoPais))) {
            for (Pais p : pa) {
                String line = p.getCodpais() + "," + p.nombre+ "," + p.continente;
                br.write(line);
                br.newLine();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public static List<Pais> leerPais (){
    List<Pais> pais = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CONSTANTES.pathArchivoPais))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                pais.add(new Pais(Integer.parseInt(p[0]), p[1], p[2]));
            }
        } catch (FileNotFoundException o) {
            System.out.println(o.getMessage());
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return pais;
    }
    
     public static Pais buscarPais(List<Pais> pais, int codPais)  {
        for (Pais p : pais) {
            if (p.getCodpais()== codPais) {
                return p;
            }
        }
        return null;
    }

    public int getCodpais() {
        return codpais;
    }

    public void setCodpais(int codpais) {
        this.codpais = codpais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }

    @Override
    public String toString() {
        return codpais +","+nombre + "," + continente;
    }

}
