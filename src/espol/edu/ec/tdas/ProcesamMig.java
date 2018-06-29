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
public class ProcesamMig implements Comparable<ProcesamMig>{
    private JefaturaMig jefat;
    private String provin;
    private int cantidad;

    public ProcesamMig(JefaturaMig jefat, int cantidad) {
        this.jefat = jefat;
        this.cantidad = cantidad;
    }
    public ProcesamMig(String provincia, int cantidad) {
        this.provin = provincia;
        this.cantidad = cantidad;
    }

    public ProcesamMig() {
    }

    public JefaturaMig getJefat() {
        return jefat;
    }

    public void setJefat(JefaturaMig jefat) {
        this.jefat = jefat;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Provincia: " +jefat.getProvincia() + ", cantidad: " + cantidad + "}\n";
    }

    @Override
    public int compareTo(ProcesamMig t) {
        if (t.getCantidad() > this.cantidad){
            return 1;
        }else if(t.getCantidad() == this.cantidad){
            return 0;
        }else{
            return -1;
    }
        
    }
}
