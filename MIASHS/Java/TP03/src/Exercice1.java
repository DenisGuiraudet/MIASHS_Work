public class Exercice1 {

    public static void main(String[] args) {

        Fraction frac1 = new Fraction(2, 3);
        Fraction frac2 = new Fraction(5, 3);
        Fraction frac3 = new Fraction(8, 9);
        Fraction frac4 = new Fraction(5, 9);

        System.out.println(frac1.toString());
        System.out.println(frac2.toString());
        System.out.println(frac3.toString());
        System.out.println(frac4.toString());

        //

        System.out.println(frac1.compareTo(frac2));

        //

        frac1.add(frac2);

        System.out.println(frac1.toString());

        frac2.add(frac3);

        System.out.println(frac2.toString());

        //

        frac1.mult(frac2);

        System.out.println(frac1.toString());

        //

        frac3.sub(frac4);

        System.out.println(frac3.toString());

        frac1.sub(frac3);

        System.out.println(frac1.toString());

    }

}
