/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetreigns;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author etudiant
 */
public abstract class Carte {
    private String choix1;
    private String choix2;
    private String question;
    private String activite;
    private Periode periode;
    private Periode periodeRV;
    private HashMap<Pretendant, int[]> bonus;
    
    public Carte(String choix1, String choix2, String question, Periode periode){
        this.bonus = new HashMap<Pretendant, int[]>();
        this.choix1 = choix1;
        this.choix2 = choix2;
        this.question = question;
        this.periode = periode;
    }
    
    public void addPretendant(Pretendant unPretendant, int choix1, int choix2){
        int tableau[] = {choix1, choix2};
        bonus.put(unPretendant, tableau);
    }
    
    public void removePretendant(Pretendant unPretendant){
        if(bonus.containsKey(unPretendant)){
            bonus.remove(unPretendant);
        }
    }
    
    public int nbPretendants(){
        return bonus.size();
    }   
    
    public Periode getPeriode(){
        return periode;
    }
    
    public String getQuestion(){
        return question;
    }
    
    public String getChoix1(){
        return choix1;
    }
    
    public String getChoix2(){
        return choix2;
    }
    
    public HashMap getBonus(){
        return bonus;
    }
    
    public HashMap<Pretendant, int[]> getPretendants(){
        return bonus;
    }
    
    public abstract String getActivite();
    
    public abstract void actionLancee(PileCartes list) throws PileVideException;
}
