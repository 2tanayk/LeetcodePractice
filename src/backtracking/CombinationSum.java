package backtracking;

import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] candidates = new int[n];

        for (int i = 0; i < n; i++) {
            candidates[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] c, int target) {
        int n = c.length;

        List<List<Integer>> ans = new ArrayList<>();

        solve(c, 0, target, new ArrayList<>(), ans);

        return ans;
    }

    private static void solve(int[] a, int i, int sum, List<Integer> l, List<List<Integer>> ans) {
        int n = a.length;

        if (sum < 0) {
            return;
        }

        if (sum == 0) {
            ans.add(new ArrayList<>(l));
            return;
        }

        for (int j = i; j < n; j++) {
            l.add(a[j]);
            solve(a, j, sum - a[j], l, ans);
            l.remove(l.size() - 1);
        }
    }
}
