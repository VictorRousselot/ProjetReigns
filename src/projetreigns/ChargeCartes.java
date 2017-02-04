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

    public static ArrayList<Carte> charger(ArrayList<Periode> lesPeriodes, ArrayList<Pretendant> lesPretendants) throws FileNotFoundException, IOException {
        File[] fichiers = null;
        ArrayList<Carte> lesCartes = new ArrayList<Carte>();
        File dossierCarte = new File("cartes/");
        fichiers = dossierCarte.listFiles();

        for (int i = 0; i < fichiers.length; i++) {
            BufferedReader bfr = new BufferedReader(new FileReader(fichiers[i]));
            int nbLigne = 1;
            Carte newCarte = null;
            String question = "", choix1 = "", choix2 = "";
            Periode per = lesPeriodes.get(0);
            String chaine = null;

            while ((chaine = bfr.readLine()) != null) {

                switch (nbLigne) {
                    case 1:
                        question = chaine;
                        break;

                    case 2:
                        choix1 = chaine;
                        break;

                    case 3:
                        choix2 = chaine;
                        break;

                    case 4:
                        for (int j = 0; j < lesPeriodes.size(); j++) {
                            if (chaine.equals(lesPeriodes.get(j).getLibelle())) {
                                per = lesPeriodes.get(j);
                            }
                        }
                        break;

                    case 5:
                        switch (chaine) {
                            case "carteSortieBar":
                                newCarte = new CarteSortieBar(choix1, choix2, question, per);
                                break;
                        }
                        break;

                    case 6:
                        String[] prets = chaine.split(";");
                        for (Pretendant p : lesPretendants) {
                            for (int j = 0; j < prets.length; j++) {
                                String nom = prets[j].substring(0, prets[j].indexOf(":"));
                                if (p.getNom().equals(nom)) {
                                    String bonMal = prets[j].substring(prets[j].indexOf(":") + 1, prets[j].length());
                                    System.out.print("test");
                                    String[] bonus = bonMal.split(",");

                                    newCarte.addPretendant(p, Integer.parseInt(bonus[0]), Integer.parseInt(bonus[1]));
                                }
                            }
                        }
                }
                nbLigne++;
            }
            lesCartes.add(newCarte);
        }
        return lesCartes;
    }

    public static ArrayList<Carte> chargerSpeciales(ArrayList<Periode> lesPeriodes, String nomPret) throws FileNotFoundException, IOException {
        File[] pretendants = null;
        File[] speciales = null;
        ArrayList<Carte> lesCartes = new ArrayList<Carte>();
        File dossierPret = new File("pretendants/");
        pretendants = dossierPret.listFiles();

        for (int i = 0; i < pretendants.length; i++) {
            File dossierSpec = new File(pretendants[i].getAbsolutePath());
            speciales = dossierSpec.listFiles();
            int j = 0;
            while (j < speciales.length && !speciales[j].equals(nomPret)) {
                j++;
            }

            if (j < speciales.length) {
                BufferedReader bfr = new BufferedReader(new FileReader(speciales[j]));
                int nbLigne = 1;
                Carte newCarte = null;
                String question = "", choix1 = "", choix2 = "";
                Periode per = lesPeriodes.get(0);
                String chaine = null;

                while ((chaine = bfr.readLine()) != null) {

                    switch (nbLigne) {
                        case 1:
                            question = chaine;
                            break;

                        case 2:
                            choix1 = chaine;
                            break;

                        case 3:
                            choix2 = chaine;
                            break;

                        case 4:
                            for (int k = 0; j < lesPeriodes.size(); j++) {
                                if (chaine.equals(lesPeriodes.get(j).getLibelle())) {
                                    per = lesPeriodes.get(j);
                                }
                            }
                            break;

                        case 5:
                            switch (chaine) {
                                case "carteSortieBar":
                                    newCarte = new CarteSortieBar(choix1, choix2, question, per);
                                    break;
                            }
                    }
                }
                nbLigne++;
                lesCartes.add(newCarte);
            }
        }
        return lesCartes;
    }
}
