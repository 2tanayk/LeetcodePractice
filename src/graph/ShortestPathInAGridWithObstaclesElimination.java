package graph;

import java.util.*;

public class ShortestPathInAGridWithObstaclesElimination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int k = sc.nextInt();

        System.out.println(shortestPath(arr, k));
    }

    public static int shortestPath(int[][] arr, int k) {
        int m = arr.length;
        int n = arr[0].length;

        Integer[][] vis = new Integer[m][n];

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0, 0, k});
        vis[0][0] = k;

        int[][] ops = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        while (!q.isEmpty()) {
            int ct = q.size();
            while (ct > 0) {
                int[] cur = q.poll();

                int x = cur[0];
                int y = cur[1];
                int steps = cur[2];
                int p = cur[3];

                if (x == m - 1 && y == n - 1) {
                    return steps;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = x + ops[i][0];
                    int ny = y + ops[i][1];

                    if (nx < 0 || nx == m || ny < 0 || ny == n || (arr[nx][ny] == 1 && p == 0) || (vis[nx][ny] != null && vis[nx][ny] >= p)) {
                        continue;
                    }

                    int tmp = p;
                    if (arr[nx][ny] == 1) {
                        tmp--;
                    }

                    vis[nx][ny] = tmp;

                    q.add(new int[]{nx, ny, steps + 1, tmp});
                }
                ct--;
            }
        }

        return -1;
    }

}
