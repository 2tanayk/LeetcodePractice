package array;

import java.util.*;

public class MergeSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        merge(arr1, n1, arr2, n2);

        System.out.println(Arrays.toString(arr1));
    }

    private static void merge(int[] arr1, int m, int[] arr2, int n) {
        int i = m - 1, j = n - 1, k = arr1.length - 1;

        while (i >= 0 && j >= 0) {
            if (arr1[i] > arr2[j]) {
                arr1[k] = arr1[i];
                i--;
            } else {
                arr1[k] = arr2[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            arr1[k] = arr2[j];
            k--;
            j--;
        }
    }
}
