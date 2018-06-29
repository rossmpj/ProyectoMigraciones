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
public class Transporte {
    private String via;

    public Transporte(String via) {
        this.via = via;
    }

    public Transporte() {
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    @Override
    public String toString() {
        return "Transporte{" + "via=" + via + '}';
    }
    
}
