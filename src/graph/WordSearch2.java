package graph;

import java.util.*;

public class WordSearch2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        char[][] board = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }

        int len = sc.nextInt();

        String[] words = new String[len];

        sc.nextLine();

        for (int i = 0; i < len; i++) {
            words[i] = sc.nextLine();
        }

        System.out.println(findWords(board, words));
    }

    public static List<String> findWords(char[][] b, String[] words) {
        int m = b.length;
        int n = b[0].length;

        HashSet<String> w = new HashSet<>();
        HashSet<String> ans = new HashSet<>();

        int max = 0;

        for (String word : words) {
            w.add(word);
            max = Math.max(max, word.length());
        }

        outer:
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] vis = new boolean[m][n];
                solve(b, i, j, new StringBuilder(), w, ans, max, vis);

                if (ans.size() == w.size()) {
                    break outer;
                }
            }
        }

        return new ArrayList<>(ans);
    }

    private static void solve(char[][] c, int i, int j, StringBuilder s, HashSet<String> w, HashSet<String> ans, int max, boolean[][] vis) {
        int m = c.length;
        int n = c[0].length;

        if (i < 0 || j < 0 || i == m || j == n || vis[i][j] || s.length() > max) {
            return;
        }

        s.append(c[i][j]);

        String tmp = s.toString();
        if (w.contains(tmp)) {
            ans.add(tmp);
        }

        vis[i][j] = true;

        solve(c, i, j - 1, s, w, ans, max, vis);
        solve(c, i, j + 1, s, w, ans, max, vis);
        solve(c, i - 1, j, s, w, ans, max, vis);
        solve(c, i + 1, j, s, w, ans, max, vis);

        vis[i][j] = false;
        s.deleteCharAt(s.length() - 1);
    }
}
