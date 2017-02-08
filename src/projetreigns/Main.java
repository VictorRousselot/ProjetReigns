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
    
    private static ArrayList<Carte> allCartes;
    private static ArrayList<Periode> lesPeriodes;

    public static void main(String args[]) throws IOException, PileVideException {
        allCartes = new ArrayList<Carte>();
        lesPeriodes = new ArrayList<Periode>();;

        PileCartes maPile = new PileCartes();

        lesPeriodes.add(new Periode("matin", new ImageIcon("images/matin.png")));
        lesPeriodes.add(new Periode("aprem", new ImageIcon("images/aprem.png")));
        lesPeriodes.add(new Periode("soir", new ImageIcon("images/soir.jpeg")));

        ArrayList<Pretendant> pretendants = new ArrayList<Pretendant>();
        Pretendant p1 = new Dragueur("Pierette", "chihuahua.jpg", lesPeriodes);
        Pretendant p2 = new Dragueur("Vilatte", null, lesPeriodes);
        pretendants.add(p1);
        pretendants.add(p2);

        allCartes = ChargeCartes.charger(lesPeriodes, pretendants);

        for (int i = 0; i < allCartes.size(); i++) {
            Carte carteSelec = allCartes.get(i);
            maPile.ajoutAleatoire(carteSelec, lesPeriodes);
        }

        FenetreJeu maFenetre = new FenetreJeu(maPile);
    }

    public static void refreshFenetre() throws PileVideException {
        PileCartes newPile = new PileCartes();
        for (int i = 0; i < allCartes.size(); i++) {
            Carte carteSelec = allCartes.get(i);
            newPile.ajoutAleatoire(carteSelec, lesPeriodes);
        }
        
        FenetreJeu newFenetre = new FenetreJeu(newPile);
    }
}
