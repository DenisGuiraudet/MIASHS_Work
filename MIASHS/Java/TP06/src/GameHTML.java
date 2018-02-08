import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class GameHTML extends Game implements Webable {

    public GameHTML(Coord[] listeInitiale, int nbLigs, int nbCols) {
        super(listeInitiale, nbLigs, nbCols);

        // create file
        FileOutputStream f = null;
        try {
            f = new FileOutputStream("index.html");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.setOut(new PrintStream(f));

    }

    @Override
    public String initHtml() {

        String str = "";

        str += "<!DOCTYPE html>";
        str += "<html>";
            str += "<head>";
                str += "<meta charset=\"utf-8\">";
                str += "<title>Denis Guiraudet</title>";
                str += "<style>";
                    str += "body {";
                        str += "background-color: LimeGreen;";
                        str += "color: white;";
                    str += "}";
                    str += "td {";
                        str += "border: solid 1px blue;";
                        str += "height: 10px;";
                        str += "width: 10px;";
                    str += "}";
                str += "</style>";
            str += "</head>";
            str += "<body>";

        return str;

    }

    @Override
    public String toHtml() {

        String str = "";

        str += "<table>";
        for (int lig = 0; lig < this.getNbLigs(); lig++) {
            str += "<tr>";
            for (int col = 0; col < this.getNbCols(); col++) {
                str += "<td ";
                if (this.estVivante(new Coord(lig, col))) {
                    str += "style=\"background-color: red\"";
                } else {
                    str += "style=\"background-color: white\"";
                }
                str += "></td>";
            }
            str += "</tr>";
        }
        str += "</table>";

        return str;

    }

    @Override
    public String endHtml() {

        String str = "";

            str += "</body>";
        str += "</html>";

        return str;

    }
}
