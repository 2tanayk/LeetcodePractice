package heap;

import java.util.*;

public class TotalCostToHireKWorkers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] costs = new int[n];

        for (int i = 0; i < n; i++) {
            costs[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        int candidates = sc.nextInt();

        System.out.println(totalCost(costs, k, candidates));
    }

    public static long totalCost(int[] c, int k, int cand) {
        int n = c.length;
        long tot = 0;

        if (2 * cand >= n) {
            Arrays.sort(c);

            while (k > 0) {
                tot += c[k - 1];
                k--;
            }

            return tot;
        }
        PriorityQueue<Integer> f = new PriorityQueue<>((i1, i2) -> c[i1] == c[i2] ? i1 - i2 : c[i1] - c[i2]);
        PriorityQueue<Integer> b = new PriorityQueue<>((i1, i2) -> c[i1] == c[i2] ? i1 - i2 : c[i1] - c[i2]);

        for (int i = 0; i < cand; i++) {
            f.add(i);
        }

        for (int i = n - 1; i >= n - cand; i--) {
            b.add(i);
        }

        int i = cand - 1, j = n - cand;

        while (k > 0 && j - i > 1) {
            int l = f.peek();
            int r = b.peek();

            if (c[l] <= c[r]) {
                f.poll();
                f.add(++i);
                tot += c[l];
            } else {
                b.poll();
                b.add(--j);
                tot += c[r];
            }

            k--;
        }

        while (k > 0 && !f.isEmpty() && !b.isEmpty()) {
            int l = f.peek();
            int r = b.peek();

            if (c[l] <= c[r]) {
                f.poll();
                tot += c[l];
            } else {
                b.poll();
                tot += c[r];
            }

            k--;
        }

        while (k > 0 && !f.isEmpty()) {
            tot += c[f.poll()];
            k--;
        }

        while (k > 0 && !b.isEmpty()) {
            tot += c[b.poll()];
            k--;
        }

        return tot;
    }
}
