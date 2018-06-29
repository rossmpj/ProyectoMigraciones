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
public class TipoNacionalidad {
    private String tipoNac;

    public TipoNacionalidad(String tipoNac) {
        this.tipoNac = tipoNac;
    }
    
    public TipoNacionalidad() {}

    public String getTipoNac() {
        return tipoNac;
    }

    public void setTipoNac(String tipoNac) {
        this.tipoNac = tipoNac;
    }

    @Override
    public String toString() {
        return "NacionalidadT{" + "tipoNac=" + tipoNac + '}';
    }
    
    
}
