package backtracking;

import java.util.*;

public class Combinations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(combine(n, k));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        solve(1, n, 0, k, new ArrayList<>(), ans);

        return ans;
    }

    private static void solve(int cur, int n, int j, int k, List<Integer> l, List<List<Integer>> ans) {
        if (j == k) {
            ans.add(new ArrayList<>(l));
            return;
        }

        if (cur > n) {
            return;
        }

        l.add(cur);
        solve(cur + 1, n, j + 1, k, l, ans);
        l.remove(l.size() - 1);
        solve(cur + 1, n, j, k, l, ans);
    }
}
