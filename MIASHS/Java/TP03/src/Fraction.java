public class Fraction {

    private int num;
    private int denom;

    // CONSTRUCTORS

    public Fraction(int num, int denom) {

        if (denom == 0) denom = 1;

        this.num = num;
        this.denom = denom;

    }

    public Fraction() {

        this.num = 1;
        this.denom = 1;

    }

    // GET

    public int getNum() {
        return num;
    }

    public int getDenom() {
        return denom;
    }

    // ADD & SUB

    public void add(Fraction fraction) {
        if (!this.isGood(fraction)) return;

        if (this.denom == fraction.denom) {

            this.num = this.num + fraction.num;

        } else {

            this.num = (this.num * fraction.denom + fraction.num * this.denom);
            this.denom = this.denom * fraction.denom;

        }

        this.simplifyMe();

    }

    public void add(int val) {

        this.add(new Fraction(val, 1));

    }

    public void sub(Fraction fraction) {

        this.add(new Fraction(-fraction.num, fraction.denom));

    }

    public void sub(int val) {

        this.sub(new Fraction(val, 1));

    }

    // MULT & DIV

    public void mult(Fraction fraction) {
        if (!this.isGood(fraction)) return;

        this.num = this.num * fraction.num;
        this.denom = this.denom * fraction.denom;

        this.simplifyMe();

    }

    public void mult(int val) {

        this.mult(new Fraction(val, 1));

    }

    public void div(Fraction fraction) {

        this.mult(new Fraction(fraction.denom, fraction.num));

    }

    public void div(int val) {

        this.div(new Fraction(val, 1));

    }

    // COOL STUFF

    private boolean isGood(Fraction fraction) {

        if (this.denom == 0 || fraction.denom == 0) {
            System.out.println("Error !! At least one of the fraction denominator equals 0 !");
            return false;
        }

        return true;

    }

    public void simplifyMe() {

        if (this.num == 0) return;

        int num = this.num;
        int denom = this.denom;
        int temp;

        while (denom != 0) {

            temp = num % denom;
            num = denom;
            denom = temp;

        }

        this.num = this.num / num;
        this.denom = this.denom / num;

    }

    // CLONE & COMPARETO

    public Fraction clone() {

        return new Fraction(this.num, this.denom);

    }

    public int compareTo(Fraction fraction) {

        float frac1 = (float) this.num / (float) this.denom;
        float frac2 = (float) fraction.num / (float) fraction.denom;

        if (frac1 < frac2) {

            return -1;

        } else if (frac1 > frac2) {

            return 1;

        } else {

            return 0;

        }

    }

    // OVERRIDE : TOSTRING & EQUALS

    @Override
    public String toString() {
        return "(" + this.num + "/" + this.denom + ")";
    }

    @Override
    public boolean equals(Object obj) {
        Fraction fraction = null;
        try {
            fraction = (Fraction) obj;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

        this.simplifyMe();
        fraction.simplifyMe();

        if ((this.num == fraction.num) && (this.denom == fraction.denom)) {

            return true;

        }

        return false;

    }
}
