package searchandsort;

import java.util.*;

public class FindFirstAndLastPosnInSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        System.out.println(Arrays.toString(searchRange(arr, target)));
    }

    private static int[] searchRange(int[] arr, int target) {
        int l = 0, h = arr.length - 1, mid = -1;
        int min = -1, max = -1;

        while (l <= h) {
            mid = (l + h) / 2;

            if (arr[mid] == target) {
                max = mid;
                l = mid + 1;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        l = 0;
        h = max;

        while (l <= h) {
            mid = (l + h) / 2;

            if (arr[mid] == target) {
                min = mid;
                h = mid - 1;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return new int[]{min, max};
    }
}
