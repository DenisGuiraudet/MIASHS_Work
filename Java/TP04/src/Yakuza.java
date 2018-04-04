public class Yakuza extends Humain {

    private String clan;
    private int reputation;

    //

    public Yakuza(String nom, String boisson, int argent, String clan) {
        super(nom, boisson, argent);

        this.clan = clan;
        this.reputation = 0;

    }

    //

    public void extorquer(Commercant commercant) {

        this.ajouterArgent(commercant.getArgent());
        commercant.seFaireExtorquer();

        reputation++;

        this.parler("Je viens d'extorquer " + commercant.getNom() + " !");

    }

    public void gagner(Ronin ronin) {

        reputation++;

        this.parler("J'ai vaincu " + ronin.getNom() + " ! Alors on fait moins le fier ?");

    }

    public void perdre(Ronin ronin) {

        this.perdreArgent(this.getArgent());

        reputation--;

        this.parler("J'ai été vaicu par " + ronin.getNom() + ".");

    }

    public String getClan() {
        return clan;
    }

    public int getReputation() {
        return reputation;
    }

    @Override
    public void direBonjour() {

        this.parler("Bonjour ! Je me nomme " + this.getNom() + " et j'aime boire du " + this.getBoisson() + " j'appartiens au clan " + this.clan);


    }
}
