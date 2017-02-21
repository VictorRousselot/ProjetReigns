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
public class Periode {
    private String libelle;
    private ImageIcon image;
    
    public Periode(String libelle, ImageIcon image){
        this.libelle = libelle;
        this.image = image;
    }
    
    public String getLibelle(){
        return libelle;
    }
    
    public ImageIcon getImage(){
        return image;
    }
}
