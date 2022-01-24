import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;

public class Avancer extends Thread{

    public static final int tempsAvancer = 100;
    private Parcours parcours;

    // constructeur

    public Avancer(Parcours p) {
        this.parcours = p;
    }

    // thread pour faire avancer la ligne
    @Override
    public void run() {
        while (true) {

            try {
                parcours.majParcours();
                parcours.removePointInvisible();
                parcours.addPointInvisible();
                Thread.sleep(tempsAvancer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
