/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetreigns;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author etudiant
 */

public abstract class Pretendant {    
    private String nom;
    private int affinite;
    private boolean peutSortir;
    private ImageIcon image;
    private ArrayList<Carte> speciales;
    
    private static final String defaultImg = "default.jpeg";
    
    public Pretendant(String nom, String img, ArrayList<Periode> lesPeriodes) throws IOException {
        this.image = new ImageIcon("images/"+img);
        this.nom = nom;
        this.affinite = 0;
        this.peutSortir = true;
        speciales = ChargeCartes.chargerSpeciales(lesPeriodes, this.nom);
    }
    
     public Pretendant(String nom, ArrayList<Periode> lesPeriodes, String path, int affinite) throws IOException {
        this(nom, path, lesPeriodes);
        this.affinite = affinite;
    }
     
     public String getNom(){
         return nom;
     }
     
     public ImageIcon getImg(){
         return image;
     }
     
     public void setAffinite(int af){
         affinite = af;
     }
     
     public int getAffinite(){
         return affinite;
     }
     
     public void setSortir(boolean b){
         peutSortir = b;
     }
     
     public boolean getSortir(){
         return peutSortir;
     }
     
     public abstract void rendezVous(PileCartes laPile) throws PileVideException;
     
     public abstract void evolutionRelation(PileCartes laPile) throws PileVideException;
}
