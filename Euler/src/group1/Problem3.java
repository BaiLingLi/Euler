package group1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem3 {

    private static final List<Long> primeList = new ArrayList<Long>(Arrays.asList(2L, 3L));

    public static void main(String[] args) {
        extractMaxPrimeFactor(600851475143L);
        getPrimes(600851475143L);
    }

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

    private static void extractMaxPrimeFactor(long num) {
        System.out.println(num);
        long start = System.nanoTime();

        Map<Long, Long> factorMap = new HashMap<>();

        doPrimeFactorization(num, factorMap);

        printResult(num, factorMap);

        System.out.println("処理時間: " + ((double) (System.nanoTime() - start) / 1000000) + "ミリ秒");

    }

    private static void doPrimeFactorization(long num, Map<Long, Long> factorMap) {
        long value = num;

        int len = primeList.size();
        long prime = primeList.get(0);
        int i = 0;

        while (value > 1 && i < len) {
            if (value % prime == 0) {
                if (factorMap.containsKey(prime)) {
                    factorMap.put(prime, factorMap.get(prime) + 1);
                } else {
                    factorMap.put(prime, 1L);
                }

                value /= prime;
            } else if (value > 1) {
                i += 1;
                if (i >= len) {
                    addPrimeToList();
                    len = primeList.size();
                }

                prime = primeList.get(i);
            }
        }
    }

    private static void addPrimeToList() {
        long maxPrime = primeList.get(primeList.size() - 1);

        do {
            maxPrime += 2;
        } while (!isPrime(maxPrime));

        primeList.add(maxPrime);
    }

    private static boolean isPrime(long value) {
        if (value > 3) {
            long sqrt = (long) Math.sqrt(value);

            for (long prime : primeList) {
                if (prime > sqrt) {
                    return true;
                } else if (value % prime == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void printResult(long num, Map<Long, Long> factorMap) {
        System.out.println("Prime list size: " + primeList.size());

        List<Long> primes = new ArrayList<>(factorMap.keySet());
        Collections.sort(primes);

        StringBuilder sb = new StringBuilder();
        for (long prime : primes) {
            sb.append(" * (").append(prime).append("^").append(factorMap.get(prime)).append(")");
        }

        System.out.println(num + " = " + sb.substring(3));

        System.out.println("Max prime factor: " + primes.get(primes.size() - 1));
    }
}