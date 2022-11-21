package dp;

import java.util.*;

public class UniquePaths2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] obstacleGrid = new int[m][n];

        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    static Integer[][] dp;

    public static int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp = new Integer[m][n];

        return solve(grid, m - 1, n - 1);
    }

    private static int solve(int[][] a, int i, int j) {
        int m = a.length;
        int n = a[0].length;

        if (i < 0 || j < 0 || i == m || j == n || a[i][j] == 1) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (i == 0 && j == 0) {
            return 1;
        }

        return dp[i][j] = solve(a, i, j - 1) + solve(a, i - 1, j);
    }
}
