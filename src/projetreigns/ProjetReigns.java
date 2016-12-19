/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetreigns;

/**
 *
 * @author etudiant
 */
public class ProjetReigns {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PileVideException {
        // TODO code application logic here
        FenetreJeu maFenetre = new FenetreJeu();
        
        PileCartes pile = new PileCartes();
        
        /*pile.empiler(ct1);
        pile.empiler(ct2);
        pile.empiler(ct3);*/
        
       // pile.ajoutAleatoire(new Carte("test"));
        
        while (!pile.estVide()){
       //     System.out.println(pile.sommet().txt);
            pile.depiler();
        }
    }
    
}
