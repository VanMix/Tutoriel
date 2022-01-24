
import java.awt.*;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		Parcours t = new Parcours();
		for(Point p : t.getCoord()){
			System.out.println(p.getX()+", "+p.getY());
		}
		Affichage aff = new Affichage();
		Control ctrl = new Control(aff.getLiaison(), aff);
		aff.addMouseListener(ctrl);
		new Thread(new Voler(aff.getLiaison())).start();
		JFrame frame = new JFrame("Fenetre principale");
		frame.add(aff);
		frame.pack();
		frame.setSize(new Dimension(500, 500));
		frame.setVisible(true); //on rend la fenetre visible
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fermeture de la fenetre graphique
	}

}
