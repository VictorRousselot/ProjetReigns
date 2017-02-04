/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetreigns;

import java.io.File;
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
        
        lesPeriodes.add(new Periode("matin", new ImageIcon("images/matin.png")));
        lesPeriodes.add(new Periode("aprem", new ImageIcon("images/aprem.png")));
        lesPeriodes.add(new Periode("soir", new ImageIcon("images/soir.jpeg")));
        
        ArrayList<Pretendant> pretendants = new ArrayList<Pretendant>();
        Pretendant p1 = new Dragueur("Pierette", "pierrette.jpeg", lesPeriodes);
        Pretendant p2 = new Dragueur("Vilatte", "vilatte.png", lesPeriodes);
        pretendants.add(p1);
        pretendants.add(p2);
        
        allCartes = ChargeCartes.charger(lesPeriodes, pretendants);
        
        
        for(int i=0;i<allCartes.size();i++){
            Carte carteSelec = allCartes.get(i);
            maPile.ajoutAleatoire(carteSelec, lesPeriodes);
        }
        
        FenetreJeu maFenetre = new FenetreJeu(maPile);
    }
}
