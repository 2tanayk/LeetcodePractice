package graph;

import java.util.*;

public class UniquePaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(uniquePaths(m, n));
    }

    static Integer[][] dp;

    public static int uniquePaths(int m, int n) {
        dp = new Integer[m][n];

        return solve(m - 1, n - 1, m, n);
    }

    private static int solve(int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i == m || j == n) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (i == 0 && j == 0) {
            return 1;
        }

        return dp[i][j] = solve(i, j - 1, m, n) + solve(i - 1, j, m, n);
    }
}
