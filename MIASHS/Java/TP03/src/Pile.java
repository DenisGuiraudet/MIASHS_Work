import java.util.ArrayList;

public class Pile {

    private Entree sommet;

    // CONSTRUCTORS

    public Pile() {

        this.sommet = null;

    }

    public Pile(int[] tab) {

        this.sommet = null;

        for (int val: tab) {

            this.empiler(val);

        }

    }

    // SOMMET

    public int sommet() {

        return this.sommet.getValeur();

    }

    // PILEVIDE

    public boolean pileVide() {

        if (this.sommet == null) {
            return true;
        } else {
            return false;
        }

    }

    // EMPILER & DEPILER

    public Entree empiler(int valeur) {

        this.sommet = new Entree(valeur, this.sommet);

        return this.sommet;

    }

    public Entree depiler() throws InvalidOperationException {

        if (this.pileVide()) throw new InvalidOperationException();

        this.sommet = this.sommet.getNext();

        return this.sommet;

    }

    // CLONE

    public Pile clone() {

        Pile pile = new Pile();
        int[] tab = this.getArray();

        for (int val: tab) {

            pile.empiler(val);

        }

        return pile;

    }

    // GETARRAY

    public int[] getArray() {

        int[] tab = {};
        Entree entree = this.sommet;

        while (entree != null) {

            tab = addElement(tab, entree.getValeur());
            entree = entree.getNext();

        }

        int[] newTab = {};

        for (int i = tab.length-1; i >= 0; i--) {

            newTab = addElement(newTab, tab[i]);

        }

        return newTab;

    }

    private static int[] addElement(int[] oldTab, int elem) {

        int[] newTab = new int[oldTab.length + 1];

        for (int i = 0; i < oldTab.length; i++) {

            newTab[i] = oldTab[i];

        }

        newTab[newTab.length - 1] = elem;
        return newTab;

    }

}
