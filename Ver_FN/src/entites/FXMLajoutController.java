/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;
//import utils.Upload;
import GereEvenement.GestionEvenement;
import com.jfoenix.controls.JFXTextField;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.DirectionsPane;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.InfoWindow;
import com.lynden.gmapsfx.javascript.object.InfoWindowOptions;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.lynden.gmapsfx.service.directions.DirectionsService;
import com.lynden.gmapsfx.service.geocoding.GeocoderStatus;
import com.lynden.gmapsfx.service.geocoding.GeocodingResult;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import entites.Evenement;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import maps.java.Geocoding;
import utils.ConnexionBDSingleton;

/**
 *
 * @author Mohamed
 */

    
   public class FXMLajoutController implements Initializable,MapComponentInitializedListener  {
       @FXML
    private Label loc1a;
        @FXML
    private Label loc1l;
@FXML
    private TextField FilePath;
    @FXML
    private TextField id_even;
    @FXML
    private TextField nom_even;
    @FXML
    private TextField heure;
    @FXML
    private TextField lieu;
    @FXML
    private TextField image;
    @FXML
    private TextField Description;
    @FXML
    private TextField Organisateur;
   // @FXML
  //private TextField Catégorie_even;
    @FXML
    private ComboBox<String> Catégorie_even;
    @FXML
    private Button btn;
    @FXML
    private Button btnAffi;
    @FXML
    private Button btnCree;
    @FXML 
    private Hyperlink ret1;
    @FXML
    private ComboBox comb1;
     @FXML
    private Label alert;
    // @FXML
    //private DatePicker Date;
    @FXML
    private ImageView ImageE;
@FXML
    private Button bntimg;

@FXML
    private Label labelimage;
@FXML
    private WebView WebView ;
 @FXML
    private GoogleMapView mapView;
String path;
    boolean verificationImage=true;
    File selectedFile;
 public File dest ;
    public String source;

   private GeocodingService geocodingService;


    private MarkerOptions markerOptions;

    protected DirectionsService directionsService;

    protected DirectionsPane directionsPane;
 private StringProperty address = new SimpleStringProperty();
    
    protected StringProperty from = new SimpleStringProperty();
    protected StringProperty to = new SimpleStringProperty();  
    
    private GoogleMap map;
      public static double longi ; 
    public static double lat ; 
/*private File file;
 private Button File_Path;
 private Image image5;
 String pic;
   @FXML
    private JFXTextField path;*/
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
  /* @FXML
    private void BrowseImg(ActionEvent event) throws IOException{
        WritableImage Main_Img;
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("home");
        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.jpeg");fileChooser.getExtensionFilters().add(imageFilter);
        File file = fileChooser.showOpenDialog(null);
        
        BufferedImage bufferedImage = ImageIO.read(file);
        Main_Img = SwingFXUtils.toFXImage(bufferedImage, null);
        
         ImageE.setImage(Main_Img);
        image.setText(file.getName());
        
        //File_Path = file.getAbsolutePath();
        
        
    }*/
   /*private void imageUpload(ActionEvent event) throws IOException {
          
        FileChooser fileChooser = new FileChooser();
            file= fileChooser.showOpenDialog(null);
             FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

            path.setText("File:"+file);
            pic=(file.toURI().toString());
        //  pic=new Upload().upload(file,"uimg");
           //pic=new Upload().upload(file,"images");
            System.out.println(pic);
       //  image= new Image("http://localhost/uimg/"+pic);
           image5= new Image("http://localhost/bpPI/web/images"+pic);
          
    }*/
    
    
    
    
    @FXML
    private void LieuChanged2(ActionEvent event) {
         try {
         Geocoding ObjGeocoding=new maps.java.Geocoding();
          String Alt = null , Long = null  ;      
          Point2D.Double resultado=ObjGeocoding.getCoordinates(lieu.getText());
          Alt =  (String.valueOf(resultado.x));
          Long = (String.valueOf(resultado.y));
          WebEngine engine = WebView.getEngine();
          String url = "https://www.google.tn/maps/@"+Alt+","+Long+",15z?hl=fr";
          engine.load(url);
           System.out.println(url);
           } catch (Exception e) {
               System.out.println("controller.GestionEvent.LieuChanged()"+e);
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
      // comb1.GetItems().addAll("Assocication","Membre","Admin");
      mapView.addMapInializedListener(this);
        ObservableList<String>  ComboList = FXCollections.observableArrayList("Soire","Randoneé","Voyage","Foire","Theatre","Camping","Marathon","Autre");
        Catégorie_even.setItems(ComboList);
    
    bntimg.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "\\Desktop"));
        fc.setTitle("Veuillez choisir l'image"); //titre de la
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image", ".jpg", ".png"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg")
        );
        selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {
             source = selectedFile.getAbsolutePath();
            path = selectedFile.getName();
            
            
//                path = selectedFile.toURI().toURL().toExternalForm();
          Image image = new Image(selectedFile.toURI().toString());
           ImageE.setImage(image) ;
           FilePath.setText(selectedFile.toURI().toString());
            labelimage.setText(path);
              if(path.equals(""))
            {
            verificationImage=false;
            }
            else 
                  
              { verificationImage=true;}  
               


    }
    }});
 
       btn.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               GestionEvenement es = new GestionEvenement();
               Random r =new Random();
               int valeur=1000+r.nextInt(9999-1000);
               
               //Evenement Evenement = new Evenement();
              // if(nom_even.getText().equals(nom_even)){
               Evenement evenement = new Evenement(valeur,Organisateur.getText(),nom_even.getText(),Catégorie_even.getValue(),java.sql.Date.valueOf(LocalDate.now()),heure.getText(),lieu.getText(),Description.getText(),FilePath.getText());
               //try {
                  
                   es.creerEvenement6(evenement); 
                   alert.setText("ajout ok  ID Evénement :"+valeur);
                   vider ();
               //}else{
                //alert.setText(" evénement already exist "+"\n"+" in the base");
              // }
               //}
              //catch (SQLException ex) {
               // Logger.getLogger(FXMLajoutController.class.getName()).log(Level.SEVERE, null, ex);
              // }   
               /* try {
                    btn.getScene().setRoot(FXMLLoader.load(getClass().getResource("FXMLafficherEven.fxml")));
                } 
            catch (IOException ex) {
                   Logger.getLogger(FXMLafficheController.class.getName()).log(Level.SEVERE, null, ex);
               }*/
           }
           
       });
       ret1.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
          try {
                    ret1.getScene().setRoot(FXMLLoader.load(getClass().getResource("FXMLAccueil.fxml")));
                } 
            catch (IOException ex) {
                   Logger.getLogger(FXMLajoutController.class.getName()).log(Level.SEVERE, null, ex);
               }

       }
       });
      
             
               }
     public void vider () {
    
    
    Description.setText("");  
    nom_even.setText("");
    heure.setText(""); 
    lieu.setText("");
    Organisateur.setText("");
  Catégorie_even.setValue("");
  image.setText("");
  labelimage.setText("");
  
  ImageE.imageProperty().set(null);
    }

    @Override
    public void mapInitialized() {
        
          geocodingService = new GeocodingService();
        MapOptions options = new MapOptions();
        
  

        options.center(new LatLong(34.3055732, 11.255412))
                .zoomControl(true)
                .zoom(6)
                .overviewMapControl(false)
                .mapType(MapTypeIdEnum.ROADMAP);
        GoogleMap map = mapView.createMap(options);

         directionsService = new DirectionsService();
        directionsPane = mapView.getDirec();
     

      
       
    
    }
     @FXML
    public void addressTextFieldAction(ActionEvent event) {
        geocodingService.geocode(address.get(), (GeocodingResult[] results, GeocoderStatus status) -> {
            
            LatLong latLong = null;

            
            if( status == GeocoderStatus.ZERO_RESULTS) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No matching address found");
                alert.show();
                return;
            } else if( results.length > 1 ) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Multiple results found, showing the first one.");
                alert.show();
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
                
AddMarker(latLong,address.get());
            } else {
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
                AddMarker(latLong,address.get());
            }
            System.out.println("result LG "+latLong.getLongitude()+ "   " +latLong.getLatitude());
            longi = latLong.getLongitude() ; 
            lat = latLong.getLatitude() ; 
            map.setCenter(latLong);
            
        });
    }
          private void AddMarker(LatLong l, String address) {

        Marker myMarker = null;
        markerOptions = new MarkerOptions();
        markerOptions.position(l)
                .title("My new Marker")
                .visible(true);

        myMarker = new Marker(markerOptions);
        InfoWindowOptions infoOptions = new InfoWindowOptions();
        infoOptions.content(address)
                .position(l);

        InfoWindow window = new InfoWindow(infoOptions);
        window.open(map, myMarker);
        map.addMarker(myMarker);
    }
    
   }
               