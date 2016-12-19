/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetreigns;

/**
 *
 * @author etudiant
 */
public interface Pile {
	/* 
	 * méthodes abstraites de gestion d'une pile 
	 * */

	public boolean estVide();
	public void empiler (Carte uneCarte);
	public Carte sommet();
	public void depiler() throws PileVideException;

}

