/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetreigns;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author etudiant
 */

public abstract class Pretendant {    
    protected String nom;
    protected int affinite;
    protected boolean peutSortir;
    protected ImageIcon image;
    protected ArrayList<Carte> speciales;
    
    private static final String defaultImg = "default.jpeg";
    
    public Pretendant(String nom, String img, ArrayList<Periode> lesPeriodes) throws IOException {
        if(img == null){
            this.image = new ImageIcon("images/"+defaultImg);
        }
        else this.image = new ImageIcon("images/"+img);
        
        this.nom = nom;
        this.affinite = 0;
        this.peutSortir = true;
        speciales = ChargeCartes.chargerSpeciales(lesPeriodes, this.nom);
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
     
     public abstract void evolutionRelation(PileCartes laPile, Periode pActuelle) throws PileVideException;
}
