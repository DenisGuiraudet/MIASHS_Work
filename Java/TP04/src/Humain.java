public class Humain {

    private int argent;
    private String boisson;
    private String nom;

    //

    public Humain(String nom, String boisson, int argent) {

        this.argent = argent;
        this.boisson = boisson;
        this.nom = nom;

    }

    //

    public void parler(String texte) {

        System.out.println(this.nom + " - " + texte);

    }

    public void direBonjour() {

        this.parler("Bonjour ! Je me nomme " + this.nom + " et j'aime boire du " + this.boisson);

    }

    public void boire() {

        this.parler("Ahhh, un bon verre de " + this.boisson + " ! GLOUPS !");

    }

    public void ajouterArgent(int argent) {

        this.argent += argent;

    }

    public void perdreArgent(int argent) {

        this.argent -= argent;

    }

    public int getArgent() {
        return this.argent;
    }

    public String getBoisson() {
        return this.boisson;
    }

    public String getNom() {
        return this.nom;
    }

}
