public class Exercise4 {

    public static void main(String[] args) {

        System.out.println(Math.sqrt(2));
        System.out.println(heron(2));

        // assert heron(2, 0.001) == Math.sqrt(2);           // Doit échouer !!!
        assert (Math.abs(heron(2, 0.01) - Math.sqrt(2)) <= 0.01);
        assert heron(1) == 1 && heron(0) == 0 ;

    }

    /** Renvoie la racine carrée de nbre à la précision indiquée */
    static double heron(int nbre, double precision) {

        double valeurRappro = 1;

        for (int i = 0; i < ("" + precision).length()-2; i++) {
            valeurRappro = (valeurRappro + (nbre / valeurRappro)) / 2;
        }

        return valeurRappro;

    }

    /** Renvoie la racine carrée de nbre à la précision 0.001 */
    static double heron(int nbre) {

        return heron(nbre, 0.001);

    }

}
