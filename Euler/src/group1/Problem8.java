package group1;

import common.Time;

public class Problem8 {

    private static final String DIGITS_1000 = ""
            + "73167176531330624919225119674426574742355349194934"
            + "96983520312774506326239578318016984801869478851843"
            + "85861560789112949495459501737958331952853208805511"
            + "12540698747158523863050715693290963295227443043557"
            + "66896648950445244523161731856403098711121722383113"
            + "62229893423380308135336276614282806444486645238749"
            + "30358907296290491560440772390713810515859307960866"
            + "70172427121883998797908792274921901699720888093776"
            + "65727333001053367881220235421809751254540594752243"
            + "52584907711670556013604839586446706324415722155397"
            + "53697817977846174064955149290862569321978468622482"
            + "83972241375657056057490261407972968652414535100474"
            + "82166370484403199890008895243450658541227588666881"
            + "16427171479924442928230863465674813919123162824586"
            + "17866458359124566529476545682848912883142607690042"
            + "24219022671055626321111109370544217506941658960408"
            + "07198403850962455444362981230987879927244284909188"
            + "84580156166097919133875499200524063689912560717606"
            + "05886116467109405077541002256983155200055935729725"
            + "71636269561882670428252483600823257530420752963450";

    public static void main(String[] args) {
        Time t = Time.newInstance();
        t.start();

        int len = DIGITS_1000.length();
        char[] chs = DIGITS_1000.toCharArray();
        int[] digits = new int[len];
        for (int i = 0; i < len; i++) {
            digits[i] = chs[i] - 48;
        }

        int size = 13;
        long max = mulitple(digits, 0, size);
        long tmpMax = max;
        int pos = 0;
        int previous;
        int last;

        for (int i = 1, end = len - size + 1; i < end; i++) {
            previous = digits[i - 1];
            last = digits[i + size - 1];

            if ((previous < last) && (previous == 0 || tmpMax != 0)) {
                tmpMax = mulitple(digits, i, i + size);
                if (tmpMax > max) {
                    max = tmpMax;
                    pos = i;
                }
            }
        }

        t.end();
        System.out.println("max:" + max);
        System.out.println("substring:" + DIGITS_1000.substring(pos, pos + size));
    }

    private static long mulitple(int[] digits, int start, int end) {
        long num = 1;
        if (end > digits.length) {
            end = digits.length;
        }
        for (int i = start; i < end; i++) {
            num *= digits[i];
        }
        return num;
    }
}