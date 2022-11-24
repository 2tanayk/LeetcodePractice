package dp;

import java.util.*;

public class CherryPickup2 {
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

        System.out.println(cherryPickup(grid));
    }

    static Integer[][][] dp;

    public static int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp = new Integer[m][n][n];

        return solve(grid, 0, 0, n - 1);
    }

    private static int solve(int[][] a, int i, int j1, int j2) {
        int m = a.length;
        int n = a[0].length;

        if (j1 < 0 || j1 == n || j2 < 0 || j2 == n) {
            return Integer.MIN_VALUE;
        }

        if (dp[i][j1][j2] != null) {
            return dp[i][j1][j2];
        }

        int cur = 0;

        if (j1 == j2) {
            cur = a[i][j1];
        } else {
            cur = a[i][j1] + a[i][j2];
        }

        if (i == m - 1) {
            return dp[i][j1][j2] = cur;
        }

        int[] ops = {-1, 0, 1};

        int max = Integer.MIN_VALUE;

        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                max = Math.max(max, solve(a, i + 1, j1 + ops[j], j2 + ops[k]));
            }
        }

        if (max == Integer.MIN_VALUE) {
            return dp[i][j1][j2] = max;
        }

        return dp[i][j1][j2] = cur + max;
    }
}
