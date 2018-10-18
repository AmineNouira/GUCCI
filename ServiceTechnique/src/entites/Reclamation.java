/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.util.Objects;
import java.util.Date;

/**
 *
 * @author Amine
 */
public class Reclamation {
    private int ID_RECLAMATION;
    private int ID_MEMBRE;
    private String SUJET;
    private String CONTENU;
    private Date DATE_REC;
    
    java.util.Date d1 = new java.util.Date();
    java.sql.Date d2 = new java.sql.Date(d1.getTime());
    
    public Reclamation(){
        
    }
    
    
    public Reclamation(int ID_RECLAMATION, int ID_MEMBRE, String SUJET, String CONTENU){
        this.ID_RECLAMATION=ID_RECLAMATION;
        this.ID_MEMBRE=ID_MEMBRE;
        this.SUJET=SUJET;      
        this.CONTENU=CONTENU;
        this.DATE_REC=d2;
                
    }
    
    public int get_ID_RECLAMATION(){
        return this.ID_RECLAMATION;
    }
    
    public int get_ID_MEMBRE(){
        return this.ID_MEMBRE;
    }
    
    public String get_SUJET(){
        return this.SUJET;
    }
    
    public String get_CONTENU(){
        return this.CONTENU;
    }
    
    public Date get_DATE_REC(){
        return this.DATE_REC;
    }
    
    public void set_ID_RECLAMATION(int ID_RECLAMATION){
        this.ID_RECLAMATION=ID_RECLAMATION;
    }
    
    public void set_ID_MEMBRE(int ID_MEMBRE){
        this.ID_MEMBRE=ID_MEMBRE;
    }
    
    @Override
    public String toString(){
        return ("Reclamation N°"+this.ID_RECLAMATION+", venant de User_Id : "+this.ID_MEMBRE+", date : "+this.DATE_REC+"\nsujet : "+this.SUJET+"\n"+this.CONTENU);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reclamation other = (Reclamation) obj;
        if (this.ID_RECLAMATION != other.ID_RECLAMATION) {
            return false;
        }
        
        return true;
    }
}
