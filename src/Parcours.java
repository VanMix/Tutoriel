import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Parcours {
    private ArrayList<Point> coord = new ArrayList<>();

    public static final int longueurMinLigne = 70;
    public static final int longueurMaxLigne = 200;
    public static final int bordureMinLigne = 100;
    public static final int bordureMaxLigne = Affichage.height - 100;
    public static final int plage = bordureMaxLigne - bordureMinLigne;

    private int position = 0;
    private Point positionDepart;

    public Parcours() {
        positionDepart = new Point(Affichage.dimOvalX,
                Affichage.height - Affichage.dimOvalY / 2);
        coord.add(positionDepart);

        int x = positionDepart.x;
        int y = positionDepart.y;
        Random r = new Random();

        coord.add(new Point(x, y));

        while (x < Affichage.width) {
            x = x + r.nextInt(longueurMaxLigne - longueurMinLigne) + 20;
            y = (r.nextInt(plage) + bordureMinLigne);
            Point newPoint = new Point(x, y);
            coord.add(newPoint);
        }
        new Thread(new Avancer(this)).start();
    }

    public int getPosition(){
        return position;
    }

    public ArrayList<Point> getCoord() {
        return coord;
    }

    public void setPosition(int pos) {
        position += pos;
    }

/*
    public ArrayList<Point> getCoords() {
        ArrayList<Point> res = new ArrayList<>();
        for (Point p : coord) {
            if (p.x - position < Affichage.width)
                res.add(p);
        }
        return res;
    }*/

    /**
     * public boolean gagner(Point p1, Point p2){ float pente = (p2.y - p1.y )/
     * (p2.x - p1.y); float y = p1.y - pente *(p1.x - this.getPositionX()); if()
     * return false; }
     *
     *
     */
    // méthode qui ajoute un point en dehors du visible afin de faire continuer la
    // ligne
    public void addPointInvisible() {
        if (coord.get(coord.size() - 1).x < Affichage.width) {
            int x = coord.get(coord.size() - 1).x;
            Random r = new Random();
            x = x + r.nextInt(longueurMaxLigne - longueurMinLigne) +50;
            int y = r.nextInt(plage) + 50;
            if (coord.get(coord.size() - 1).y - y < 200 || coord.get(coord.size() - 1).y - y > -200)
                coord.add(new Point(x, y));
            else
                coord.add(new Point(x, y - 100));
        }
    }

    // méthode qui supprimme les points en dehors du visible
    public void removePointInvisible() {
        if (coord.get(0).x < 0 && coord.get(1).x < 0) {
            coord.remove(0);
        }
    }

    public void majParcours(){
        for(Point p : coord){
            p.move(p.x - 5, p.y);
        }
    }
    // méthode qui gère le déplacement de la ligne vers la droite
    public ArrayList<Point> getParcours() {
        ArrayList<Point> copie = coord;
        for (Point point : copie) {
            if(point.x < Affichage.width)
                copie.add(point);
        }
        return copie;
    }
}
