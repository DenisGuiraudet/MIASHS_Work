import java.util.ArrayList;

public class Etudiant {

    private Integer numEtu;
    private String nom;
    private String prenom;
    private ArrayList<Integer> notes;

    public Etudiant(Integer numEtu, String nom, String prenom) {

        this.numEtu = numEtu;
        this.nom = nom;
        this.prenom = prenom;
        this.notes = new ArrayList<>();

    }

    public Integer getNumEtu() {
        return numEtu;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public ArrayList<Integer> getNotes() {
        return notes;
    }

    public void addNote(Integer note) {

        this.notes.add(note);

    }

    @Override
    public String toString() {

        return (this.nom + "_" + this.prenom + "=" + this.notes);

    }
}
