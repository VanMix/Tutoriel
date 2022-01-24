public class Voler extends Thread{
    private final Etat etat;

    /**
     * Constante temps utilisé pour définir la temps où le thread sera en "veille"
     */
    public static final int temps = 40;
    public Voler(Etat et){
        etat = et;
    }

    /**
     * Réécriture de la méthode run() issue de la classe Thread
     * Va faire appel à moveDown() de la classe Etat, afin de faire descendre notre anneau
     */
    @Override
    public void run(){
        while(true) {
            etat.moveDown();
            try {
                Thread.sleep(temps);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
