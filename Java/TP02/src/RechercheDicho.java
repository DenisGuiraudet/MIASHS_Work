public class RechercheDicho {

    public static void main(String[] args) {

        int[] tab = {1,2,3,4,5,6,7,8,9};
        int findVal = 6;

        for (int val: tab) {
            System.out.print(";" + val);
        }
        System.out.println("");

        findVal(tab, findVal);

    }

    private static void findVal(int[] tab, int val) {

        int debut = 0;
        int fin = tab.length - 1;
        int mil;
        boolean find = false;

        do {

            mil = (debut + fin) / 2;

            if (tab[mil] == val) {

                find = true;

            } if (val > tab[mil]) {

                debut = mil + 1;

            } else {

                fin = mil - 1;

            }

        } while (find == false && debut <= fin);

        if (find == true) {
            System.out.println(val + " trouve au rang " + mil);
        } else {
            System.out.println(val + " pas trouve");
        }

    }

}
