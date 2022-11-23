package dp;

import java.util.*;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(minFallingPathSum(matrix));
    }

    static Integer[][] dp;

    public static int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        dp = new Integer[m][n];

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            min = Math.min(min, solve(matrix, 0, i));
        }

        return min;
    }

    private static int solve(int[][] a, int i, int j) {
        int m = a.length;
        int n = a[0].length;

        if (i == m || j < 0 || j == n) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (i == m - 1) {
            return dp[i][j] = a[i][j];
        }

        int min = Integer.MAX_VALUE;

        min = Math.min(min, solve(a, i + 1, j - 1));

        min = Math.min(min, solve(a, i + 1, j));

        min = Math.min(min, solve(a, i + 1, j + 1));

        return dp[i][j] = min == Integer.MAX_VALUE ? min : a[i][j] + min;
    }
}
