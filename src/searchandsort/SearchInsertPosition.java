package searchandsort;

import java.util.*;

public class SearchInsertPosition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(twoSum(arr, target));
    }

    private static int twoSum(int[] arr, int target) {
        int low = 0, high = arr.length - 1, mid = -1;

        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return arr[mid] > target ? mid : mid + 1;
    }

}
