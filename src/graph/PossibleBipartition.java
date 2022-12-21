package graph;

import java.util.*;

public class PossibleBipartition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] dislikes = new int[n][2];

        for (int i = 0; i < n; i++) {
            dislikes[i][0] = sc.nextInt();
            dislikes[i][1] = sc.nextInt();
        }

        System.out.println(possibleBipartition(n, dislikes));
    }

    public static boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>(n + 1);

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] d : dislikes) {
            adj.get(d[0]).add(d[1]);
            adj.get(d[1]).add(d[0]);
        }


        int[] vis = new int[n + 1];

        Arrays.fill(vis, -1);

        for (int i = 1; i <= n; i++) {
            if (vis[i] == -1) {
                if (!isBipartite(adj, vis, i, 0)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isBipartite(List<List<Integer>> adj, int[] vis, int cur, int col) {
        vis[cur] = col;

        for (Integer e : adj.get(cur)) {
            if (vis[e] == -1) {
                if (!isBipartite(adj, vis, e, 1 - col)) {
                    return false;
                }
            } else if (vis[e] == vis[cur]) {
                return false;
            }
        }

        return true;
    }
}
