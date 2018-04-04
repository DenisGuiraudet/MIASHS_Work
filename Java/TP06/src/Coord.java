public class Coord {

    private int lig, col;

    public Coord(int lig, int col) {

        this.lig = lig;
        this.col = col;

    }

    public int getLig() {
        return lig;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object obj) {

        try {

            Coord coordBis = (Coord)obj;
            if (this.getLig() == coordBis.getLig() &&
                    this.getCol() == coordBis.getCol()) {
                return true;
            }

            return false;

        }catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    @Override
    public int hashCode() {
        return String.format("%s,%s", lig, col).hashCode();
    }

}
