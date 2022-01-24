import java.awt.*;
import javax.swing.JPanel;

/**
 * La Classe Affichage définit l’affichage de notre fenetre, c'est à dire comment l’état du modèle est rendu visible à l’utilisateur.
 * Pour que cela puisse être possible, cette classe hérite de JPanel.
 * Avec sa fonction paint redéfinie depuis la classe JPanel, nous pourrons rendre visible notre modèle à l'utilisateur.
 * @author claslui
 *
 */

public class Affichage extends JPanel{

	private final JPanel crea;

	/**
	 * Les 2 constantes suivantes (largeur et hauteur) sont définis de tel sorte à imposer une limite de longueur à notre fenetre.
	 */
	public static final int width = 500;
	public static final int height = 500;
	
	/**
	 * Nous ne définissons qu'une seule constante x car nous n'allons effectuer qu'un mouvement vertical
	 */
	private static final int x = 50;
	
	/**
	 * Les 2 constantes suivantes représente la dimension de notre figure
	 */
	private static final int dimOvalX = 30;
	private static final int dimOvalY = 100;
	
	private final Etat liaison = new Etat(this); 

	/**
	 * Constructeur initialisant un nouveau JPanel et en lui mettant une dimension de : largeur * hauteur
	 */
	public Affichage () {
		crea = new JPanel();
		crea.setPreferredSize(new Dimension(width, height)); //Dimension du composant
		System.out.println(liaison.getRoute().getCoord().size());
	}
		
	public Etat getLiaison(){
		return liaison;
	}
	/**
	 * Getter pour récupérer la constante largeur 
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Getter pour récupérer la constante hauteur 
	 */
	public int getHeight() {
		return height;
	}
	
	
	public int getOvY() {
		return dimOvalY;
	}

	/**
	 * Méthode permettant de dessiner sur notre interface graphique l'ovale
	 * @param g
	 */
	public void drawOval(Graphics g){
		g.setColor(Color.BLUE); //On définit la couleur de l'anneau comme étant du bleu
		g.drawOval(x, liaison.getY(), dimOvalX, dimOvalY); //On dessine notre anneau en fonction de la valeur renvoyé par "liaison.getHauteur()"
		//La figure tracé est dessiné sur dimOvalX + 1 pixels, de même pour dimOvalY
	}


	/**
	 * Méthode permettant de dessiner sur notre interface graphiquela ligne brisée
	 * @param g
	 */
	public void drawLigneBrisee(Graphics g){
		for(int i = 0; i < liaison.getRoute().getCoord().size() - 2; i++) {
			Point p1 = liaison.getRoute().getCoord().get(i);
			Point p2 = liaison.getRoute().getCoord().get(i+1);

			g.setColor(Color.RED); //On définit la couleur de l'anneau comme étant du bleu
			g.drawLine(p1.x, p1.y, p2.x, p2.y);

		}
	}
	/*Affichage de notre anneau
	 *On utilise la méthode drawOval() pour dessiner notre figure. il faut cependant prendre en compte que le point de départ de la figure n'est pas le centre, 
	 *mais le coin supérieur gauche 
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		drawOval(g);
		drawLigneBrisee(g);
	}


}
