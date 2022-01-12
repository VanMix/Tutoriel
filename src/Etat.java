/**
 * La classe Etat représente ici notre Modèle qui définit l’ensemble des données qui caractérisent l’état de notre interface. 
 * En fonction des changements effectués avec la classe Control, l’affichage dans l’interface graphique sera modifié.
 * @author claslui
 *
 */
public class Etat {
	
	//Ici la valeur hauteur n'est pas considéré comme une constante car elle sera modifié en fonction des actions effectués dans la classe Control
	private static int y;
	
	private final Affichage fenetre;
	
	public Etat(Affichage fen) {
		y = 200;
		fenetre = fen;
	
	}
	
	/* Getter permettant de récupérer la valeur de l'attribut hauteur*/
	public int getY() {
		return y;
	}
	
	/**
	 * Permet à notre anneau de monter ou descendre en fonction de saut si l'on reste dans les bornes de la fenetre,
	 * tout en respectant le fait que le centre de la figure n'est pas son centre mais le coin supérieur gauche de la figure.
	 * @param saut, un entier relatif
	 */
	public void jump(int saut) {
		int majSaut = y + saut;
		int borneHeight = (int)(fenetre.getOvY()*1.2); //borne supérieur de notre fenetre
		if(majSaut > 0 && majSaut + borneHeight < fenetre.getHeight()) //Condition pour tester si l'on est dans les bornes
			y = majSaut;
	}

}
