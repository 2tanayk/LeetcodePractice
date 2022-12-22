package graph;

import java.util.*;

public class SumOfDistancesInTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] edges = new int[n - 1][2];

        for (int i = 0; i < n - 1; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        System.out.println(Arrays.toString(sumOfDistancesInTree(n, edges)));
    }

    static List<List<Integer>> adj;
    static int[] count;
    static int[] res;

    public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        adj = new ArrayList<>(n);
        count = new int[n];
        res = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        dfsRoot(0, -1);
        dfsReRoot(0, -1, n);

        return res;
    }

    private static void dfsRoot(int root, int parent) {
        for (int next : adj.get(root)) {
            if (next == parent) {
                continue;
            }

            dfsRoot(next, root);
            count[root] += count[next];
            res[root] += res[next] + count[next];
        }

        count[root]++;
    }

    private static void dfsReRoot(int root, int parent, int n) {
        for (int next : adj.get(root)) {
            if (next == parent) {
                continue;
            }

            res[next] = res[root] - count[next] + n - count[next];
            dfsReRoot(next, root, n);
        }
    }
}
