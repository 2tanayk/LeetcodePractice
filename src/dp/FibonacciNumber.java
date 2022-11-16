package dp;

import java.util.*;

public class FibonacciNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(fib(n));
    }

    private static int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int prev1 = 1, prev2 = 0;

        for (int i = 2; i <= n; i++) {
            int cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }

        return prev1;
    }
}
