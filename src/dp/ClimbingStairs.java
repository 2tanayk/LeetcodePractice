package dp;

import java.util.*;

public class ClimbingStairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(climbStairs(n));
    }

    static Integer[] memo;

    public static int climbStairs(int n) {
        memo = new Integer[n];

        return solve(0, n);
    }

    private static int solve(int i, int n) {
        if (i == n) {
            return 1;
        }

        if (memo[i] != null) {
            return memo[i];
        }

        if (i == n - 1) {
            return memo[i] = solve(i + 1, n);
        }

        return memo[i] = solve(i + 1, n) + solve(i + 2, n);
    }
}
