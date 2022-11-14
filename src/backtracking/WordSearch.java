package backtracking;

import java.util.*;

public class WordSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        char[][] board = new char[m][n];
        sc.nextLine();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextLine().charAt(0);
            }
        }

        String word = sc.nextLine();

        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] b, String w) {
        int m = b.length;
        int n = b[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (solve(b, i, j, 0, w)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean solve(char[][] b, int i, int j, int k, String w) {
        int m = b.length;
        int n = b[0].length;
        int len = w.length();

        if (k == len) {
            return true;
        }

        if (i < 0 || j < 0 || i == m || j == n || b[i][j] != w.charAt(k)) {
            return false;
        }

        b[i][j] ^= 256;


        boolean l = solve(b, i, j - 1, k + 1, w);
        if (l) {
            return true;
        }
        boolean r = solve(b, i, j + 1, k + 1, w);
        if (r) {
            return true;
        }
        boolean u = solve(b, i - 1, j, k + 1, w);
        if (u) {
            return true;
        }
        boolean d = solve(b, i + 1, j, k + 1, w);
        if (d) {
            return true;
        }

        b[i][j] ^= 256;

        return false;
    }
}
