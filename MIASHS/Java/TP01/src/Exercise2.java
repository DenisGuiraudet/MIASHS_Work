
public class Exercise2 {

    public static void main(String[] args) {

        showPerfectList(10000);

    }

    private static void showPerfectList(int max) {

        if (max <= 2) return;

        for (int i = 1; i <= max; i++) {
            if (isPerfect(i)) {

                System.out.println(i);

            }
        }

    }

    private static boolean isPerfect(int val) {

        int sum = 1;

        for (int i = 2; i <= val / 2; i++) {
            if((double)(val / i) == (double)val / i) {

                sum += i;

            }
        }

        return (sum == val);

    }

}
