public class Fusion {

    public static void main(String[] args) {

        int[] tab1 = {11, 27, 33, 78, 95, 106, 420};
        int[] tab2 = {2, 55, 68, 95, 101, 102};

        for (int val1: tab1) {
            System.out.print(";" + val1);
        }
        System.out.println("");

        for (int val2: tab2) {
            System.out.print(";" + val2);
        }
        System.out.println("");

        //

        int[] newTab = fusionTable(tab1, tab2);

        System.out.println("oui" + newTab.length);

        for (int val3: newTab) {
            System.out.print(";" + val3);
        }

    }

    private static int[] fusionTable(int[] tab1, int[] tab2) {

        int[] newTab = {};

        int index1 = 0;
        int index2 = 0;

        while (index1 < tab1.length && index2 < tab2.length) {

            System.out.println(index1 + "!" + index2 + "?" + (tab1.length + tab2.length));

            if (tab1[index1] < tab2[index2]) {

                newTab = addElement(newTab, tab1[index1]);
                index1++;

            } else {

                newTab = addElement(newTab, tab2[index2]);
                index2++;

            }

        }

        while (index1 < tab1.length) {

            newTab = addElement(newTab, tab1[index1]);
            index1++;

        }

        while (index2 < tab2.length) {

            newTab = addElement(newTab, tab2[index2]);
            index2++;

        }

        return newTab;

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
