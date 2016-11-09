# Euler
Brain training for software engineer ソフトウエアエンジニアの頭脳トレーニング

Project Euler 問題集のオフィシャルサイトは次です。
https://projecteuler.net/archives


# Problem 3 Largest prime factor

13195の素因数が 5, 7, 13 と 29である。
600851475143の一番大きい素因数が何だ？

・教訓
　　この問題に対して、割算で素数を判断するのが最適です。
 　素数リストを維持して素数を行うのが性能低いの原因です。

　　下記がJavaのベスト実装だと思います。
    private static long getPrimes(long n) {
        while (n % 2 == 0) {
            n = n / 2;
        }

        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n = n / i;
                }
            }
        }
        return n;
    }
