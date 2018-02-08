public class Commercant extends Humain {

    public Commercant(String nom, int argent) {
        super(nom, "thé", argent);

    }

    //

    public void seFaireExtorquer() {

        this.perdreArgent(this.getArgent());

    }

    public void recevoir(int argent) {

        this.ajouterArgent(argent);

    }

}
