package graph;

import java.util.*;

public class FrogPositionAfterTSeconds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] edges = new int[n][2];

        for (int i = 0; i < n; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        int t = sc.nextInt();

        int target = sc.nextInt();

        System.out.println(frogPosition(n, edges, t, target));
    }

    public static double frogPosition(int n, int[][] edges, int t, int target) {
        if (n == 1) {
            return 1.0;
        }

        List<List<Integer>> adj = new ArrayList<>();

        adj.add(null);

        for (int i = 1; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        double p = 0;
        boolean[] vis = new boolean[n + 1];
        vis[1] = true;

        for (Integer a : adj.get(1)) {
            double s = adj.get(1).size();

            p = solve(adj, a, 1 / s, t - 1, target, vis);

            if (p != 0) {
                break;
            }
        }

        return p;
    }

    private static double solve(List<List<Integer>> adj, int cur, double p, int t, int tg, boolean[] vis) {
        if (t == 0) {
            return cur == tg ? p : 0;
        }

        if (cur == tg && adj.get(cur).size() - 1 == 0) {
            return p;
        }

        vis[cur] = true;
        boolean flag = false;
        double nxt = 0;

        for (Integer a : adj.get(cur)) {
            if (vis[a]) {
                continue;
            }

            double s = adj.get(cur).size() - 1;

            nxt = solve(adj, a, 1 / s, t - 1, tg, vis);

            if (nxt != 0) {
                flag = true;
                break;
            }
        }

        vis[cur] = false;

        return flag ? p * nxt : 0;
    }
}
