# Euler
Brain training for software engineer ソフトウエアエンジニアの頭脳トレーニング

Project Euler 問題集のオフィシャルサイトは次です。
https://projecteuler.net/archives


# Problem 3 Largest prime factor

13195の素因数が 5, 7, 13 と 29である。
600851475143の一番大きい素因数が何だ？

## 教訓
　　自分で考えた解決方法extractMaxPrimeFactorですが、他の技術者の案と比べると、素数の判断は割算で行うことが最適です。extractMaxPrimeFactorで素数リストを維持して素数を判断するのが性能低いの原因です。下記方法でもっと良いパフォーマンスを出せます。
  ```
    private static long getPrimes(long n) {
        long start = System.nanoTime();

        if (n % 2 == 0) {
            while (n % 2 == 0) {
                n = n / 2;
            }
            if (n == 1) {
                n = 2;
            }
        }

        long sqrt = (long) Math.sqrt(n);

        for (long i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n = n / i;
                }

                if (n == 1) {
                    n = i;
                    break;
                } else {
                    sqrt = (long) Math.sqrt(n);
                }
            }
        }
        System.out.println(n);
        System.out.println("処理時間: " + ((double) (System.nanoTime() - start) / 1000000) + "ミリ秒");
        return n;
    }
```
