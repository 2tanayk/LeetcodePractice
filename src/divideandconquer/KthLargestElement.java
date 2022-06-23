package divideandconquer;

import java.util.*;

public class KthLargestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(findKthLargest(arr, k));
    }

    public static int findKthLargest(int[] arr, int k) {
        int n = arr.length;
        int target = n - k;

        return kLargest(arr, 0, n - 1, target);
    }

    public static int kLargest(int[] arr, int l, int h, int target) {
        int index = partition(arr, l, h);

        if (index == target) {
            return arr[index];
        } else if (target < index) {
            return kLargest(arr, l, index - 1, target);
        } else {
            return kLargest(arr, index + 1, h, target);
        }

    }

    public static int partition(int[] arr, int l, int h) {
        int pivot = arr[h], i = l - 1, j = l;

        while (j <= h - 1) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }

            j++;
        }

        swap(arr, i + 1, j);

        return i + 1;
    }

    private static void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
}
