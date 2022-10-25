package array;

import java.util.*;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] heights = new int[n];

        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] arr) {
        int n = arr.length;

        int[] firstL = new int[n];
        int[] firstR = new int[n];

        firstL[0] = -1;
        firstR[n - 1] = n;

        for (int i = 1; i < n; i++) {
            int p = i - 1;

            while (p >= 0 && arr[p] >= arr[i]) {
                p = firstL[p];
            }

            firstL[i] = p;
        }

        for (int i = n - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < n && arr[p] >= arr[i]) {
                p = firstR[p];
            }

            firstR[i] = p;
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i] * (firstR[i] - firstL[i] - 1));
        }

        return max;
    }
}
