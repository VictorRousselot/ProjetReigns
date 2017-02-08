/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetreigns;

import java.util.ArrayList;

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
        lesCartes.add(0, uneCarte);
    }
    
    @Override
    public Carte sommet() throws PileVideException {
        if(this.estVide()){
            throw new PileVideException();
        }
        else return lesCartes.get(0);
    }
    
    @Override
    public void depiler() throws PileVideException {
        if(this.estVide()){
            throw new PileVideException();
        }
        else {
            lesCartes.remove(this.sommet());
        }
    }
    
    public boolean peutDepiler(){
       return(lesCartes.size() >= 2); 
    }
    
     public void ajoutAleatoire(Carte uneCarte, ArrayList<Periode> lesPeriodes){
        int nbAleatoire = (int)(Math.random()*2);
        int i = 0;
        switch(nbAleatoire){
            case 0: 
                while(i<lesCartes.size() && lesCartes.get(i).getPeriode() != uneCarte.getPeriode()){
                    i++;
                }
                if(i>=lesCartes.size()){
                    i = 0;
                    while(i<lesCartes.size() && lesPeriodes.indexOf(lesCartes.get(i).getPeriode()) != lesPeriodes.indexOf(uneCarte.getPeriode())+1){
                        i++;
                    }
                    if(i>=lesCartes.size()){
                        lesCartes.add(uneCarte);
                    }
                    else lesCartes.add(i+1, uneCarte);
                }
                else lesCartes.add(i, uneCarte);
            break;
            
            case 1: 
                while(i<lesCartes.size() && lesPeriodes.indexOf(lesCartes.get(i).getPeriode()) != lesPeriodes.indexOf(uneCarte.getPeriode())+1){
                    i++;
                }
                if(i>=lesCartes.size()){
                    lesCartes.add(uneCarte);
                }
                else lesCartes.add(i+1, uneCarte);
            break; 
        }
    }
}
