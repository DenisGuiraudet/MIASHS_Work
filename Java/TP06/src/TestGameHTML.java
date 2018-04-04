import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestGameHTML {

    public static void main(String[] args) {

        Coord[] coords = {new Coord(0, 3), new Coord(1, 2),
                new Coord(2, 2), new Coord(2, 3),
                new Coord(2, 4)};
        GameHTML jeu = new GameHTML(coords, 5, 5);

        // Boucle de calcul et d'affichage des générations
        boolean stable;

        System.out.println(jeu.initHtml());

        int nbGen = 5; // TODO : USER INPUT
        int genCourante = 1;

        do {
            System.out.println("<h2>Génération " + genCourante + "</h2>\n");
            System.out.println(jeu.toHtml());
            stable = jeu.nextGen();
            genCourante += 1;
        } while (!stable && genCourante <= nbGen);

        System.out.println(jeu.endHtml());

    }
}
