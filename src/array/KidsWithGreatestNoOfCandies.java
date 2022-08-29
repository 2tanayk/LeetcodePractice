package array;

import java.util.*;

public class KidsWithGreatestNoOfCandies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(kidsWithCandies(arr, k));
    }

    public static List<Boolean> kidsWithCandies(int[] arr, int k) {
        int n = arr.length;

        List<Boolean> ans = new ArrayList<Boolean>();

        int max = arr[0];

        for (int i = 1; i < n; i++) {
            max = Math.max(max, arr[i]);
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] + k >= max) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }

        return ans;
    }
}
