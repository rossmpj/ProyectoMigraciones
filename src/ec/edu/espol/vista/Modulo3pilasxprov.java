/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.vista;

import ec.edu.espol.main.VistaModulo3;
import static ec.edu.espol.vista.Modulo3.propertiesTableView;
import static ec.edu.espol.vista.Modulo3.showPilas;
import espol.edu.ec.tdas.ProcesamMig;
import espol.edu.ec.tdas.Stacks;
import java.io.IOException;
import java.util.Deque;
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
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author ROSA
 */
public class Modulo3pilasxprov {
    private final BorderPane root1;
    
    public BorderPane getRoot1() {
        return root1;
    }
    
    public Modulo3pilasxprov() throws IOException {  
        root1 = new BorderPane();        
        BackgroundFill myBF = new BackgroundFill(Color.DEEPSKYBLUE, new CornerRadii(1), new Insets(0.0,0.0,0.0,0.0));
        root1.setBackground(new Background(myBF));
        crearSeccionTitulo();
        crearSeccionEntradas();
        //crearBotonProcesar();
        //crearSeccionSalidas();
    }
    
    private void crearSeccionTitulo(){
        HBox hbox = new HBox();
        Label titleLbl = new Label("Provincias con mayor registro migratorio"); 
        hbox.getChildren().add(titleLbl); 
        titleLbl.setFont(new Font("Courier New", 47));
        titleLbl.setStyle("-fx-text-fill: black;" );
        hbox.setAlignment(Pos.TOP_CENTER);
        hbox.setPadding(new Insets(40, 10, 0, 40));
        root1.setTop(hbox);
    } 
    
    private void crearSeccionEntradas() throws IOException{
        Stacks pilasEntradas = new Stacks();     
        VBox contenedor = new VBox();
        HBox hB1 = new HBox();
        
        VBox vB1 = crearContenedores("Costa/Entradas",pilasEntradas.getCosta_E());
        VBox vB2 = crearContenedores("Sierra/Entradas",pilasEntradas.getSierra_E());
        VBox vB3 = crearContenedores("Oriente/Entradas",pilasEntradas.getOriente_E());
        VBox vB4 = crearContenedores("Insular/Entradas",pilasEntradas.getInsular_E());  
        hB1.getChildren().addAll(vB1, vB2, vB3, vB4);
        
        contenedor.getChildren().addAll(hB1,crearSeccionSalidas() );
        
        hB1.setAlignment(Pos.CENTER);
        contenedor.setAlignment(Pos.CENTER);
        root1.setCenter(contenedor); 
        Button bt = crearBotonProcesar();
        
        VBox v = new VBox();
        v.getChildren().add(bt);
        v.setAlignment(Pos.CENTER);
        root1.setBottom(v);
        v.setPadding(new Insets(0,0,50,0)); //bordes arriba, derecha, abajo, izquierda
    }
     
    private HBox crearSeccionSalidas() throws IOException{
        Stacks pilasSalidas = new Stacks();  
        HBox hB = new HBox();
        HBox hB1 = new HBox();
         
        VBox vB1 = crearContenedores("Costa/Salidas",pilasSalidas.getCosta_S());
        VBox vB2 = crearContenedores("Sierra/Salidas",pilasSalidas.getSierra_S());
        VBox vB3 = crearContenedores("Oriente/Salidas",pilasSalidas.getOriente_S());
        VBox vB4 = crearContenedores("Insular/Salidas",pilasSalidas.getInsular_S()); 
        hB1.getChildren().addAll(vB1, vB2, vB3, vB4);
        
        hB.getChildren().add(hB1);
        hB1.setAlignment(Pos.CENTER);
        hB.setAlignment(Pos.CENTER);
        //root1.setBottom(hB1);
        return hB1;
        //hB.setPadding(new Insets(0,30,60,0)); //bordes arriba, derecha, abajo, izquierda
    }   
        
    private VBox crearContenedores(String nameType, Deque<ProcesamMig> deq){
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(0,30,20,0));
        vbox.getChildren().add(crearTabla(nameType,showPilas(deq))); 
        return vbox;
    }
       
    private TableView crearTabla(String tipo, ObservableList<ProcesamMig> dat){
        TableView t = new TableView();
        TableColumn c = new TableColumn(tipo);
        TableColumn c1_prov = new TableColumn("Provincia");
        TableColumn c2_cant = new TableColumn("Cantidad");
        c1_prov.setPrefWidth(125);
        c2_cant.setPrefWidth(98);
        c1_prov.setCellValueFactory(new PropertyValueFactory<>("jefat"));
        c2_cant.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        c.getColumns().addAll(c1_prov, c2_cant);
        t.setPrefSize(225,200);
        t.setEditable(false);
        propertiesTableView(c1_prov);
        propertiesTableView(c);
        propertiesTableView(c2_cant);
        t.getColumns().addAll(c);
        t.setItems(dat);
        return t;
    }
    
    private Button crearBotonProcesar(){
        Button bt = new Button("Procesar");
        bt.setPrefSize(65, 35);
        bt.setOnAction(e -> {
            Modulo3 pr;
            try {
                pr = new Modulo3();
                VistaModulo3.scene.setRoot(pr.getRoot1());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });
        return bt;
    }
}