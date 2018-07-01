/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.Excepciones;

/**
 *
 * @author Tiffy
 */
public class ObjectNotFoundException extends Exception{
    /**
     * Constructor de la clase
     */
    public ObjectNotFoundException(){
    super("Registro no existe");
    }
}
