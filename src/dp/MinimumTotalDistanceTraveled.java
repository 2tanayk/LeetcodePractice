package dp;

import java.util.*;

public class MinimumTotalDistanceTraveled {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();

        List<Integer> robot = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            robot.add(sc.nextInt());
        }

        int n2 = sc.nextInt();

        int[][] factory = new int[n2][2];

        for (int i = 0; i < n2; i++) {
            factory[i][0] = sc.nextInt();
            factory[i][1] = sc.nextInt();
        }

        System.out.println(minimumTotalDistance(robot, factory));
    }

    static Long[][][] memo;

    public static long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int n1 = robot.size();
        int n2 = factory.length;

        Collections.sort(robot);
        Arrays.sort(factory, (f1, f2) -> f1[0] - f2[0]);

        int k = 0;
        for (int[] fac : factory) {
            k = Math.max(k, fac[1]);
        }

        memo = new Long[n1][n2][k + 1];

        return solve(robot, 0, factory, 0, 0);
    }

    private static long solve(List<Integer> r, int i, int[][] f, int j, int k) {
        int n1 = r.size();
        int n2 = f.length;

        if (i == n1) {
            return 0;
        }

        if (j == n2) {
            return Long.MAX_VALUE;
        }

        if (memo[i][j][k] != null) {
            return memo[i][j][k];
        }

        long dontTake = solve(r, i, f, j + 1, 0);

        if (k + 1 > f[j][1]) {
            return memo[i][j][k] = dontTake;
        }

        long cost = Math.abs(r.get(i) - f[j][0]);

        long take = solve(r, i + 1, f, j, k + 1);

        if (take == Long.MAX_VALUE) {
            return memo[i][j][k] = dontTake;
        }

        return memo[i][j][k] = Math.min(dontTake, cost + take);
    }
}
