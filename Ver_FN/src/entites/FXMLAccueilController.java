
package entites;

import GereEvenement.GestionEvenement;
import entites.Evenement;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import utils.ConnexionBDSingleton;

/**
 *
 * @author Mohamed
 */

    
   public class FXMLAccueilController implements Initializable {
    @FXML
    private Button btnAffi;
    @FXML
    private Button btnCree;
     @FXML
    private Button  btnParti;
    @FXML
    private Button btnU1;
   
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    public void initialize(URL url, ResourceBundle rb) {
    
           
     btnAffi.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
          try {
                    btnAffi.getScene().setRoot(FXMLLoader.load(getClass().getResource("FXMLafficherEven.fxml")));
                } 
            catch (IOException ex) {
                   Logger.getLogger(FXMLajoutController.class.getName()).log(Level.SEVERE, null, ex);
               }

       }
       });
        btnCree.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
          try {
                    btnCree.getScene().setRoot(FXMLLoader.load(getClass().getResource("FXMLajo.fxml")));
                } 
            catch (IOException ex) {
                   Logger.getLogger(FXMLajoutController.class.getName()).log(Level.SEVERE, null, ex);
               }

       }
       }); 
        btnParti.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
          try {
                    btnParti.getScene().setRoot(FXMLLoader.load(getClass().getResource("FXMLparticipate.fxml")));
                } 
            catch (IOException ex) {
                   Logger.getLogger(FXMLajoutController.class.getName()).log(Level.SEVERE, null, ex);
               }

       }
       }); 
         btnU1.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
          try {
                    btnU1.getScene().setRoot(FXMLLoader.load(getClass().getResource("FXMLUpdate.fxml")));
                } 
            catch (IOException ex) {
                   Logger.getLogger(FXMLajoutController.class.getName()).log(Level.SEVERE, null, ex);
               }

       }
       }); 
        
   }
   }