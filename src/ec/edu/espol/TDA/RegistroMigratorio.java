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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Tiffy
 */
public class RegistroMigratorio implements Comparable<RegistroMigratorio> {

    private Migrante migrante;
    private LocalDate fecha_mov;
    private String clase_migratoria, tipo, cedula;
    private Motivo motivo;
    private Transporte transporte;
    private Provincia p;
    private int codregistro, codProv;

    public RegistroMigratorio() {
    }

    public RegistroMigratorio(String tipo, String cedula, int codProv, LocalDate fecha, Motivo mot, Transporte trans) {
        this.tipo = tipo;
        this.cedula = cedula;
        this.codProv = codProv;
        this.fecha_mov = fecha;
        this.motivo = mot;
        this.transporte = trans;
        this.codregistro = codigoAleatorio();
        this.p = null;
        this.migrante = null;
    }

    public RegistroMigratorio(int co, String tipo, String cedula, int ciudad, LocalDate fecha, Motivo mot, Transporte trans) {
        this.tipo = tipo;
        this.fecha_mov = fecha;
        this.motivo = mot;
        this.transporte = trans;
        this.codregistro = co;
        this.cedula = cedula;
        this.codProv = ciudad;
    }
    private int codigoAleatorio() {
        SecureRandom sr = new SecureRandom();
        return sr.nextInt(Integer.MAX_VALUE);
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getCodProv() {
        return codProv;
    }

    public void setCodProv(int codProv) {
        this.codProv = codProv;
    }

    public Migrante getMigrante() {
        return migrante;
    }

    public Provincia getP() {
        return p;
    }

    public void setP(Provincia p) {
        this.p = p;
    }

    public void setMigrante(Migrante migrante) {
        this.migrante = migrante;
    }

    public LocalDate getFecha_mov() {
        return fecha_mov;
    }

    public void setFecha_mov(LocalDate fecha_mov) {
        this.fecha_mov = fecha_mov;
    }

    public String getClase_migratoria() {
        return clase_migratoria;
    }

    public void setClase_migratoria(String clase_migratoria) {
        this.clase_migratoria = clase_migratoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Motivo getMotivo() {
        return motivo;
    }

    public void setMotivo(Motivo motivo) {
        this.motivo = motivo;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public int getCodregistro() {
        return codregistro;
    }

    public void setCodregistro(int codregistro) {
        this.codregistro = codregistro;
    }

    @Override
    public String toString() {
        return codregistro + "," + tipo + "," + cedula + "," + codProv + "," + fecha_mov + "," + motivo + "," + transporte;
    }

    public int compareTo(RegistroMigratorio m) {
        return this.fecha_mov.compareTo(m.getFecha_mov());
    }

    public static void almacenarRegistro(List<RegistroMigratorio> rmig) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(CONSTANTES.pathArchivoRegistro))) {
            for (RegistroMigratorio m : rmig) {
                String line = m.getCodregistro() + "," + m.getTipo() + "," + m.getCedula() + "," + m.getCodProv() + "," + m.getFecha_mov() + "," + m.getMotivo() + "," + m.getTransporte();
                br.write(line);
                br.newLine();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static List<RegistroMigratorio> leerRegistroMigratorio() {
        List<RegistroMigratorio> registro = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CONSTANTES.pathArchivoRegistro))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                LocalDate localDate1 = LocalDate.parse(p[4], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                registro.add(new RegistroMigratorio(Integer.parseInt(p[0]), p[1], p[2], Integer.parseInt(p[3]), localDate1, Motivo.valueOf(p[5]), Transporte.valueOf(p[6])));
            }
        } catch (FileNotFoundException o) {
            System.out.println(o.getMessage());
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return registro;
    }

    public void vincular(List<Migrante> migrantes, List<Provincia> provincias, List<RegistroMigratorio> registro) {
        for (RegistroMigratorio rg : registro) {
            Migrante mi = Migrante.buscarMigrante(migrantes, rg.getCedula());
            Provincia pr = Provincia.buscarProvincia(provincias, rg.getCodProv());
            if(pr!=null){
                  rg.setMigrante(mi);
                  mi.getRmig().add(rg);
            rg.setP(pr);
            pr.getRmigra().add(rg);

        }
        }
    }

    public static void ModificarRegistro() {

    }
}
