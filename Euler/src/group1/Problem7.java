package group1;

import common.Time;

public class Problem7 {

    public static void main(String[] args) {
        Time t = Time.newInstance();
        t.start();

        int max = 10001;
        int len = (int) (max * Math.log(max) / Math.log(2) * 1.2);

        // エラトステネスの篩
        boolean[] np = new boolean[len + 1];
        for (int i = 4; i <= len; i += 2) {
            np[i] = true;
        }

        int sqrt = (int) Math.sqrt(len);
        for (int i = 3; i <= sqrt; i += 2) {
            if (!np[i]) {
                for (int j = i * i; j <= len; j += 2 * i) {
                    np[j] = true;
                }
            }
        }

        int no = 0;
        for (int i = 2; i <= len; i++) {
            if (!np[i]) {
                no += 1;
                // System.out.println(i);
                if (no == 10001) {
                    System.out.println(i);
                    break;
                }
            }
        }

        t.end();
    }
}