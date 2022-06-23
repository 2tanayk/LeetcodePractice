package array;

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

    private static int maxArea(int[] arr) {
        int n = arr.length;

        if (n == 2) {
            return Math.min(arr[0], arr[1]);
        }

        int i = 0, j = n - 1, area = 0, max = -1;

        while (i < j) {
            area = Math.min(arr[i], arr[j]) * (j - i);

            if (area > max) {
                max = area;
            }

            if (arr[i] > arr[j]) {
                j--;
            } else {
                i++;
            }
        }

        return max;
    }
}
