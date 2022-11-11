package array;

import java.util.*;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] arr) {
        int n = arr.length;

        int i = 1, ct = 1;

        while (i < n) {
            while (i < n && arr[i] == arr[i - 1]) {
                arr[i - 1] = 101;
                i++;
            }

            if (i == n) {
                break;
            }

            i++;
            ct++;
        }

        i = 0;
        int j = 0;

        while (j < n) {
            if (arr[j] != 101) {
                swap(arr, i, j);
                i++;
            }
            j++;
        }


        return ct;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
