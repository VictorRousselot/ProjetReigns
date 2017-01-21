/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetreigns;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author etudiant
 */
public class ChargeCartes {
    public static ArrayList<Carte> charger(ArrayList<Periode> lesPeriodes) throws FileNotFoundException, IOException{
        File[] fichiers = null;
        ArrayList<Carte> lesCartes = new ArrayList<Carte>();
        File dossierCarte = new File("cartes");
        fichiers = dossierCarte.listFiles();
        
        for(int i=0;i<fichiers.length;i++){
            BufferedReader bfr = new BufferedReader(new FileReader(fichiers[i]));
            int nbLigne = 1;
            Carte newCarte;
            String question = "", choix1 = "", choix2 = "";
            Periode per = lesPeriodes.get(0);
            ImageIcon img = null;
            String chaine = null;
            
            while((chaine = bfr.readLine()) != null){
                
                switch(nbLigne){
                    case 1 : question = chaine;
                    break;
                    
                    case 2: choix1 = chaine;
                    break;
                    
                    case 3: choix2 = chaine;
                    break;
                    
                    case 4:
                    for(int j=0; j<lesPeriodes.size();j++){
                        if(chaine.equals(lesPeriodes.get(j).getLibelle())){
                            per = lesPeriodes.get(j);
                        }
                    }
                    break;
                    
                    case 5: img = new ImageIcon(chaine);
                }
                nbLigne++;
            }
            newCarte = new Carte(choix1, choix2, question, per, img);
            lesCartes.add(newCarte);
        }
        return lesCartes;
    }
}
