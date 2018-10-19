/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservices;

import entites.Membre;
import java.util.ArrayList;
/**
 *
 * @author hp
 */

public interface IMembreService {
    public void ajouterMembre(Membre m);
    public void updateMembre(Membre m);
    public void deleteMembre(Membre m);
    public ArrayList<Membre> afficherMembre();

}
