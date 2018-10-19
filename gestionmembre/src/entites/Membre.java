/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author hp
 */
import java.util.Objects;
public class Membre {
    private int id;
    private String nom;
    private String prenom;
    private long cin;
    private String adresse;
    private int age;

    public Membre() {
    }

    public Membre(String nom, String prenom,long cin,String adresse,int age) {
    
        this.nom = nom;
         this.prenom= prenom;
        this.cin = cin;
        this.adresse= adresse;
        this.age = age;
    }
    public Membre(int id, String nom,  String prenom,long cin,String adresse,int age) {
        this.id = id;
       this.nom = nom;
         this.prenom= prenom;
        this.cin = cin;
        this.adresse= adresse;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom =prenom;
    }
public long getCin() {
        return cin;
    }

    public void setCin(long cin) {
        this.cin = cin;
    }
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Membre{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", CIN=" + cin + ", adresse=" + adresse +", age=" + age + '}';
    }

 

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Membre other = (Membre) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
    }
    
    
    

}
