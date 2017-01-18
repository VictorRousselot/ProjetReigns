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
public class Main {
    public static void main(String args[]){
        ArrayList<Carte> allCartes;
        ArrayList<Carte> cartesMatin;
        ArrayList<Carte> cartesAprem;
        ArrayList<Carte> cartesSoir;
        ArrayList<Periode> lesPeriodes;
        
        lesPeriodes = new ArrayList<Periode>();
        allCartes = new ArrayList<Carte>();
        cartesMatin = new ArrayList<Carte>();
        cartesAprem = new ArrayList<Carte>();
        cartesSoir = new ArrayList<Carte>();
        
        PileCartes maPile = new PileCartes();
        
        for(int i=0;i<allCartes.size();i++){
            Carte carteSelec = allCartes.get(i);
            maPile.ajoutAleatoire(carteSelec, lesPeriodes);
        }
    }
}
