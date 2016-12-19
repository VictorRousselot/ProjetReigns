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
    private ImageIcon image;
    private Periode periode;
    private ArrayList<Pretendant> pretendants;
    
    public Carte(String choix1, String choix2, String question, ImageIcon image, Periode periode){
        this.choix1 = choix1;
        this.choix2 = choix2;
        this.question = question;
        this.image = image;
        this.periode = periode;
        pretendants = new ArrayList<Pretendant>();
    }
}
