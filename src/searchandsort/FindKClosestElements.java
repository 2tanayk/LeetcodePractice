package searchandsort;

import java.util.*;

public class FindKClosestElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        int x = sc.nextInt();

        System.out.println(findClosestElements(arr, k, x));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();

        int l = 0, r = n - k;

        while (l < r) {
            int mid = (l + r) / 2;

            if (x - arr[mid] > arr[mid + k] - x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        for (int i = l; i < l + k; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }
}
