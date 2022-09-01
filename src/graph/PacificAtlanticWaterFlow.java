package graph;

import java.util.*;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] heights = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[i][j] = sc.nextInt();
            }
        }

        System.out.println(pacificAtlantic(heights));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        List<List<Integer>> ans = new ArrayList<>();

        int[][] flow = new int[m][n];

        boolean[][] pVis = new boolean[m][n];
        boolean[][] aVis = new boolean[m][n];


        for (int i = 0; i < n; i++) {
            dfs(heights, 0, i, heights[0][i], pVis, flow);
            dfs(heights, m - 1, i, heights[m - 1][i], aVis, flow);
        }

        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, heights[i][0], pVis, flow);
            dfs(heights, i, n - 1, heights[i][n - 1], aVis, flow);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (flow[i][j] == 2) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);

                    ans.add(temp);
                }
            }
        }

        return ans;
    }

    private static void dfs(int[][] arr, int r, int c, int prev, boolean[][] vis, int[][] flow) {
        int m = arr.length;
        int n = arr[0].length;

        if (r < 0 || r >= m || c < 0 || c >= n || vis[r][c] || arr[r][c] < prev) {
            return;
        }

        vis[r][c] = true;
        flow[r][c]++;

        dfs(arr, r, c - 1, arr[r][c], vis, flow);
        dfs(arr, r, c + 1, arr[r][c], vis, flow);
        dfs(arr, r - 1, c, arr[r][c], vis, flow);
        dfs(arr, r + 1, c, arr[r][c], vis, flow);
    }
}
