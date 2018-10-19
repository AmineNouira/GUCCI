/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import GereEvenement.GestionEvenement;
import entites.Evenement;
import java.sql.Connection;
import java.util.Date;
import utils.ConnexionBDSingleton;

/**
 *
 * @author Mohamed
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestionEvenement connect = new GestionEvenement();
        connect.getData();
        
        
        Connection myConn = ConnexionBDSingleton.getInstance().getConnection();
        
        Evenement E = new Evenement(24,"FBIyY","gSécritSYB","hgake","7:00","tunis","Employ",6);
         Evenement E1 = new Evenement(6,"lu","pu","mk","+:00","ljs","Emlmijy",4);
        GestionEvenement GestionEvenement= new GestionEvenement();
        
        GestionEvenement.creerEvenement(E);
        GestionEvenement.creerEvenement(E1);

        //GestionEvenement.deleteEvenement(E1);
       // GestionEvenement.deleteEvenement(24);
        GestionEvenement.afficherEvenement();
    }
    
}
