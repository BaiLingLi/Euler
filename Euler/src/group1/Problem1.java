package group1;

/**
 * Problem 1
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6 and 9. The sum of these multiples is 23. Find the sum of all the
 * multiples of 3 or 5 below 1000.
 *
 * @author BaiLingLi
 */
public class Problem1 {

    private static final long MAX = 1000;
    // private static final long MAX = 1000*1000*1000;

    public static void main(String[] args) {
        long start = System.nanoTime();

        long n3 = 0;
        long n5 = 0;
        long sum = 0;

        while (n3 < MAX || n5 < MAX) {
            while (n3 <= n5) {
                n3 += 3;
                if (n3 < MAX && n3 != n5) {
                    sum += n3;
                }
            }

            while (n5 <= n3) {
                n5 += 5;
                if (n5 < MAX && n5 != n3) {
                    sum += n5;
                }
            }
        }

        System.out.println("Result:" + sum);
        double elapsedTime = (double) (System.nanoTime() - start) / 1000000;
        System.out.println("Process Time:" + elapsedTime + "ミリ秒");
    }
}
