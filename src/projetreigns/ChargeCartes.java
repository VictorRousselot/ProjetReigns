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
import java.io.Reader;
import java.util.ArrayList;

/**
 *
 * @author etudiant
 */
public class ChargeCartes {
    public static ArrayList<Carte> charger() throws FileNotFoundException, IOException{
        File[] fichiers = null;
        File dossierCarte = new File("mesCartes");
        fichiers = dossierCarte.listFiles();
        
        for(int i=0;i<fichiers.length;i++){
            BufferedReader bfr = new BufferedReader(new FileReader(fichiers[i]));
            while(bfr.readLine() != null){
                
            }
        }
    }
}
