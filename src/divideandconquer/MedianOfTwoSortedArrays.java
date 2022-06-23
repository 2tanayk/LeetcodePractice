package divideandconquer;

import java.util.*;

public class MedianOfTwoSortedArrays {
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

        System.out.println(findMedianSortedArrays(arr1, arr2));
    }

    private static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        if (n2 < n1) {
            return findMedianSortedArrays(arr2, arr1);
        }

        int low = 0, high = n1;

        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;

            int left1 = cut1 > 0 ? arr1[cut1 - 1] : Integer.MIN_VALUE;
            int left2 = cut2 > 0 ? arr2[cut2 - 1] : Integer.MIN_VALUE;

            int right1 = cut1 < n1 ? arr1[cut1] : Integer.MAX_VALUE;
            int right2 = cut2 < n2 ? arr2[cut2] : Integer.MAX_VALUE;

            if (left1 <= right2 && left2 <= right1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }

        return -1.0;
    }
}
