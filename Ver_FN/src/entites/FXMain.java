/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Wadii Chamakhi
 */
public class FXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
       
       //Parent root = FXMLLoader.load(getClass().getResource("../entites/FXMLajo.fxml"));
      Parent root = FXMLLoader.load(getClass().getResource("../entites/FXMLAccueil.fxml"));
        // Parent root = FXMLLoader.load(getClass().getResource("../entites/FXMLafficherEven.fxml"));
         //Parent root = FXMLLoader.load(getClass().getResource("../entites/FXMLUpdate.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Evénement");
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
