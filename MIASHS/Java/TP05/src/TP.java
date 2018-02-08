import java.util.HashMap;

public class TP {

    private HashMap<Integer, Etudiant> etudiants;

    public TP() {

        this.etudiants = new HashMap<>();

    }

    public static void main(String[] args) {

        TP tp = new TP();

        Etudiant denis = new Etudiant((int)(Math.random() * 1000) + 1, "Guiraudet", "Denis");
        denis.addNote(18);
        denis.addNote(14);
        denis.addNote(16);
        tp.addEtudiant(denis);

        Etudiant matthieu = new Etudiant((int)(Math.random() * 1000) + 1, "Orriere", "Matthieu");
        matthieu.addNote(2);
        tp.addEtudiant(matthieu);

        Etudiant arnaud = new Etudiant((int)(Math.random() * 1000) + 1, "Sibade", "Arnaud");
        arnaud.addNote(6);
        arnaud.addNote(8);
        tp.addEtudiant(arnaud);

        Etudiant titouan = new Etudiant((int)(Math.random() * 1000) + 1, "BG", "Titouan");
        titouan.addNote(5);
        tp.addEtudiant(titouan);

        System.out.println(tp.getEtudiants().toString());

    }

    public HashMap<Integer, Etudiant> getEtudiants() {
        return etudiants;
    }

    public void addEtudiant(Etudiant etudiant) {

        etudiants.put(etudiant.getNumEtu(), etudiant);

    }

}
