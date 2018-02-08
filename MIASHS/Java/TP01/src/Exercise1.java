
public class Exercise1 {

    public static void main(String[] args) {

        System.out.println(isPerfect(1));
        System.out.println(isPerfect(6));
        System.out.println(isPerfect(12));
        System.out.println(isPerfect(15));
        System.out.println(isPerfect(28));

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
