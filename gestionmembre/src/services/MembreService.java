/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Membre;
import iservices.IMembreService;
import java.util.ArrayList;
/**
 *
 * @author hp
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnexionBDSingleton;
public class MembreService implements IMembreService {
     Connection con;
    Statement ste; //req statique
    PreparedStatement pste; // req dynamique
    public MembreService() {
        con = ConnexionBDSingleton.getInstance().getConnection();
        try {
        ste = con.createStatement();
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     public void ajouterMembre(Membre m){
          String req = "INSERT INTO `esprit`.`Membre` "
                + "(`id`,`nom`,`prenom`,`cin`,`adresse`, `age`)"
                + " VALUES ('"+m.getId()+"','"+m.getNom()+"','"+m.getPrenom()+"','"+m.getCin()+"','"+m.getAdresse()+"','"+m.getAge()+"');";
        
      
        try {
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    public void updateMembre(Membre m){
throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void deleteMembre(Membre m){
         String req = "delete from membre "
             + "where id= ?";
     
        try {
            pste = con.prepareStatement(req);
            pste.setInt(1, m.getId());
            pste.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public ArrayList<Membre> afficherMembre(){
          String req = "select * from membre";
        ArrayList<Membre> membres = new ArrayList<>();
                
        
        try {
            ResultSet res=  ste.executeQuery(req);
            
           
            while (res.next()) {
      Membre m = new Membre(res.getInt("id"),res.getString("nom"),res.getString("prenom"),res.getLong("cin"),res.getString("adresse"),res.getInt("age"));
      membres.add(m);
              
            }   
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return membres;
    }
    
}
