/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class FXMLListAbonneController implements Initializable {
  @FXML
    private Hyperlink re5;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         re5.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
          try {
                    re5.getScene().setRoot(FXMLLoader.load(getClass().getResource("FXMLparticipate.fxml")));
                } 
            catch (IOException ex) {
                   Logger.getLogger(FXMLListAbonneController.class.getName()).log(Level.SEVERE, null, ex);
               }

       }
       });
        // TODO
    }    
    
}
