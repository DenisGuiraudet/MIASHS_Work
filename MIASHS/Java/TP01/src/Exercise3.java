import java.util.ArrayList;
import java.util.Timer;

public class Exercise3 {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        showAmicableNumbers(10000);

        long endTime = System.currentTimeMillis();

        System.out.println("That took " + (endTime - startTime) + " milliseconds");

    }

    private static void showAmicableNumbers(int max) {

        if (max <= 2) return;

        for (int i = 2; i < max; i++) {

            int val1 = getOwnDivider(i);

            if (val1 > i && getOwnDivider(val1) == i) {

                System.out.println(i + "_" + val1);

            }

        }

    }

    private static int getOwnDivider(int val) {

        int sum = 1;
        for (int i = 2; i <= val / 2; i++) {
            if((double)(val / i) == (double)val / i) {
                sum += i;
            }
        }
        return sum;

    }

}
