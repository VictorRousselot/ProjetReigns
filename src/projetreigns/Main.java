/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetreigns;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author etudiant
 */
public class Main {
    public static void main(String args[]) throws IOException, PileVideException{
        ArrayList<Carte> allCartes = new ArrayList<Carte>();
        ArrayList<Periode> lesPeriodes = new ArrayList<Periode>();;
        
        PileCartes maPile = new PileCartes();
        
        lesPeriodes.add(new Periode("matin", new ImageIcon("periode/matin.jpeg")));
        lesPeriodes.add(new Periode("aprem", new ImageIcon("periode/aprem.jpeg")));
        lesPeriodes.add(new Periode("soir", new ImageIcon("periode/soir.jpeg")));
        
        allCartes = ChargeCartes.charger(lesPeriodes);
        
        /*for(Carte selec : allCartes){
            System.out.println(selec.getQuestion());
            System.out.println(selec.getChoix1());
            System.out.println(selec.getChoix2());
            System.out.println(selec.getPeriode().getLibelle());
        }*/
        
        for(int i=0;i<allCartes.size();i++){
            Carte carteSelec = allCartes.get(i);
            maPile.ajoutAleatoire(carteSelec, lesPeriodes);
        }
        
         while(!maPile.estVide()){
            Carte uneCarte = maPile.sommet();
            maPile.depiler();
            
            System.out.println(uneCarte.getQuestion());
            System.out.println(uneCarte.getChoix1());
            System.out.println(uneCarte.getChoix2());
            System.out.println(uneCarte.getPeriode().getLibelle());
        }
    }
}
