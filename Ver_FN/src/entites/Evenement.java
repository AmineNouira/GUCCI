/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.util.Date;

/**
 *
 * @author Mohamed
 */
public class Evenement {
  private int id_even;
    private String Organisateur;
    private String nom_even;
    private String Catégorie_even;
    private Date Date;
    private String heure;
    private String lieu ;
    private String image;
    private String Intéresse_par;
    private int Note_even;
    java.util.Date d1 = new java.util.Date();
    java.sql.Date d2 = new java.sql.Date(d1.getTime());
    private String Description;
    public Evenement(){
        
    }
    
    
    public Evenement(int id_even,String Organisateur,String nom_even, String Catégorie_even,String heure, String lieu,String Intéresse_par,int Note_even){
        this.id_even=id_even;
        this.Organisateur=Organisateur;
        this.nom_even=nom_even;      
        this.Catégorie_even=Catégorie_even;
        this.Date=d2;
        this.heure=heure;
        this.lieu= lieu; 
        this.Intéresse_par=Intéresse_par;
        this.Note_even=Note_even;
                
    }
     public Evenement(int id_even,String Organisateur,String nom_even, String Catégorie_even){
        this.id_even=id_even;
        this.Organisateur=Organisateur;
        this.nom_even=nom_even;      
        this.Catégorie_even=Catégorie_even;
        
    }

    public void setCatégorie_even(String Catégorie_even) {
        this.Catégorie_even = Catégorie_even;
    }
     
      public Evenement(int id_even,String Organisateur,String nom_even, String Catégorie_even,String heure,String lieu,String Description,String image){
        this.id_even=id_even;
        this.Organisateur=Organisateur;
        this.nom_even=nom_even;      
        this.Catégorie_even=Catégorie_even;
       
        this.heure=heure;
        this.lieu=lieu;
        this.Description=Description;
        this.image=image;
        
    }
       public Evenement(int id_even,String Organisateur,String nom_even, String Catégorie_even,Date date,String heure,String lieu,String Description,String image){
        this.id_even=id_even;
        this.Organisateur=Organisateur;
        this.nom_even=nom_even;      
        this.Catégorie_even=Catégorie_even;
        this.Date=d2;
        this.heure=heure;
        this.lieu=lieu;
        this.Description=Description;
        this.image=image;
        
    }

    public Evenement(String text, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    public int Get_Id_Even(){
        return this.id_even;
    }
    
    public String get_Organisateur(){
        return this.Organisateur;
    }
    
    public String Get_Nom_Even(){
        return this.nom_even;
    }

    public Evenement(String nom_even) {
        this.nom_even = nom_even;
    }
    
    public String Get_Catégorie_Even(){
        return this.Catégorie_even;
    }
    
    public Date Get_Date(){
        return this.Date;
    }
    public String Get_Heure(){
        return this.heure;
    }
     public String Get_Lieu(){
        return this.lieu;
    }
      public String Get_Intéresse_par(){
        return this.Intéresse_par;
    }
       public int Get_Note_even(){
        return this.Note_even;
    }
    public String Get_Description(){
        return this.Description;
    }
    public String Get_Image(){
        return this.image;
    }
    
    public void set_Id_Even(int id_even){
        this.id_even=id_even;
    }
    public void set_Nom(String nom_even){
        this.nom_even=nom_even;
    }
    public void set_Organisateur(String Organisateur){
        this.Organisateur=Organisateur;
    }
    
    
    
    @Override
    public String toString(){
        return ("ID Evenement :"+this.id_even+", Organisateur : "+this.Organisateur+"name Evenement :"+this.nom_even+
              "Catégerie Evenement :"  +Catégorie_even+", heure : "+this.heure+"\nlieu : "+this.lieu+"\nDescription :"
                +this.Description+"\n	image:"+this.image);
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evenement other = (Evenement) obj;
        if (this.id_even!= other.id_even) {
            return false;
        }
        
        return true;
    }    
}
