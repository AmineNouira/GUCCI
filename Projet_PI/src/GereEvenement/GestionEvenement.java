/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GereEvenement;
import entites.Evenement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnexionBDSingleton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mohamed
 */
public class GestionEvenement {

   
    
    private Connection con;
    private Statement st;
    PreparedStatement pste;
    private ResultSet rs;
    static String url="jdbc:mysql://localhost:3306/esprit";
    static String username="root";
    static String password="";
    
    public  GestionEvenement(){
       con = ConnexionBDSingleton.getInstance().getConnection();
        try {
        st = con.createStatement();
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void getData(){
        try{
            String requete;
            requete = "SELECT * FROM `esprit`.`evénements`";
            rs = st.executeQuery(requete);
            System.out.println("Records from Database");
            while(rs.next()){
                int id_even = rs.getInt("id_even");
                 String Organisateur = rs.getString("Organisateur");
                String nom_even = rs.getString("nom_even");
                String Catégorie_even= rs.getString("Catégorie_even");
                String 	Date = rs.getString("Date");
                String 	heure = rs.getString("heure");
                String 	lieu = rs.getString("lieu");
                String 	Intéresse_par = rs.getString("Intéresse_par");
                String 	Note_even = rs.getString("Note_even");
                
                System.out.println("Id : "+id_even+" Organisateur : "+Organisateur+" Nom : "+nom_even+" Catégorie : "
                        +Catégorie_even+" Date : "+Date+" heure : "+heure+" lieu : "+lieu+" Intéresse : "+Intéresse_par+" Note : "+Note_even);
            }
        }catch(Exception ex){
            System.out.println("Error : "+ex.getMessage());
        }
        
        
            
    }
    
         public void creerEvenement(Evenement E) {
        String req;
        req = "INSERT INTO `esprit`.`evénements` "
                + "(`id_even`,`Organisateur`,`nom_even`,`Catégorie_even`,`Date`,`heure`,`lieu`,`Intéresse_par`,`Note_even`)"
                + " VALUES ('"+E.Get_Id_Even()+ "', '"+E.get_Organisateur()+"', '"+E.Get_Nom_Even()
                +"', '"+E.Get_Catégorie_Even()+ "', '"+E.Get_Date()+ "', '"+E.Get_Heure()+"', '"+E.Get_Lieu()+"', '"
                +E.Get_Intéresse_par()+"', '"+E.Get_Note_even()+"');";
        
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GestionEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }
         }

       public void deleteEvenement(Evenement E) {
     String req = "delete from `evénements` "
             + "where 	id_even= ?";
     
        try {
            pste = con.prepareStatement(req);
            pste.setInt(1, E.Get_Id_Even());
            pste.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteEvenement(int i) {
        String req = "delete from `evénements`"
             + "where id_even= ?";
     
        try {
            pste = con.prepareStatement(req);
            pste.setInt(1, i);
            pste.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void afficherEvenement(){
        try{
            String requete;
            requete = "SELECT * FROM `esprit`.`evénements`";
            rs = st.executeQuery(requete);
            System.out.println("Evenement from Database");
            while(rs.next()){
                int id_even = rs.getInt("id_even");
                String Organisateur = rs.getString("Organisateur");
                String nom_even = rs.getString("nom_even");
                String Catégorie_even = rs.getString("Catégorie_even");
                Date Date = rs.getDate("Date");
                String 	heure = rs.getString("heure");
                String 	lieu = rs.getString("lieu");
                String 	Intéresse_par = rs.getString("Intéresse_par");
                int 	Note_even = rs.getInt("Note_even");
                System.out.println("Id Even :"+id_even+" Organisateur : "
                        +Organisateur+", Nom Even : "+nom_even+" Catégorie_even : "+Catégorie_even+" Date:  "
                        +Date+"\n"+" heure:  "+heure+" lieu:  "+lieu+" Intéresse_par:  "+Intéresse_par+" Note_even:  "+Note_even+"\n");
            }
        }catch(Exception ex){
            System.out.println("Error : "+ex.getMessage());
        }
    }
    
    
    
    }
    
   
   

