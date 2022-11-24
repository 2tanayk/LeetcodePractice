package dp;

import java.util.*;

public class CherryPickup {
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

    static Integer[][][][] dp;

    public static int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (m == 1 && n == 1) {
            return Math.max(0, grid[0][0]);
        }

        dp = new Integer[m][n][m][n];

        return Math.max(0, solve(grid, 0, 0, 0, 0));
    }

    private static int solve(int[][] a, int i1, int j1, int i2, int j2) {
        int m = a.length;
        int n = a[0].length;

        if (i1 == m || i2 == m || j1 == n || j2 == n || a[i1][j1] == -1 || a[i2][j2] == -1) {
            return Integer.MIN_VALUE;
        }

        if (dp[i1][j1][i2][j2] != null) {
            return dp[i1][j1][i2][j2];
        }

        if ((i1 == m - 1 && j1 == n - 1) || (i2 == m - 1 && j2 == n - 1)) {
            return dp[i1][j1][i2][j2] = a[m - 1][n - 1];
        }

        int cur = 0;

        if (i1 == i2 && j1 == j2) {
            cur += a[i1][j1];
        } else {
            cur += a[i1][j1] + a[i2][j2];
        }

        int max = Integer.MIN_VALUE;

        max = Math.max(max, solve(a, i1, j1 + 1, i2, j2 + 1));
        max = Math.max(max, solve(a, i1, j1 + 1, i2 + 1, j2));
        max = Math.max(max, solve(a, i1 + 1, j1, i2, j2 + 1));
        max = Math.max(max, solve(a, i1 + 1, j1, i2 + 1, j2));

        if (max == Integer.MIN_VALUE) {
            return dp[i1][j1][i2][j2] = max;
        }

        return dp[i1][j1][i2][j2] = cur + max;
    }
}
