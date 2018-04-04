import java.util.InputMismatchException;
import java.util.Scanner;

public class TestGame {

    public static void main(String[] args) {

        Coord[] coords = {new Coord(0, 3), new Coord(1, 2),
                new Coord(2, 2), new Coord(2, 3),
                new Coord(2, 4)};
        Game jeu = new Game(coords, 5, 5);

        Scanner clavier = new Scanner(System.in);
        int nbGen = 0;
        do {
            System.out.print("Combien de générations voulez-vous étudier ? ");
            try {
                nbGen = clavier.nextInt();
            } catch (InputMismatchException e) {
                clavier.nextLine();
            }
        } while (nbGen <= 0);

        // Boucle de calcul et d'affichage des générations
        boolean stable;
        int genCourante = 1;
        do {
            System.out.println("*** Génération " + genCourante + " ***");
            System.out.println(jeu);
            stable = jeu.nextGen();
            genCourante += 1;
        } while (!stable && genCourante <= nbGen);

    }
}
