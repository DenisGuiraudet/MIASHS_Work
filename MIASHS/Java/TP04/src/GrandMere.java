public class GrandMere extends Humain {

    private Humain[] memoire;

    public GrandMere(String nom, int argent) {
        super(nom, "tisane", argent);

        this.memoire = new Humain[30];

    }

    private String humainHasard() {

        int random = (int)(Math.random() * 5) + 1;

        switch (random) {
            case 1:
                return "Commerçant";
            case 2:
                return "Humain";
            case 3:
                return "Ronin";
            case 4:
                return "Samurai";
            case 5:
                return "Yakuza";
            default:
                return "";
        }

    }

    public void faireConnaissanceAvec(Humain humain) {

        for (int i = 0; i < memoire.length - 1; i++) {

            if (memoire[i] == null) {

                memoire[i] = humain;
                break;

            }

        }

    }

    public void ragoter() {

        for (Humain humain: memoire) {

            if (humain != null) {

                if (humain instanceof Traitre) {

                    this.parler("hep hep hep " + humain.getNom() + " tu serais pas un sale traitre ?");

                } else {

                    this.parler("Je crois que " + humain.getNom() + " est un " + humainHasard());

                }

            } else {

                break;

            }



        }

    }

}
