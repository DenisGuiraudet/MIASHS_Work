import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Ensemble {

    public static void main(String[] args) {

        Map<Integer, Integer> hm1 = new HashMap<>();
        Map<Integer, Integer> hm2 = new HashMap<>();

        hm1.put(1,10);
        hm1.put(9,90);
        hm1.put(2,20);

        hm2.put(5,500);
        hm2.put(9,900);

        System.out.println(hm1);
        System.out.println(hm2);

        System.out.println(reunion(hm1, hm2));

        System.out.println(intersection(hm1, hm2));

        System.out.println(difference(hm1, hm2));

        System.out.println(differenceSymetrique(hm1, hm2));

    }

    private static Map<Integer, Integer> reunion(Map<Integer, Integer> hm1, Map<Integer, Integer> hm2) {

        Map<Integer, Integer> hm3 = new HashMap<>();
        hm3.putAll(hm1);

        for (Entry<Integer, Integer> entry : hm2.entrySet()) {

            Integer key = entry.getKey();
            Integer value = entry.getValue();

            hm3.put(key, value);

        }

        return hm3;

    }

    private static Map<Integer, Integer> intersection(Map<Integer, Integer> hm1, Map<Integer, Integer> hm2) {

        Map<Integer, Integer> hm3 = new HashMap<>();

        for (Entry<Integer, Integer> entry : hm2.entrySet()) {

            Integer key = entry.getKey();
            Integer value = entry.getValue();

            if (hm1.containsKey(key)) {
                hm3.put(key, value);
            }

        }

        return hm3;

    }

    private static Map<Integer, Integer> difference(Map<Integer, Integer> hm1, Map<Integer, Integer> hm2) {

        Map<Integer, Integer> hm3 = new HashMap<>();

        for (Entry<Integer, Integer> entry : hm1.entrySet()) {

            Integer key = entry.getKey();
            Integer value = entry.getValue();

            if (!hm2.containsKey(key)) {
                hm3.put(key, value);
            }

        }

        return hm3;

    }

    private static Map<Integer, Integer> differenceSymetrique(Map<Integer, Integer> hm1, Map<Integer, Integer> hm2) {

        Map<Integer, Integer> hm3 = new HashMap<>();

        for (Entry<Integer, Integer> entry1 : hm1.entrySet()) {

            Integer key = entry1.getKey();
            Integer value = entry1.getValue();

            if (!hm2.containsKey(key)) {
                hm3.put(key, value);
            }

        }

        for (Entry<Integer, Integer> entry2 : hm2.entrySet()) {

            Integer key = entry2.getKey();
            Integer value = entry2.getValue();

            if (!hm1.containsKey(key)) {
                hm3.put(key, value);
            }

        }

        return hm3;

    }

}
