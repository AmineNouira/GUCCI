/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionmembre;

/**
 *
 * @author hp
 */
import entites.Membre;
import utils.ConnexionBDSingleton;
import java.sql.*;
import services.MembreService;

public class Gestionmembre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection myConn0 = ConnexionBDSingleton.getInstance()
             .getConnection();
      Connection myConn1 = ConnexionBDSingleton.getInstance()
             .getConnection(); 
      Connection myConn2 = ConnexionBDSingleton.getInstance()
             .getConnection();
      
        Membre m = new Membre(1,"nizar","hssen",9,"ariana",30);
       MembreService membreService = new MembreService();
       membreService.ajouterMembre(m);
     
        Membre m1 = new Membre(2,"Irad","Aaaamri",45,"ariana",45);
       MembreService membreService1 = new MembreService();
       membreService1.ajouterMembre(m1);
        Membre m2 = new Membre(3,"khalil","wahada",66,"ariana",17);
       MembreService membreService2 = new MembreService();
       membreService2.ajouterMembre(m2);
        Membre m3 = new Membre(4,"Amin","nwira",451,"ariana",88);
       MembreService membreService3 = new MembreService();
       membreService3.ajouterMembre(m3);
        Membre m4 = new Membre(5,"hamza","saiidi",54,"ariana",25);
       MembreService membreService4 = new MembreService();
       membreService4.ajouterMembre(m4);
        Membre m5 = new Membre(6,"Mohamed","bigoo",58,"ariana",42);
       MembreService membreService5 = new MembreService();
       membreService5.ajouterMembre(m5);
       
        System.out.println( membreService1.afficherMembre());
    }
    
}
