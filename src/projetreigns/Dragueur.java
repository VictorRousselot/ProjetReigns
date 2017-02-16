/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetreigns;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author etudiant
 */
public class Dragueur extends Pretendant {
    public Dragueur(String nom, String img, ArrayList<Periode> lesPeriodes) throws IOException {
        super(nom, img, lesPeriodes);
    }
    
    @Override
    public void rendezVous(PileCartes laPile) throws PileVideException {
        JOptionPane.showMessageDialog(null, "Génial ! Vous pouvez sortir avec "+nom+" !", null, JOptionPane.OK_OPTION);
        while(laPile.peutDepiler()){
            laPile.depiler();
        }
    }
    
    @Override
    public void evolutionRelation(PileCartes laPile, Periode pActuelle) throws PileVideException{
        /*if(affinite > 50){
            while(laPile.peutDepiler()){
                int nb = 0;
                Set<Pretendant> pret = laPile.sommet().getPretendants().keySet();
                for(Pretendant p : pret) {
                    if(pret == this){
                        nb++;
                    }
                }
                
                if(nb == 0){
                    laPile.depiler();
                }
            }
        }
        
        if(affinite == 100 && pActuelle.getLibelle().equals("soir") && laPile.sommet().getPretendants().size() == 1){
            rendezVous(laPile);
        }*/
    }
}
