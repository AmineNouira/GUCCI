package test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amine
 */

import entites.Reclamation;
import utils.ConnexionBDSingleton;
import java.sql.*;
import GererReclamation.GererReclamation;




public class TestConnexionBD {

    /**
     * @param args the command line arguments
     */
     
     
     
    public static void main(String[] args) {
        Connection myConn = ConnexionBDSingleton.getInstance().getConnection();
        
        Reclamation R = new Reclamation(1,1,"signaler membre","faux profile");
        
        GererReclamation GererReclamation = new GererReclamation();
        
        GererReclamation.creerReclamation(R); //ajouter la reclamation dans la base de données
        
        //GererReclamation.afficherReclamation(); //afficher tous les reclamations
        
        //GererReclamation.deleteReclamation(R); //supprimer une reclamation donné
        
        //GererReclamation.deleteReclamation(1);  //supprimer une reclamation par id
        
        GererReclamation.afficherReclamation(); //afficher tous les reclamations
    }
    
}
