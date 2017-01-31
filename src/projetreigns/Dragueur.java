/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetreigns;

import javax.swing.ImageIcon;

/**
 *
 * @author etudiant
 */
public class Dragueur extends Pretendant {
    public Dragueur(String nom, String prenom, ImageIcon image, Periode periodeRV) {
        super(nom, prenom, image, periodeRV);
    }
    
    @Override
    public void rendezVous(PileCartes laPile) throws PileVideException {
        
    }
    
    @Override
    public void evolutionRelation(PileCartes laPile) throws PileVideException{
        
    }
}
