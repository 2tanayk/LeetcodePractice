package greedy;

import java.util.*;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(maxArea(arr));
    }

    public static int maxArea(int[] arr) {
        int n = arr.length;

        int i = 0, j = n - 1;
        int max = Integer.MIN_VALUE;

        while (i < j) {
            max = Math.max(max, (j - i) * Math.min(arr[i], arr[j]));
            if (arr[i] > arr[j]) {
                j--;
            } else if (arr[i] < arr[j]) {
                i++;
            } else {
                i++;
                j--;
            }
        }

        return max;
    }
}
