package dp;

import java.util.*;

public class Triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();

        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int n = sc.nextInt();
            List<Integer> tmp = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                tmp.add(sc.nextInt());
            }
            triangle.add(tmp);
        }

        System.out.println(minimumTotal(triangle));
    }

    static Integer[][] dp;

    public static int minimumTotal(List<List<Integer>> t) {
        int m = t.size();
        int n = t.get(m - 1).size();

        dp = new Integer[m][n];

        return solve(t, 0, 0);
    }

    private static int solve(List<List<Integer>> t, int i, int j) {
        int m = t.size();
        int n = t.get(i).size();

        if (i == m || j == n) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (i == m - 1) {
            return dp[i][j] = t.get(i).get(j);
        }

        int d = solve(t, i + 1, j);
        int dnxt = solve(t, i + 1, j + 1);

        if (d == Integer.MAX_VALUE && dnxt == Integer.MAX_VALUE) {
            return dp[i][j] = d;
        }

        return dp[i][j] = t.get(i).get(j) + Math.min(d, dnxt);
    }
}
