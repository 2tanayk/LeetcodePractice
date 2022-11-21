package graph;

import java.util.*;

public class NearestExitFromEntranceInMaze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        char[][] maze = new char[m][n];
        sc.nextLine();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = sc.nextLine().charAt(0);
            }
        }

        int[] entrance = new int[2];

        for (int i = 0; i < 2; i++) {
            entrance[i] = sc.nextInt();
        }

        System.out.println(nearestExit(maze, entrance));
    }

    public static int nearestExit(char[][] mz, int[] e) {
        int m = mz.length;
        int n = mz[0].length;

        int min = Integer.MAX_VALUE;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];

        vis[e[0]][e[1]] = true;
        q.add(new int[]{e[0], e[1]});

        int[][] ops = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int steps = 0;

        while (!q.isEmpty()) {
            int ct = q.size();

            while (ct > 0) {
                int[] cur = q.poll();

                if (!(cur[0] == e[0] && cur[1] == e[1]) && (cur[0] == 0 || cur[1] == 0 || cur[0] == m - 1 || cur[1] == n - 1)) {
                    return steps;
                }

                for (int i = 0; i < ops.length; i++) {
                    int nr = cur[0] + ops[i][0];
                    int nc = cur[1] + ops[i][1];

                    if (nr < 0 || nc < 0 || nr == m || nc == n || vis[nr][nc] || mz[nr][nc] == '+') {
                        continue;
                    }

                    vis[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }

                ct--;
            }

            steps++;
        }

        return -1;
    }
}
