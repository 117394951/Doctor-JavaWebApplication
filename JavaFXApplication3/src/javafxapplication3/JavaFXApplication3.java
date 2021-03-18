/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author becca
 */
public class JavaFXApplication3 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(10);
        root.setHgap(10);
        
        Label lblID = new Label("ID");
        root.add(lblID,0,0);
        TextField txtID = new TextField();
        root.add(txtID, 1,0);
        Button btnSave = new Button("Save");
        root.add(btnSave, 0,1);
        Button btnLoad = new Button("Load");
        root.add(btnLoad, 1,1);
        Button btnClear = new Button("Clear");
        root.add(btnClear, 2,1);
        
        Scene stage = new Scene(root, 500,500);
        primaryStage.setScene(stage);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
