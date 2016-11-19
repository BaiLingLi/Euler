package group1;

import common.Time;

public class Problem6 {

    public static void main(String[] args) {
        Time t = Time.newInstance();
        t.start();

        long n = 100;

        long sumOfSquares = n * (n+1) * (2*n + 1) / 6;
        long squareOfSum = (long)Math.pow(n * (n + 1) / 2, 2);
        System.out.println(squareOfSum - sumOfSquares);

        t.end();
    }
}