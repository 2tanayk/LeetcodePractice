package searchandsort;

import java.util.*;

public class KokoEatingBananas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] piles = new int[n];

        for (int i = 0; i < n; i++) {
            piles[i] = sc.nextInt();
        }

        int h = sc.nextInt();

        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] p, int h) {
        int n = p.length;

        if (n == 1) {
            return (int) Math.ceil((p[0] * 1.0) / h);
        }

        int l = 0;
        int r = p[0];

        for (int i = 1; i < n; i++) {
            r = Math.max(r, p[i]);
        }

        int min = Integer.MAX_VALUE;

        while (l <= r) {
            int mid = (l + r) / 2;

            int tt = timeTaken(p, mid);

            if (tt <= h) {
                min = Math.min(min, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return min;
    }

    private static int timeTaken(int[] p, int h) {
        int t = 0;

        for (int i = p.length - 1; i >= 0; i--) {
            t += Math.ceil(p[i] / (h * 1.0));
        }

        return t;
    }
}
