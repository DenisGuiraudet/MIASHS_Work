import java.util.ArrayList;
import java.util.HashSet;

public class Game {

    private HashSet<Coord> damier;
    private int nbLigs, nbCols;

    // CONSTRUCTEUR

    public Game(int nbLigs, int nbCols) {

        this.damier = new HashSet<>();
        this.nbLigs = nbLigs;
        this.nbCols = nbCols;

    }

    public Game(Coord[] listeInitiale, int nbLigs, int nbCols) {

        this.damier = new HashSet<>();
        for (Coord coordBis: listeInitiale) {
            damier.add(coordBis);
        }

        this.nbLigs = nbLigs;
        this.nbCols = nbCols;

    }

    public int getNbLigs() {
        return this.nbLigs;
    }

    public int getNbCols() {
        return this.nbCols;
    }

    // AFFICHAGE

    public boolean estVivante(Coord coord) {

        if (damier.contains(coord)) return true;

        return false;

    }

    private String showCell(Coord coord) {

        if (estVivante(coord)) return "#";

        return ".";

    }

    private String showLig(Integer numLig) {

        String str = "";

        for (int i = 0; i < nbCols; i++) {
            str = str + showCell(new Coord(numLig, i)) + " ";
        }

        return str;

    }

    @Override
    public String toString() {

        String str = "";

        for (int i = 0; i < nbLigs; i++) {
            str = str + showLig(i) + "\n";
        }

        return str;

    }

    // IMPLEMENTATION JEU

    private int nbVoisinesVivantes(Coord coord) {

        int nbVoisins = 0;

        for (int ligBis = coord.getLig() - 1; ligBis <= coord.getLig() + 1; ligBis++) {
            for (int colBis = coord.getCol() - 1; colBis <= coord.getCol() + 1; colBis++) {
                Coord coordBis = new Coord(ligBis, colBis);
                if (this.estVivante(coordBis)) {
                    if (!coord.equals(coordBis)) nbVoisins++;
                }
            }
        }

        return nbVoisins;

    }

    private boolean evolution(Coord coord) {

        switch (nbVoisinesVivantes(coord)) {
            case 2:
                if (this.estVivante(coord)) return true;
                return false;
            case 3:
                return true;
            default:
                return false;
        }

    }

    public boolean nextGen() {

        boolean hasntChanged = true;

        HashSet<Coord> coords = new HashSet<>();

        for (int ligBis = 0; ligBis < this.nbLigs; ligBis++) {
            for (int colBis = 0; colBis < this.nbCols; colBis++) {

                Coord coordBis = new Coord(ligBis, colBis);

                if (this.evolution(coordBis)) {
                    coords.add(coordBis);
                    hasntChanged = false;
                }

            }
        }


        this.damier = coords;

        return hasntChanged;

    }

}
