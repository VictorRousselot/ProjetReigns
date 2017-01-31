/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetreigns;

import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author etudiant
 */

public abstract class Pretendant {    
    private String nom;
    private String prenom;
    private int affinite;
    private ImageIcon image;
    private Periode periodeRV;
    
    private static final String defaultImg = "default.jpeg";
    
    public Pretendant(String nom, String prenom, ImageIcon image, Periode periodeRV) {
        this.nom = nom;
        this.prenom = prenom;
        this.affinite = 0;
        this.periodeRV = periodeRV;
        if(image == null){
            this.image = new ImageIcon("images/"+defaultImg);
        }
        else this.image = image;
    }
    
     public Pretendant(String nom, String prenom, ImageIcon image, Periode periodeRV, int affinite) {
        this(nom, prenom, image, periodeRV);
        this.affinite = affinite;
    }
     
     public ImageIcon getImage(){
         return image;
     }
     
     public abstract void rendezVous(PileCartes laPile) throws PileVideException;
     
     public abstract void evolutionRelation(PileCartes laPile) throws PileVideException;
}
