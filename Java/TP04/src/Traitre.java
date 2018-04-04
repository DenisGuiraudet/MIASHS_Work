public class Traitre extends Samurai {

    private int traitrise;

    public Traitre(String nom, String boisson, int argent, String seigneur) {
        super(nom, boisson, argent, seigneur);

        this.traitrise = 0;

    }

    public void extorquer(Commercant commercant) {

        if (traitrise >= 3) {

            this.parler("Comment je suis trop méchant pour me rabaisser à un tel acte !");

        } else {

            this.ajouterArgent(commercant.getArgent());
            commercant.seFaireExtorquer();

            traitrise++;

            this.parler("Je viens d'extorquer " + commercant.getNom() + " !");

        }

    }

    @Override
    public void direBonjour() {

        this.parler("Bonjour ! Je me nomme " + this.getNom() + " et j'aime boire du " + this.getBoisson() + " je sers mon seigneur " + this.getSeigneur() + " et mon niveau de traitrise est " + this.traitrise);

    }

    public void faireLeGentil(Humain humain, int argent) {

        humain.ajouterArgent(argent);
        this.perdreArgent(argent);

        this.traitrise -= argent / 10;
        if (this.traitrise < 0) this.traitrise = 0;

    }

}
