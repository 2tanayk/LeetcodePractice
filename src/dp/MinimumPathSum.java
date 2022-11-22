package dp;

import java.util.*;

public class MinimumPathSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(minPathSum(grid));
    }

    static Integer[][] dp;

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp = new Integer[m][n];

        return solve(grid, m - 1, n - 1);
    }

    private static int solve(int[][] a, int i, int j) {
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (i == 0 && j == 0) {
            return a[i][j];
        }

        int l = solve(a, i, j - 1);

        int u = solve(a, i - 1, j);

        if (l == Integer.MAX_VALUE && u == Integer.MAX_VALUE) {
            return dp[i][j] = l;
        }

        return dp[i][j] = a[i][j] + Math.min(l, u);
    }
}
