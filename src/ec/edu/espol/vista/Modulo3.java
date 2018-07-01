/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.vista;

import ec.edu.espol.main.VistaModulo3;
import espol.edu.ec.tdas.ProcesamMig;
import espol.edu.ec.tdas.Stacks;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author ROSA
 */
public class Modulo3 {
    private final BorderPane root1;
    
    public BorderPane getRoot1() {
        return root1;
    }
    
    public Modulo3() throws IOException {  
        root1 = new BorderPane();        
        BackgroundFill myBF = new BackgroundFill(Color.DEEPSKYBLUE, new CornerRadii(1),
        new Insets(0.0,0.0,0.0,0.0));
        root1.setBackground(new Background(myBF));
        crearSeccionTitulo();
        crearSeccionEntradas();
        crearSeccionSalidas();
        seccionBotones();
    }
    
    private void crearSeccionTitulo(){
        HBox hbox = new HBox();
        Label titleLbl = new Label("Provincias con mayor registro migratorio"); 
        hbox.getChildren().add(titleLbl); 
        titleLbl.setFont(new Font("Courier New", 47));
        titleLbl.setStyle("-fx-text-fill: black;" );
        hbox.setAlignment(Pos.TOP_CENTER);
        hbox.setPadding(new Insets(40, 10, 25, 40));
        root1.setTop(hbox);
    } 
    
    private void crearSeccionEntradas() throws IOException{
        Stacks entradasProcesadas = new Stacks();      
        VBox vB = new VBox();
        TableView tablaE = crearTabla("Entradas", showPilas(entradasProcesadas.getPila_E()));   
        vB.getChildren().add(tablaE);
        root1.setLeft(vB);              
        vB.setPadding(new Insets(20,50,50,150)); //bordes arriba, derecha, abajo, izquierda
    }
       
    private void crearSeccionSalidas() throws IOException{
        Stacks salidasProcesadas = new Stacks();  
        VBox vB = new VBox();
        TableView tablaS = crearTabla("Salidas",showPilas(salidasProcesadas.getPila_S()));    
        vB.getChildren().add(tablaS);
        root1.setRight(vB);    
        vB.setPadding(new Insets(20,150,50,50));
    }   
    
    private void seccionBotones(){
        Button bt = crearBotonRegresar();
        VBox v = new VBox();
        v.getChildren().add(bt);
        v.setAlignment(Pos.CENTER);
        v.setPadding(new Insets(0,0,50,0)); //bordes arriba, derecha, abajo, izquierda
        root1.setBottom(v);
    }
    
    public static ObservableList<ProcesamMig> showPilas(Deque<ProcesamMig> p){    
        Deque<ProcesamMig> d = new LinkedList<>();
        Deque<ProcesamMig> d1 = new LinkedList<>();
        while(!p.isEmpty()){
            d.push(p.peek());
            d1.push(p.pop());
        }
        while(!d1.isEmpty()){
            p.push(d1.pop());
        }
        List<ProcesamMig> q = new ArrayList<>();
        while (!d.isEmpty()){
            q.add(d.pop());
        }     
        ObservableList<ProcesamMig> dat = FXCollections.observableArrayList(q); 
        return dat;
    }   
         
    private TableView crearTabla(String tipo, ObservableList<ProcesamMig> dat){
        TableView t = new TableView();
        TableColumn c = new TableColumn(tipo);
        TableColumn c1_prov = new TableColumn("Provincia");
        TableColumn c2_cant = new TableColumn("Cantidad");
        c1_prov.setPrefWidth(250);
        c2_cant.setPrefWidth(248);
        c1_prov.setCellValueFactory(new PropertyValueFactory<>("jefat"));
        c2_cant.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        c.getColumns().addAll(c1_prov, c2_cant);
        t.setPrefSize(500, 9000);
        t.setEditable(false);
        propertiesTableView(c1_prov);
        propertiesTableView(c);
        propertiesTableView(c2_cant);
        t.getColumns().addAll(c);
        t.setItems(dat);
        return t;
    }
        
    public static void propertiesTableView(TableColumn c){
        c.setSortable(false);
        c.setResizable(false);
        c.setEditable(false);
    }
    
      private Button crearBotonRegresar(){
        Button bt = new Button("Volver");
        bt.setPrefSize(65, 35);
        bt.setOnAction(e -> {
            Modulo3pilasxprov pr;
            try {
                pr = new Modulo3pilasxprov();
                VistaModulo3.scene.setRoot(pr.getRoot1());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });
        return bt;
    }
}