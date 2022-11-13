package searchandsort;

import java.util.*;

public class NumberOfDistinctAverages {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(distinctAverages(nums));
    }

    public static int distinctAverages(int[] arr) {
        int n = arr.length;

        Arrays.sort(arr);

        int i = 0, j = n - 1;

        HashSet<Double> hs = new HashSet<>();

        while (i < j) {
            hs.add((arr[i++] + arr[j--]) / 2.0);
        }

        return hs.size();
    }
}
