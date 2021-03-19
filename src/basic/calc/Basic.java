package basic.calc;

import util.ListNode;
import util.MyPrint;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 基础题
 * <p>
 */
public class Basic {
    private static int base = 1337;

    // a ^ k
    public static int mypow(int a, int k) {
        int res = 1;
        a %= base;

        for (int i = 0; i < k; ++i) {
            res *= a;
            res %= base;    // 防止溢出
        }

        return res;
    }

    /**
     * 超级次方
     * 1. 递归思想 + mod运算 = (a%k) * (b%k) % k = bd % k
     *
     * @param b 指数数组
     */
    public static int superPow(int a, LinkedList<Integer> b) {
        if (b.isEmpty()) return 1;

        // 取出最后一个数
        int last = b.removeLast();

        // a^1234 = a4 * (a^123)^10
        int part1 = mypow(a, last);
        int part2 = mypow(superPow(a, b), 10);
        return (part1 * part2) % base;
    }

    /**
     * 素数筛算法：sieve of eratosthenes
     * 优化：
     * 1. i*i + i，1即不是素数也不是合数
     */
    public static int countPrime(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        // i=2 i*i
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // i*i j+=i
                for (int j = i * i; j < n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;

        // count
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        var list = new LinkedList<Integer>(Arrays.asList(1, 5, 6, 4));
        int val = superPow(18, list);
        System.out.println("pow: " + val);

        int count = countPrime(100);
        System.out.println("prime: " + count);
    }
}
