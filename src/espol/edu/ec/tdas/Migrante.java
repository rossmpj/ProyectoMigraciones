/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.tdas;

/**
 *
 * @author ROSA
 */
public class Migrante {
    private String nacionalidad;
    private String sexo;
    private String ocupacion;
    private String anioNac;
    private int edad;
    private String claseMig;

    public Migrante(String nacionalidad, String sexo, String ocupacion, String anioNac, int edad, String claseMig) {
        this.nacionalidad = nacionalidad;
        this.sexo = sexo;
        this.ocupacion = ocupacion;
        this.anioNac = anioNac;
        this.edad = edad;
        this.claseMig = claseMig;
    }
    
    public Migrante(){}

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getAnioNac() {
        return anioNac;
    }

    public void setAnioNac(String anioNac) {
        this.anioNac = anioNac;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getClaseMig() {
        return claseMig;
    }

    public void setClaseMig(String claseMig) {
        this.claseMig = claseMig;
    }

    @Override
    public String toString() {
        return "Migrante{" + "nacionalidad=" + nacionalidad + ", sexo=" + sexo + ", ocupacion=" + ocupacion + ", anioNac=" + anioNac + ", edad=" + edad + ", claseMig=" + claseMig + '}';
    }
    
    
}
