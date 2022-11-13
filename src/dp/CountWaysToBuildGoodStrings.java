package dp;

import java.util.*;

public class CountWaysToBuildGoodStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int low = sc.nextInt();
        int high = sc.nextInt();
        int zero = sc.nextInt();
        int one = sc.nextInt();

        System.out.println(countGoodStrings(low, high, zero, one));
    }

    private static final int m = (int) Math.pow(10, 9) + 7;
    static Integer[] memo;

    public static int countGoodStrings(int low, int high, int zero, int one) {
        memo = new Integer[high + 1];

        return solve(zero, one, low, high, 0) % m;
    }

    private static int solve(int zCt, int oCt, int l, int h, int len) {
        if (len > h) {
            return 0;
        }

        if (memo[len] != null) {
            return memo[len];
        }

        int ct = 0;

        if (len >= l && len <= h) {
            ct++;
        }

        return memo[len] = ct + solve(zCt, oCt, l, h, len + zCt) % m + solve(zCt, oCt, l, h, len + oCt) % m;
    }
}
