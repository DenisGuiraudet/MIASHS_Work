import java.util.ArrayList;

public class Ensemble_ArrayList {

    public static void main(String[] args) {

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        //for (int i = 0; i < (int)(Math.random() * 10); i++) list1.add((int)(Math.random() * 10));
        //for (int i = 0; i < (int)(Math.random() * 10); i++) list2.add((int)(Math.random() * 10));

        list1.add(4); list1.add(5); list1.add(6); list1.add(6);
        list2.add(2); list2.add(5); list2.add(3);

        System.out.println(list1);
        System.out.println(list2);

        //

        System.out.println("Reunion" + reunion(list1, list2));

        //

        System.out.println("Intersection" + intersection(list1, list2));

        //

        System.out.println("Difference" + difference(list1, list2));

        //

        System.out.println("Difference Symetrique" + differenceSymetrique(list1, list2));

    }

    private static boolean recherche(ArrayList<Integer> list, Integer val) {

        for (Integer value: list) {

            if (Integer.compare(value, val) == 0) {

                return true;

            }

        }

        return false;

    }

    private static int rechercheIndex(ArrayList<Integer> list, Integer val) {

        for (int i = 0; i < list.size(); i++) {

            if (Integer.compare(list.get(i), val) == 0) {

                return i;

            }

        }

        return list.size(); // ERREUR !

    }

    private static ArrayList<Integer> reunion(ArrayList<Integer> list1, ArrayList<Integer> list2) { // A ∪ B

        ArrayList<Integer> newList = new ArrayList<Integer>(list1);

        for (Integer val: list2) {

            newList.add(val);

        }

        return newList;

    }

    private static ArrayList<Integer> intersection(ArrayList<Integer> list1, ArrayList<Integer> list2) { // A ∩ B

        ArrayList<Integer> newList = new ArrayList<Integer>();

        for (Integer val: list1) {

            if (recherche(list2, val)) {

                newList.add(val);

            }

        }

        return newList;

    }

    private static ArrayList<Integer> difference(ArrayList<Integer> list1, ArrayList<Integer> list2) { // A \ B = A ∩ B c

        ArrayList<Integer> newList = new ArrayList<Integer>();

        for (Integer val1: list1) {

            if (!recherche(list2, val1)) {

                newList.add(val1);

            }

        }

        return newList;

    }

    private static ArrayList<Integer> differenceSymetrique(ArrayList<Integer> list1, ArrayList<Integer> list2) { // A Δ B = (A ∩ B c) ∪ (A c ∩ B)

        ArrayList<Integer> newList = new ArrayList<Integer>();

        for (Integer val1: list1) {

            if (!recherche(list2, val1)) {

                newList.add(val1);

            }

        }

        for (Integer val2: list2) {

            if (!recherche(list1, val2)) {

                newList.add(val2);

            }

        }

        return newList;

    }

}
