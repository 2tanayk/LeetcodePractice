package backtracking;

import java.util.*;

public class Subsets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        solve(nums, 0, new ArrayList<>(), ans);

        return ans;
    }

    private static void solve(int[] a, int i, List<Integer> l, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(l));

        for (int j = i; j < a.length; j++) {
            l.add(a[j]);
            solve(a, j + 1, l, ans);
            l.remove(l.size() - 1);
        }
    }
}
