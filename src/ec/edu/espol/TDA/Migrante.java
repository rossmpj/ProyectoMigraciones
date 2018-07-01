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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Tiffy
 */
public class Migrante implements Comparable<Migrante> {

    private String nombres, ci_pasaporte, nacionalidad, ocupacion, sexo, discapacitado;
    private LocalDate fechaNacimiento;
    private List<RegistroMigratorio> rmig = new LinkedList();

    public Migrante() {
    }

    public Migrante(String ci_pasaporte, String nombres, String nacionalidad, String sexo, LocalDate fechaNaci, String ocupacion, String discapac) {
        this.ci_pasaporte = ci_pasaporte;
        this.nombres = nombres;
        this.nacionalidad = nacionalidad;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNaci;
        this.ocupacion = ocupacion;
        this.discapacitado = discapac;

    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCi_pasaporte() {
        return ci_pasaporte;
    }

    public void setCi_pasaporte(String ci_pasaporte) {
        this.ci_pasaporte = ci_pasaporte;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDiscapacitado() {
        return discapacitado;
    }

    public void setDiscapacitado(String discapacitado) {
        this.discapacitado = discapacitado;
    }

    public List<RegistroMigratorio> getRmig() {
        return rmig;
    }

    public void setRmig(List<RegistroMigratorio> rmig) {
        this.rmig = rmig;
    }

    public static void almacenarMigrante(List<Migrante> migrante) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(CONSTANTES.pathArchivoMigracion))) {
            for (Migrante m : migrante) {
                String line = m.getCi_pasaporte() + "," + m.getNombres() + "," + m.getNacionalidad() + "," + m.getSexo() + "," + m.getFechaNacimiento() + "," + m.getOcupacion() + "," + m.getDiscapacitado();
                br.write(line);
                br.newLine();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    

    public static List<Migrante> leerMigrantes() {
        List<Migrante> migrante = new LinkedList<Migrante>();
        try (BufferedReader br = new BufferedReader(new FileReader(CONSTANTES.pathArchivoMigracion))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                LocalDate localDate = LocalDate.parse(p[4], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                migrante.add(new Migrante(p[0], p[1], p[2], p[3], localDate, p[5], p[6]));
            }
        } catch (FileNotFoundException o) {
            System.out.println(o.getMessage());
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return migrante;
    }

    public int compareTo(Migrante e) {
        return nombres.compareToIgnoreCase(e.nombres);
    }

    public static Migrante buscarMigrante(List<Migrante> migrante, String cedula)  {
        for (Migrante m : migrante) {
            if (m.getCi_pasaporte().equals(cedula)) {
                return m;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return ci_pasaporte + "," + nombres
                + "," + nacionalidad + "," + sexo + ","
                + fechaNacimiento + "," + ocupacion + "," + discapacitado;
    }

}
