package group1;

/**
 * Problem 2
 *
 * Each new term in the Fibonacci sequence is generated by adding the previous
 * two terms. By starting with 1 and 2, the first 10 terms will be:
 *
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 *
 * By considering the terms in the Fibonacci sequence whose values do not exceed
 * four million, find the sum of the even-valued terms.
 *
 *
 * @author BaiLingLi
 */
public class Problem2 {

    private static final long MAX = 4 * 1000 * 1000;

    public static void main(String[] args) {
        long start = System.nanoTime();

        long t = 0;
        long n1 = 1;
        long n2 = 2;
        long sum = 0;

        while (n2 < MAX) {
            if (n2 % 2 == 0) {
                sum += n2;
            }

            t = n1;
            n1 = n2;
            n2 += t;
        }

        System.out.println("Result:" + sum);
        double elapsedTime = (double) (System.nanoTime() - start) / 1000000;
        System.out.println("Process Time:" + elapsedTime + "ミリ秒");
    }
}
