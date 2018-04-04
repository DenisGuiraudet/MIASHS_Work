public class Samurai extends Ronin {

    private String seigneur;

    public Samurai(String nom, String boisson, int argent, String seigneur) {
        super(nom, boisson, argent);

        this.seigneur = seigneur;

    }

    @Override
    public void direBonjour() {

        this.parler("Bonjour ! Je me nomme " + this.getNom() + " et j'aime boire du " + this.getBoisson() + " je sers mon seigneur " + this.seigneur);

    }

    public void boire(String boisson) {

        this.parler("Ahhh, un bon verre de " + boisson + " ! GLOUPS !");

    }

    public String getSeigneur() {
        return this.seigneur;
    }

}
