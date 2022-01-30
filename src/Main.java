
import java.awt.*;
import java.io.IOException;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) throws IOException {
		Parcours t = new Parcours();
		Affichage aff = new Affichage();
		Control ctrl = new Control(aff.getLiaison(), aff);
		aff.addMouseListener(ctrl);
		new Thread(new Voler(aff.getLiaison())).start();

		JFrame frame = new JFrame("Fenetre principale");

		// thread pour la methode de collision et la fenetre d'arret
		(new Thread(new Stop(aff))).start();

		frame.add(aff);
		frame.pack();
		frame.setSize(new Dimension(500, 500));
		frame.setVisible(true); //on rend la fenetre visible
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fermeture de la fenetre graphique
	}

}
