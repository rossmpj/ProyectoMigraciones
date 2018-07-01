/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.main;

import ec.edu.espol.vista.Modulo3;
import ec.edu.espol.vista.Modulo3pilasxprov;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ROSA
 */
public class VistaModulo3 extends Application {
        public static Scene scene;
    @Override
    public void start(Stage primaryStage) throws IOException {
        scene = new Scene(new Group(), 1400, 700);
        Modulo3pilasxprov root = new Modulo3pilasxprov();
        scene.setRoot(root.getRoot1());
        primaryStage.setTitle("Módulo 3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    } 
}