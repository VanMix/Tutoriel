import test.Voler;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		/*
		JPanel composant = new JPanel(); //composant graphique 
		JFrame fenetre = new JFrame("titre de la fenêtre"); //fenetre d'affichage 
		fenetre.add(composant); //ajout du composant dans la fenetre
		
		fenetre.pack(); //assemblage des composants 
		fenetre.setVisible(true); //on rend la fenetre visible
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fermeture de la fenetre graphique
		
		**/
		
		Affichage test = new Affichage();
		Etat modele = new Etat(test);
		Control ctrl = new Control(modele, test);
		test.addMouseListener(ctrl);
		new Voler(modele).start();
		JFrame frame = new JFrame("Fenetre principale");
		frame.add(test);
		frame.pack();
		frame.setSize(new Dimension(500, 500));
		frame.setVisible(true); //on rend la fenetre visible
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fermeture de la fenetre graphique
	}

}
