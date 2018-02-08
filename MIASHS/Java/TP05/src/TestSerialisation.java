import java.io.*;
class TestSerialisation {
    public static void main(String[] args) {

        // Sérialisation
        try ( ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("VecteurCreux.java")) ) {
            VecteurCreux vc1 = new VecteurCreux(4, 10);
            System.out.println("obj1 = " + vc1);
            os.writeObject(vc1);
        }catch(IOException e){
            System.err.println("Erreur pendant la sérialisation : " + e);
            System.exit(1);
        }

        // Désérialisation
        try ( ObjectInputStream is = new ObjectInputStream(new FileInputStream("VecteurCreux.java")) ) {
            //MaClass obj2 = (MaClasse)is.readObject();
            VecteurCreux vc2 = (VecteurCreux)is.readObject();
            System.out.println("obj2 = " + vc2);
        }catch(IOException | ClassNotFoundException e){
            System.err.println("Erreur pendant la désérialisation : " + e);
            System.exit(2);
        }

    }
}