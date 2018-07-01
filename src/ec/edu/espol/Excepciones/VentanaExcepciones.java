/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.Excepciones;

import javafx.scene.control.Alert;

/**
 *
 * @author Tiffy
 */
public class VentanaExcepciones {
    /**
     * Método que permitirá mostrar una ventana cuando se produzca una excepcion
     */
    public static void VentanaProblemasTecnicos(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Lo sentimos, estamos teniendo inconvenientes técnicos");
        alert.showAndWait();
    }
    
}
