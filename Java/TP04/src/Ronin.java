public class Ronin extends Humain {

    private int honneur;

    public Ronin(String nom, String boisson, int argent) {
        super(nom, boisson, argent);

        this.honneur = 1;

    }

    public void donner(Commercant commercant, int argent) {

        commercant.recevoir(argent);
        this.perdreArgent(argent);

    }

    public void provoquer(Yakuza yakuza) {

        if (this.honneur * 2 > yakuza.getReputation()) {

            this.ajouterArgent(yakuza.getArgent());

            honneur++;

            this.parler("J'ai vaincu " + yakuza.getNom() + " puisse t'il reposer en paix.");

            yakuza.perdre(this);

        } else {

            honneur--;

            this.parler("J'ai été vaicu par " + yakuza.getNom() + ".");

            yakuza.gagner(this);

        }

    }

}
