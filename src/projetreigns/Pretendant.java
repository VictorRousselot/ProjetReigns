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
    private String dossier;
    
    public Pretendant(String nom, String prenom, ImageIcon image){
        this.nom = nom;
        this.prenom = prenom;
        affinite = 0;
        
        File dossier = new File("./"+nom+"-"+prenom);
        if(!dossier.exists()){
            dossier.mkdir();
            this.dossier = dossier.getName();
        }
    }
    
    public Pretendant(String nom, String prenom, ImageIcon image, int affinite){
        this.nom = nom;
        this.prenom = prenom;
        this.affinite = affinite;
        
        File dossier = new File("./"+nom+"-"+prenom);
        if(!dossier.exists()){
            dossier.mkdir();
            this.dossier = dossier.getName();
        }
    }
}
