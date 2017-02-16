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
public class CarteSortieBar extends Carte {
    
    private  String activite = "Au bar";
    
    public CarteSortieBar(String choix1, String choix2, String question, Periode periode){
        super(choix1, choix2, question, periode);
    }
    
    @Override
    public void actionLancee(PileCartes laPile) throws PileVideException{
       // laPile.depiler();
    }
    
    public String getActivite(){
        return activite;
    }
}
