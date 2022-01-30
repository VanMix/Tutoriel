import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * La classe Control a été définie de tel sorte à pouvoir diriger la manière dont l’état du modèle change :
 * c’est ce qui va servir à faire le lien entre l'interface graphique et les autres classes crées. 
 * Il effectue les changements dans le modèle et informe la vue d’un changement. 
 * Etant donné que notre interface est interactive, cette classe se charge aussi de certains événements.
 * En effet, nous implémentons l'interface MouseListener afin de gérer des événements en rapport avec la souris.
 * @author claslui
 *
 */
public class Control implements MouseListener{

	private final Etat modele;
	private final Affichage fenetre;
	
	/**
	 * Constructeur permettant de créer notre controleur
	 * @param mod, un modèle de type Etat
	 * @param aff, un affichage correspondant à l'interface graphique 
	 */
	public Control(Etat mod, Affichage aff) {
		modele = mod;
		fenetre = aff;
	}
	
	/**
	 * Gère la montée ou descente de notre anneau en fonction du clic gauche ou droit de la souris 
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) { //Si clic gauche, alors on fait monter notre anneau tout en rafraichissant notre fênetre avec la méthode repaint
			modele.jump();
		}
	}

	
	//N'étant intéréssé que par le clic de souris, les autres méthodes n'ont pas étés implémentés totalement
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
