public class Entree {

    private int valeur;
    private Entree next;

    public Entree(int valeur, Entree next) {

        this.valeur = valeur;
        this.next = next;

    }

    // GET & SET

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public Entree getNext() {
        return next;
    }

}
