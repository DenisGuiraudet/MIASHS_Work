public class Exercice2 {

    public static void main(String[] args) {

        Pile pile1 = new Pile();

        pile1.empiler(2);
        System.out.println(pile1.sommet());
        pile1.empiler(4);
        System.out.println(pile1.sommet());
        pile1.empiler(6);
        System.out.println(pile1.sommet());
        pile1.empiler(8);
        System.out.println(pile1.sommet());

        for (int val: pile1.getArray()) {
            System.out.print(val + ", ");
        }
        System.out.println("");

        //

        int[] tab = {10, 20, 30, 40, 50};
        Pile pile2 = new Pile(tab);

        for (int val: pile2.getArray()) {
            System.out.print(val + ", ");
        }
        System.out.println("");

        //

        Pile pile3 = pile2.clone();
        pile2.depiler();

        for (int val: pile3.getArray()) {
            System.out.print(val + ", ");
        }
        System.out.println("");

        for (int val: pile2.getArray()) {
            System.out.print(val + ", ");
        }
        System.out.println("");

        //

        Pile pile4 = new Pile();
        System.out.println(pile4.pileVide());
        //pile4.depiler();
        pile4.empiler(1);
        System.out.println(pile4.pileVide());
        pile4.depiler();
        System.out.println(pile4.pileVide());

    }

}
