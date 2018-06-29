/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.vista;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author ROSA
 */
public class Modulo3 {
    private final BorderPane root1;
    public static TableView tv;
    public static ObservableList<ProcesamMig> data;
    
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
        Stacks controlador = new Stacks();      
        showPilas(controlador.getPila_E());
        VBox vB = new VBox();
        crearTabla("Entradas");   
        vB.getChildren().add(tv);
        root1.setLeft(vB);              
        vB.setPadding(new Insets(20,30,50,100)); //bordes arriba, derecha, abajo, izquierda
    }
       
    private void crearSeccionSalidas() throws IOException{
        Stacks controlador = new Stacks();      
        showPilas(controlador.getPila_S());
        VBox vB = new VBox();
        crearTabla("Salidas");    
        vB.getChildren().add(tv);
        root1.setRight(vB);    
        vB.setPadding(new Insets(20,100,50,30));
    }   
    
    public void showPilas(Deque<ProcesamMig> p){    
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
        data = FXCollections.observableArrayList(q); 
    }
    
    private void crearTabla(String tipo){
        tv = new TableView();
        TableColumn c = new TableColumn(tipo);
        TableColumn c1_prov = new TableColumn("Provincia");
        TableColumn c2_cant = new TableColumn("Cantidad");
        c1_prov.setPrefWidth(250);
        c2_cant.setPrefWidth(248);
        c1_prov.setCellValueFactory(new PropertyValueFactory<>("jefat"));
        c2_cant.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        c.getColumns().addAll(c1_prov, c2_cant);
        tv.setPrefSize(500,9000);
        tv.setEditable(false);
        propertiesTableView(c1_prov);
        propertiesTableView(c);
        propertiesTableView(c2_cant);
        tv.getColumns().addAll(c);
        tv.setItems(data);
    }
    
    private void propertiesTableView(TableColumn c){
        c.setSortable(false);
        c.setResizable(false);
        c.setEditable(false);
    }
}