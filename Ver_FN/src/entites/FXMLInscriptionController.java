/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import GereEvenement.GestionEvenement;
import GereEvenement.GestionInscription;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class FXMLInscriptionController implements Initializable {
@FXML
private Hyperlink btnre;
@FXML
private Button btninsci;
@FXML
private TextField nom;
@FXML
private TextField  prenom;
@FXML
private TextField email;
@FXML
private TextField  telep;
@FXML
private TextField  age;
 @FXML
    private ComboBox<String>  Age;
@FXML
private CheckBox cbox;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList<String>  ComboList = FXCollections.observableArrayList("10","15","20","25","30");
        Age.setItems(ComboList);
        // TODO
         btnre.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
          try {
                    btnre.getScene().setRoot(FXMLLoader.load(getClass().getResource("FXMLparticipate.fxml")));
                } 
            catch (IOException ex) {
                   Logger.getLogger(FXMLInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
               }

       }
       });
         btninsci.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
           GestionInscription es = new  GestionInscription();
               //Random r =new Random();
               //int valeur=1000+r.nextInt(9999-1000);
               //Evenement Evenement = new Evenement();
              // if(nom_even.getText().equals(nom_even)){
               
        
                Inscription i= new Inscription(nom.getText(),prenom.getText(),email.getText(),
                        Integer.parseInt(telep.getText()),Integer.parseInt(Age.getValue()));
               //try {
                 if(cbox.isSelected()) { 
                     es.creerInscription(i);
                     vider ();
                 }
                  
                   //alert.setText("ajout ok"); 
                   //vider ();      
       }
    }  );
         
     

    }
public void vider () {
    
    
    nom.setText("");  
    prenom.setText("");
    email.setText(""); 
    telep.setText("");
   //age.setText("");
 Age.setValue("");

    }
}