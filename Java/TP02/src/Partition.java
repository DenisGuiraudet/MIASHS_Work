public class Partition {

    public static void main(String[] args) {

        int[] tab = {(int)(Math.random() * 100), (int)(Math.random() * 100), (int)(Math.random() * 100), (int)(Math.random() * 100)};
        int cutVal = 50;

        for (int val: tab) {
            System.out.print(";" + val);
        }
        System.out.println("");

        //

        int[][] newTab = cutTable(tab, cutVal);

        for (int[] table: newTab) {
            System.out.print("/");
            for (int value: table) {
                System.out.print(";" + value);
            }
        }

    }

    private static int[][] cutTable(int[] tab, int cutVal) {

        int[] tab1 = {};
        int[] tab2 = {};

        for (int val: tab) {

            if (val <= cutVal) {

                tab1 = addElement(tab1, val);

            } else {

                tab2 = addElement(tab2, val);

            }

        }

        int[][] superTab = {tab1, tab2};
        return superTab;

    }

    private static int[] addElement(int[] oldTab, int elem) {

        int[] newTab = new int[oldTab.length + 1];

        for (int i = 0; i < oldTab.length; i++) {

            newTab[i] = oldTab[i];

        }

        newTab[newTab.length - 1] = elem;
        return newTab;

    }

}
