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
public class Registro {
    private Movimiento m;
    private Migrante mi;
    private TipoNacionalidad n;
    private Transporte t;
    private JefaturaMig j;

    public Movimiento getM() {
        return m;
    }

    public void setM(Movimiento m) {
        this.m = m;
    }

    public Migrante getMi() {
        return mi;
    }

    public void setMi(Migrante mi) {
        this.mi = mi;
    }

    public TipoNacionalidad getN() {
        return n;
    }

    public void setN(TipoNacionalidad n) {
        this.n = n;
    }

    public Transporte getT() {
        return t;
    }

    public void setT(Transporte t) {
        this.t = t;
    }

    public JefaturaMig getJ() {
        return j;
    }

    public void setJ(JefaturaMig j) {
        this.j = j;
    }
    
    public Registro(JefaturaMig j, TipoNacionalidad n, Transporte t, Movimiento m, Migrante mi){
        this.m = m;
        this.mi = mi;
        this.n = n;
        this.t = t;
        this.j = j;
    }
    
    public Registro(){}
    
    
    public Registro(JefaturaMig j){
        this.j = j;
    }
}
