import javax.swing.JOptionPane;

public class Stop extends Thread {
    private Affichage fenetre;

    public Stop(Affichage aff) {
        fenetre = aff;
    }

    @Override
    public void run() {
        while (Affichage.isFinDePartie()) {
            if (fenetre.getLiaison().testPerdu()) {
                JOptionPane.showMessageDialog(null, "score : "+fenetre.getLiaison().getRoute().getPosition(), "Game over", JOptionPane.PLAIN_MESSAGE);
                Affichage.setFinDePartie();
            }
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}