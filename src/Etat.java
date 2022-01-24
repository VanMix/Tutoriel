/**
 * La classe Etat représente ici notre Modèle qui définit l’ensemble des données qui caractérisent l’état de notre interface. 
 * En fonction des changements effectués avec la classe Control, l’affichage dans l’interface graphique sera modifié.
 * @author claslui
 *
 */
public class Etat {
	
	//Ici la valeur hauteur n'est pas considéré comme une constante car elle sera modifié en fonction des actions effectués dans la classe Control
	public static int hauteur = 200;
	public static final int down = 2;
	public static final int up = 20;

	private final Affichage fenetre;
	private final Parcours route = new Parcours();
	
	public Etat(Affichage fen) {
		fenetre = fen;
	}
	
	/* Getter permettant de récupérer la valeur de l'attribut hauteur*/
	public int getY() {
		return hauteur;
	}

	public Parcours getRoute() {
		return route;
	}

	public boolean limits(){
		int majSaut = hauteur - up;
		int borneHeight = (int)(fenetre.getOvY()*1.2); //borne supérieur de notre fenetre
		return majSaut > 0 && majSaut + borneHeight < fenetre.getHeight(); //Condition pour tester si l'on est dans les bornes
	}
	/**
	 * Permet à notre anneau de monter ou descendre en fonction de saut si l'on reste dans les bornes de la fenetre,
	 * tout en respectant le fait que le centre de la figure n'est pas son centre mais le coin supérieur gauche de la figure.
	 */
	public void jump() {
		if(limits()) //Condition pour tester si l'on est dans les bornes
			hauteur -= up;
	}

	/**
	 * méthode permettant de faire descendre linéairement notre anneau, mettra à jour l'affichage de notre anneau
	 * appelé dans le thread de la classe Voler
	 */
	public void moveDown(){
		int majSaut = hauteur + down;
		int borneHeight = (int)(fenetre.getOvY()*1.2); //borne supérieur de notre fenetre
		if(majSaut > 0 && majSaut + borneHeight < fenetre.getHeight()) { //Condition pour tester si l'on est dans les bornes
			hauteur = majSaut;
			fenetre.revalidate();
			fenetre.repaint();
		}
	}
}
