/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetreigns;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author etudiant
 */
public class Carte {
    private String choix1;
    private String choix2;
    private String question;
    private Periode periode;
    private ImageIcon image;
    private ArrayList<Pretendant> pretendants;
    
    public Carte(String choix1, String choix2, String question, Periode periode, ImageIcon image){
        this.choix1 = choix1;
        this.choix2 = choix2;
        this.question = question;
        this.periode = periode;
        this.image = image;
        pretendants = new ArrayList<Pretendant>();
    }
    
    public void addPretendant(Pretendant unPretendant){
        pretendants.add(unPretendant);
    }
    
    public void removePretendant(Pretendant unPretendant){
        if(pretendants.contains(unPretendant)){
            pretendants.remove(unPretendant);
        }
    }
    
    public int nbPretendants(){
        return pretendants.size();
    }
}
