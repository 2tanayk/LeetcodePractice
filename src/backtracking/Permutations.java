package backtracking;

import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        int n = nums.length;

        List<List<Integer>> ans = new ArrayList<>();

        solve(nums, 0, new ArrayList<>(), ans);

        return ans;
    }

    private static void solve(int[] a, int i, List<Integer> l, List<List<Integer>> ans) {
        int n = a.length;

        if (i == n) {
            ans.add(new ArrayList<>(l));
            return;
        }

        for (int j = i; j < n; j++) {
            swap(a, i, j);

            l.add(a[i]);
            solve(a, i + 1, l, ans);
            l.remove(l.size() - 1);

            swap(a, i, j);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
