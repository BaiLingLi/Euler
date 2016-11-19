package group1;

import common.Time;

public class Problem5 {

    public static void main(String[] args) {
        Time t = Time.newInstance();
        t.start();

        long lcm = 1;
        for (long i = 1; i <= 20; i++) {
            lcm = getLeastCommonMultiple(lcm, i);
        }
        System.out.println(lcm);

        t.end();
    }

    public static long getLeastCommonMultiple(long a, long b) {
        return a * b / getGreatestCommonFactor(a, b);
    }

    public static long getGreatestCommonFactor(long a, long b) {
        if (b == 0) {
            return a;
        }

        return a % b == 0 ? b : getGreatestCommonFactor(b, a % b);
    }
}