package graph;

import java.util.*;

public class SurroundedRegions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        sc.nextLine();

        char[][] board = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextLine().charAt(0);
            }
        }

        solve(board);

        System.out.println(Arrays.deepToString(board));
    }

    public static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < n; i++) {
            if (!vis[0][i]) {
                bdfs(board, 0, i, vis);
            }
        }

        for (int i = 0; i < n; i++) {
            if (!vis[m - 1][i]) {
                bdfs(board, m - 1, i, vis);
            }
        }

        for (int i = 0; i < m; i++) {
            if (!vis[i][0]) {
                bdfs(board, i, 0, vis);
            }
        }

        for (int i = 0; i < m; i++) {
            if (!vis[i][n - 1]) {
                bdfs(board, i, n - 1, vis);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private static void bdfs(char[][] b, int r, int c, boolean[][] vis) {
        int m = b.length;
        int n = b[0].length;

        if (r < 0 || r == m || c < 0 || c == n || b[r][c] == 'X' || vis[r][c]) {
            return;
        }

        vis[r][c] = true;

        bdfs(b, r, c - 1, vis);
        bdfs(b, r, c + 1, vis);
        bdfs(b, r - 1, c, vis);
        bdfs(b, r + 1, c, vis);
    }
}
