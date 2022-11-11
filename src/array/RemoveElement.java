package array;

import java.util.*;

public class RemoveElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int val = sc.nextInt();

        System.out.println(removeElement(nums, val));
    }

    public static int removeElement(int[] arr, int val) {
        int n = arr.length;
        int ct = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == val) {
                arr[i] = -1;
                ct++;
            }
        }

        int i = 0, j = 0;

        while (j < n) {
            if (arr[j] != -1) {
                swap(arr, i, j);
                i++;
            }

            j++;
        }


        return n - ct;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
