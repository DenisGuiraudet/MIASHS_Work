public class MonHistoire {

    public static void main(String[] args) {

        Humain h = new Humain("Prof" ,  "Porto", 10);
        h.direBonjour();
        h.boire();
        Commercant c = new Commercant("Marchand" ,  35);
        c.direBonjour();

        Yakuza y = new Yakuza ("Yaku le noir" , "bière" ,  42 ,  "WarSong");
        y.direBonjour();
        y.extorquer(c);

        Ronin r = new Ronin ("Roro" ,  "saké" ,  61);
        r.donner(c, 10) ;
        r.provoquer (y );
        r.direBonjour();

        Samurai s = new Samurai ("Sam",  "vodka", 100,  "Tupak");
        s.direBonjour();
        s.boire ("cacao");

        Traitre t = new Traitre("Gin", "eau", 50, "Milord");
        t.extorquer(c);
        t.extorquer(c);
        t.direBonjour();
        t.faireLeGentil(s, 10);
        t.direBonjour();

        GrandMere gd = new GrandMere("Mireille", 8);
        gd.faireConnaissanceAvec(h);
        gd.faireConnaissanceAvec(y);
        gd.faireConnaissanceAvec(r);
        gd.faireConnaissanceAvec(s);
        gd.faireConnaissanceAvec(t);
        gd.ragoter();

    }

}
