package group1;

import common.Time;

public class Problem4 {

    private abstract static class GetPalindrome {

        protected abstract boolean isPalindrome(long num);

        public void printPalindrome(int digitSize) {
            long max = (long) (Math.pow(10, digitSize) - 1);
            long min = (long) Math.pow(10, digitSize - 1);

            System.out.print(this.getClass().getSimpleName() + "    ");
            System.out.print(min + " ~ " + max + "    ");

            Time t = Time.newInstance();
            t.start();

            long loopCnt = 0;
            long x = 0;
            long y = 0;
            long n = 0;
            long tmp = 0;

            for (long i = max; i >= min; i--) {
                for (long j = max; j >= min; j--) {
                    loopCnt++;
                    tmp = i * j;
                    if (isPalindrome(tmp)) {
                        // 余計な計算を避ける
                        max = i - 1;
                        min = j + 1;

                        if (tmp > n) {
                            n = tmp;
                            x = i;
                            y = j;
                        }
                        break;
                    }
                }
            }

            System.out.println(n + " = " + x + " * " + y + "    " + t.end2() + " Millis    " + loopCnt);
        }
    }

    private static class GetPalindromeByStringCompare extends GetPalindrome {

        protected boolean isPalindrome(long num) {
            StringBuilder sb = new StringBuilder().append(num);
            return sb.toString().equals(sb.reverse().toString());
        }
    }

    private static class GetPalindromeByCharCompare extends GetPalindrome {

        protected boolean isPalindrome(long num) {
            char[] arr = String.valueOf(num).toCharArray();
            int len = arr.length;
            int mid = len / 2;
            for (int i = 0; i < mid; i++) {
                if (arr[i] != arr[len - 1 - i]) {
                    return false;
                }
            }
            return true;
        }
    }

    private static class GetPalindromeByNumberCompare extends GetPalindrome {

        protected boolean isPalindrome(long num) {
            long n = num;
            long r = 0;

            while (n != 0) {
                r = 10 * r + (n % 10);
                n /= 10;
            }

            return r == num;
        }
    }

    private static class GetPalindromeByDigitCompare extends GetPalindrome {

        protected boolean isPalindrome(long num) {
            long n = num;
            long len = (long) (Math.log10(n) + 1);
            long mid = len / 2;
            long tmpLen;

            long p10;
            long start;
            long end;

            while (mid > 0) {
                p10 = (long) Math.pow(10, len - 1);
                start = n / p10;
                end = n % 10;

                if (start != end) {
                    return false;
                } else if (mid == 1) {
                    return true;
                } else {
                    // 最上位と最下位を除く
                    n = (n % p10) / 10;

                    if (n == 0) {
                        return true;
                    }

                    // 上位が0の場合、下位が0であるかをチェックし、桁数を補正する
                    // 例：906609→ 660→ 66
                    do {
                        len -= 2;
                        tmpLen = (long) (Math.log10(n) + 1);
                        while (len > tmpLen) {
                            if (n % 10 != 0) {
                                return false;
                            } else {
                                n /= 10;
                                tmpLen--;
                                len -= 2;
                            }
                        }
                    } while (tmpLen != len);

                    mid = len / 2;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        for (int i = 2; i <= 8; i++) {
            System.out.println();
            System.out.println("# digitSize: " + i);
            new GetPalindromeByStringCompare().printPalindrome(i);
            new GetPalindromeByCharCompare().printPalindrome(i);
            new GetPalindromeByNumberCompare().printPalindrome(i);
            new GetPalindromeByDigitCompare().printPalindrome(i);
        }
    }

}