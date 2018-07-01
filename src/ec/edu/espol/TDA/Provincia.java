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
public class Provincia {

    private String nombre, region, codP;
    private int codprov, codPais;
    private Pais pais;
    private List<RegistroMigratorio> rmigra= new LinkedList();

    public Provincia() {
    }

    public Provincia(String nombre, String region, int p) {
        this.nombre = nombre;
        this.region = region;
        this.codPais = p;
        this.pais = null;
        this.codprov = codigoAleatorio();
        
    }

    public Provincia(int codprov, String nombre, String region, int p) {
        this.nombre = nombre;
        this.region = region;
        this.codPais = p;
        this.codprov = codprov;
    }

    private int codigoAleatorio() {
        SecureRandom sr = new SecureRandom();
        return sr.nextInt(Integer.MAX_VALUE);
    }

    public static void almacenarProvincia(List<Provincia> p) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(CONSTANTES.pathArchivoProvincias))) {
            for (Provincia m : p) {
                String line = m.getCodprov() + "," + m.getNombre() + "," + m.getRegion() + "," + m.codPais;
                br.write(line);
                br.newLine();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static List<Provincia> leerProvincias() {
        List<Provincia> provincia = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CONSTANTES.pathArchivoProvincias))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                provincia.add(new Provincia(Integer.parseInt(p[0]), p[1], p[2], Integer.parseInt(p[3])));
            }
        } catch (FileNotFoundException o) {
            System.out.println(o.getMessage());
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return provincia;
    }

    public static Provincia buscarProvincia(List<Provincia> provincias, int codProvincia) {
        for (Provincia p : provincias) {
            if (p.getCodprov() == codProvincia) {
                return p;
            }
        }
        return null;
    }

    public static void vincularProvinciaPais(List<Provincia> provincias, List<Pais> pais) {
        for (Provincia p : provincias) {
            Pais k= Pais.buscarPais(pais, p.getCodPais());
            if(k!= null){
                p.setPais(k);
                k.getProvincias().add(p);
            }
        }
    }

    

    public String getCodP() {
        return codP;
    }

    public void setCodP(String codP) {
        this.codP = codP;
    }

    public int getCodPais() {
        return codPais;
    }

    public void setCodPais(int codPais) {
        this.codPais = codPais;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodprov() {
        return codprov;
    }

    public void setCodprov(int codprov) {
        this.codprov = codprov;
    }

    public List<RegistroMigratorio> getRmigra() {
        return rmigra;
    }

    public void setRmigra(List<RegistroMigratorio> rmigra) {
        this.rmigra = rmigra;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return codprov + "," + nombre + "," + region + "," + codprov;
    }

}
