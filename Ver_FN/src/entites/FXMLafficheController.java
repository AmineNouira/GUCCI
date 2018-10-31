package entites;

import GereEvenement.GestionEvenement;
import entites.Evenement;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 * FXML Controller class
 *
 * @author mohamed
 */
public class FXMLafficheController implements Initializable {

    GestionEvenement GE= new GestionEvenement();
        Evenement E=new Evenement();
       
        //vider();
        
    @FXML
    private TableView<Evenement> table;
     @FXML
    private TextField Chercher;
    @FXML
    private TableColumn<Evenement,Integer> idColumn;
    @FXML
    private TableColumn<Evenement, String> nomColumn;
    @FXML
    private TableColumn<Evenement, String> OrganisateurColumn;
    @FXML
    private TableColumn<Evenement, String> CatégorieColumn;
    @FXML
    private TableColumn<Evenement, String> DateColumn;
     @FXML
    private TableColumn<Evenement, String> heurecolumn;
      @FXML
    private TableColumn<Evenement, String> Lieucolumn;
       @FXML
    private TableColumn<Evenement, String> Descriptioncolumn;
       @FXML
    private TableColumn<Evenement, String> imagecolumn;
     @FXML
    private static ObservableList<Evenement> Olist;
      @FXML
    private Hyperlink  hy2;
       private ObservableList<Evenement> list_Article,AllArticle_List ;
    /**
     * Initializes the controller class.
     */
      GestionEvenement ge=new GestionEvenement();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
          idColumn.setCellValueFactory(new PropertyValueFactory<>("id_even"));
            OrganisateurColumn.setCellValueFactory(new PropertyValueFactory<>("Organisateur"));
            nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom_even"));
            CatégorieColumn.setCellValueFactory(new PropertyValueFactory<>("Catégorie_even"));
            heurecolumn.setCellValueFactory(new PropertyValueFactory<>("heure"));
            Lieucolumn.setCellValueFactory(new PropertyValueFactory<>("lieu"));
            Descriptioncolumn.setCellValueFactory(new PropertyValueFactory<>("Description"));
            imagecolumn.setCellValueFactory(new PropertyValueFactory<>("image"));
        try { table.setItems(ge.displayAllEvenement()); } 
         catch (SQLException ex) {  }
      /*  
            GestionEvenement ge=new GestionEvenement();
            ArrayList<Evenement> evenss;
       try{
           
           evenss=(ArrayList<Evenement>) ge.getAllEvenements();   
           
           ObservableList Olist=FXCollections.observableArrayList(evenss);
            for (int i = 0; i < evenss.size(); i++) {
       Olist.add(evenss.get(i));
           System.out.println(evenss.get(i));
            
   }
           table.setItems(Olist);
           
           idColumn.setCellValueFactory(new PropertyValueFactory<>("id_even"));
            OrganisateurColumn.setCellValueFactory(new PropertyValueFactory<>("Organisateur"));
            nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom_even"));
            CatégorieColumn.setCellValueFactory(new PropertyValueFactory<>("Catégorie_even"));
            heurecolumn.setCellValueFactory(new PropertyValueFactory<>("heure"));
            Lieucolumn.setCellValueFactory(new PropertyValueFactory<>("lieu"));
            Descriptioncolumn.setCellValueFactory(new PropertyValueFactory<>("Description"));
            imagecolumn.setCellValueFactory(new PropertyValueFactory<>("image"));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLafficheController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
//System.out.println("mmmmmmmmmmmmmmmmmmm");
          
            
            
            
            
            
            
            
        */    
            
            
            
             hy2.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
          try {
                    hy2.getScene().setRoot(FXMLLoader.load(getClass().getResource("FXMLAccueil.fxml")));
                } 
            catch (IOException ex) {
                   Logger.getLogger(FXMLajoutController.class.getName()).log(Level.SEVERE, null, ex);
               }

       }
       });
    } 
    
  @FXML
    private void Miseajour() {
        //vide();
        try{
        table.setItems(GE.displayAllEvenement());
        } catch (SQLException ex) {
            
        }
        
    }

    
        @FXML
    private void Search(ActionEvent event) {
            System.out.println("entites.FXMLafficheController.Search()");
         try {        
          table.setItems(GE.Search(Chercher.getText()));
        } catch (SQLException ex) {
             System.out.println(ex);
        } 
    }
}
