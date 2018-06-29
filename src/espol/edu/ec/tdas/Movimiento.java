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
public class Movimiento {
    private String tipo;
    private String añoNac;
    private String mesNac;
    private String DiaNac;
    private String motivo;

    public Movimiento(String tipo, String añoNac, String mesNac, String DiaNac, String motivo) {
        this.tipo = tipo;
        this.añoNac = añoNac;
        this.mesNac = mesNac;
        this.DiaNac = DiaNac;
        this.motivo = motivo;
    }
    
    public Movimiento(){}

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAñoNac() {
        return añoNac;
    }

    public void setAñoNac(String añoNac) {
        this.añoNac = añoNac;
    }

    public String getMesNac() {
        return mesNac;
    }

    public void setMesNac(String mesNac) {
        this.mesNac = mesNac;
    }

    public String getDiaNac() {
        return DiaNac;
    }

    public void setDiaNac(String DiaNac) {
        this.DiaNac = DiaNac;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "tipo=" + tipo + ", añoNac=" + añoNac + ", mesNac=" + mesNac + ", DiaNac=" + DiaNac + ", motivo=" + motivo + '}';
    }

    
}
