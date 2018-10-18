/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GererReclamation;

import entites.Reclamation;
import java.util.ArrayList;

/**
 *
 * @author Amine
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnexionBDSingleton;

public class GererReclamation {
    Connection con;
    Statement ste; 
    PreparedStatement pste;
    ResultSet rs;
    
    public GererReclamation() {
        con = ConnexionBDSingleton.getInstance().getConnection();
        try {
        ste = con.createStatement();
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public void creerReclamation(Reclamation p) {
        String req = "INSERT INTO `esprit`.`reclamation` "
                + "(`ID_RECLAMATION`, `ID_MEMBRE`, `SUJET`, `CONTENU`, `DATE_REC`)"
                + " VALUES ('"+p.get_ID_RECLAMATION()+
                "', '"+p.get_ID_MEMBRE()+"', '"+p.get_SUJET()+"', '"+p.get_CONTENU()+"', '"+p.get_DATE_REC()+"');";
        
        try {
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GererReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public void deleteReclamation(Reclamation p) {
     String req = "delete from reclamation "
             + "where ID_RECLAMATION= ?";
     
        try {
            pste = con.prepareStatement(req);
            pste.setInt(1, p.get_ID_RECLAMATION());
            pste.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(GererReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void deleteReclamation(int i) {
     String req = "delete from reclamation "
             + "where ID_RECLAMATION= ?";
     
        try {
            pste = con.prepareStatement(req);
            pste.setInt(1, i);
            pste.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(GererReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void afficherReclamation(){
        try{
            String requete;
            requete = "SELECT * FROM `esprit`.`reclamation`";
            rs = ste.executeQuery(requete);
            System.out.println("Reclamation from Database");
            while(rs.next()){
                int ID_RECLAMATION = rs.getInt("ID_RECLAMATION");
                int ID_MEMBRE = rs.getInt("ID_MEMBRE");
                String SUJET = rs.getString("SUJET");
                String CONTENU = rs.getString("CONTENU");
                Date DATE_REC = rs.getDate("DATE_REC");
                System.out.println("Reclamation N°"+ID_RECLAMATION+", venant de User_Id : "+ID_MEMBRE+", date : "+DATE_REC+"\nsujet : "+SUJET+"\n"+CONTENU+"\n"+"****************");
            }
        }catch(Exception ex){
            System.out.println("Error : "+ex.getMessage());
        }
    }
}
