/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetreigns;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author etudiant
 */
public class PileCartes implements Pile {
    
    private ArrayList<Carte> lesCartes;
    
    public PileCartes(){
        lesCartes = new ArrayList<Carte>();
    }
    
    @Override
    public boolean estVide(){
        return lesCartes.isEmpty();
    }
    
    @Override
    public void empiler(Carte uneCarte){
        lesCartes.add(uneCarte);
    }
    
    @Override
    public Carte sommet(){
        return lesCartes.get(lesCartes.size()-1);
    }
    
    @Override
    public void depiler() throws PileVideException {
        if(this.estVide()){
            throw new PileVideException();
        }
        else lesCartes.remove(this.sommet());
    }
    
    public void ajoutAleatoire(Carte uneCarte){
        Random rand = new Random();
        int nbAleatoire = rand.nextInt(lesCartes.size()+1)+0;
        lesCartes.add(nbAleatoire, uneCarte);
    }
}
