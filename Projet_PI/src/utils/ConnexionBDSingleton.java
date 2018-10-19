/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Mohamed
 */
public class ConnexionBDSingleton {
    String url="jdbc:mysql://localhost:3306/esprit";
    String username="root";
    String password="";
    Connection instanceConnection;
    static ConnexionBDSingleton instanceCxSing;
    
    private ConnexionBDSingleton() {
        
        try {
          instanceConnection = DriverManager.
                  getConnection(url, username, password);
          System.out.println("Connexion Etablie !!");
          
         
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }
    }    
    public static ConnexionBDSingleton getInstance(){
        if(instanceCxSing == null)
         instanceCxSing=  new ConnexionBDSingleton();
            return instanceCxSing;
        
    }   
    public  Connection getConnection(){
        return instanceConnection;
    }
}
