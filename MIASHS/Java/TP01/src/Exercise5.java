import java.util.Scanner;

public class Exercise5 {

    private static int number = 0;
    private static int obj = 0;
    private static String ask = "";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {

            obj = (int)(Math.random() * 100);
            System.out.println(obj);

            do {

                do {

                    System.out.print("Entrez un nombre compris entre 1 et 100 : ");
                    number = scan.nextInt();

                } while (isNumberGood() == false);

            } while (!findMe());

            while (isAskGood() == false) {

                System.out.print("Une autre partie (o/n) : ");
                ask = scan.nextLine();

            };

        }

    }

    private static boolean isNumberGood() {

        if (number < 1 || number > 100) {
            return false;
        }

        return true;
    }

    private static boolean findMe() {

        if (number < obj) {
            System.out.println("C'est plus...");
            return false;
        } else if (number > obj) {
            System.out.println("C'est moins...");
            return false;
        }

        return true;

    }

    private static boolean isAskGood() {

        if (ask.length() == 1) {
            if(ask.charAt(0) == 'o') {
                return true;
            }
            if(ask.charAt(0) == 'n') {
                System.out.println("Au revoir...");
                System.exit(0);
            }
        }

        return false;
    }

}
