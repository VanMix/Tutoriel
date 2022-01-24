import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Parcours {
    private ArrayList<Point> coord = new ArrayList<>();
    private int ord = 200;

    private Point position = new Point(25, 200);
    public Parcours() {
        coord.add(new Point(0, ord));
        Random rdm = new Random();
        boolean monte = true;

        for (int i = 0; i < 10; i++) {
            int yRdm = rdm.nextInt(100);
            Point test = coord.get(coord.size()-1);
            if(test.y + yRdm < Affichage.height && monte){
                coord.add(new Point(rdm.nextInt(50)+test.x+25, ord + yRdm));
                ord += yRdm;
                monte = false;
            }else{
                coord.add(new Point(rdm.nextInt(50)+test.x+25, ord - yRdm));
                ord -= yRdm;
                monte = true;
            }
        }
    }

    public ArrayList<Point> getCoord() {
        ArrayList<Point> res = new ArrayList<>();
        for (Point p : coord) {
            if (p.x - position.x < Affichage.width)
                res.add(p);
        }
        return res;
    }
}
