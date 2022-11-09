package backtracking;

import java.util.*;

public class CombinationSum2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] candidates = new int[n];

        for (int i = 0; i < n; i++) {
            candidates[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        System.out.println(combinationSum2(candidates, target));
    }

    public static List<List<Integer>> combinationSum2(int[] c, int target) {
        int n = c.length;

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(c);

        solve(c, 0, target, new ArrayList<>(), ans);

        return ans;
    }

    private static void solve(int[] c, int i, int sum, List<Integer> l, List<List<Integer>> ans) {
        int n = c.length;

        if (sum < 0) {
            return;
        }

        if (sum == 0) {
            ans.add(new ArrayList<>(l));
            return;
        }

        for (int j = i; j < n; j++) {
            if (j > i && c[j] == c[j - 1]) {
                continue;
            }

            l.add(c[j]);

            solve(c, j + 1, sum - c[j], l, ans);

            l.remove(l.size() - 1);
        }
    }
}
