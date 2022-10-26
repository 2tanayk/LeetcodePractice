package searchandsort;

import java.util.*;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(findMin(arr));
    }

    public static int findMin(int[] arr) {
        int n = arr.length;

        if (n == 1) {
            return arr[0];
        }

        int l = 0, r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                return arr[mid];
            }

            if (arr[l] <= arr[mid] && arr[mid] > arr[r]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return arr[l];
    }
}
