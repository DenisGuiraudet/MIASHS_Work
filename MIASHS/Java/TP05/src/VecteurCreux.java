import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class VecteurCreux extends HashMap implements Serializable {

    private static final long serialVersionUID = 2012L;

    private Integer creux;
    private Integer max;

    public VecteurCreux(Integer creux, Integer max) {
        super();

        this.creux = creux;
        this.max = max;

    }

    public static void main(String[] args) {

        VecteurCreux vc1 = new VecteurCreux(1, 100);
        VecteurCreux vc2 = new VecteurCreux(1, 100);

        vc1.put(1,10);
        vc1.put(90, 1);
        vc1.put(99,30);
        vc1.put(100,50);

        vc2.put(50,300);
        vc2.put(30,350);
        vc2.put(20,400);
        vc2.put(1,100);

        System.out.println(vc1);
        System.out.println(vc2);
        System.out.println("");

        vc1.addition(vc2);

        System.out.println(vc1);
        System.out.println(vc2);
        System.out.println("");

        vc1.multiplication(10);

        // Put 'toString' out of comments for this one
        System.out.println(vc1);
        System.out.println(vc2);
        System.out.println("");

    }

    @Override
    public Object put(Object key, Object value) {

        Integer keyBis = null;
        Integer valueBis = null;
        try {
            keyBis = (Integer) key;
            valueBis = (Integer) value;
        } catch (Exception e) {
            System.out.println(e);
            return this;
        }

        if (keyBis >= max) {

            System.out.println("Key way too high, are you crazy bro ?");
            return this;

        } else if (keyBis < 0) {

            System.out.println("Key under 0, you have no pressure ?");
            return this;

        } else if (valueBis.equals(creux)) {

            this.remove(keyBis);
            return this;

        }

        return super.put(keyBis, valueBis);

    }

    @Override
    public Object get(Object key) {

        Integer keyBis = null;
        try {
            keyBis = (Integer) key;
        } catch (Exception e) {
            System.out.println(e);
            return this;
        }

        if (keyBis >= max) {

            System.out.println("Key way too high, are you crazy bro ?");
            return this;

        } else if (keyBis < 0) {

            System.out.println("Key under 0, you have no pressure ?");
            return this;

        }

        if (this.containsKey(keyBis)) {
            return super.get(key);
        } else {
            return this.creux;
        }


    }

    public Integer getCreux() {
        return creux;
    }

    public Integer getMax() {
        return max;
    }

    public void addition(VecteurCreux vc) {

        if (this.creux.equals(vc.getCreux()) && this.max.equals(vc.getMax())) {

            Set set = vc.keySet();

            for (Object vcKey : set) {

                if (this.containsKey(vcKey)) {

                    this.put(vcKey, (Integer)(vc.get(vcKey)) + (Integer)(this.get(vcKey)));

                } else {

                    this.put(vcKey, vc.get(vcKey));

                }

            }

        } else {

            System.out.println("We don't have the same 'creux' n.or 'max' this was a stupid idea, but who am I to judge ?");

        }

    }

    public void multiplication(Integer val) {

        Set set = this.keySet();

        for (Object vcKey : set) {

            this.put(vcKey, (Integer)(this.get(vcKey)) * val);

        }

        this.creux = this.creux * val;

    }
/*
    @Override
    public String toString() {

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (Integer i = 0; i < this.max; i++) {

            if (this.containsKey(i)) {

                hm.put(i, (Integer) this.get(i));

            } else {

                hm.put(i, this.creux);

            }

        }

        return hm.toString();
    }
*/
}
