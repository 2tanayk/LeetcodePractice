package array;

import java.util.*;

public class TrappingRainwater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] heights = new int[n];

        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        System.out.println(trap(heights));
    }

    public static int trap(int[] arr) {
        int n = arr.length;

        int i = 0, j = n - 1;
        int lMax = 0, rMax = 0;

        int ans = 0;

        while (i < j) {
            if (arr[i] > arr[j]) {
                ans += Math.max(rMax - arr[j], 0);
                rMax = Math.max(rMax, arr[j]);
                j--;
            } else {
                ans += Math.max(lMax - arr[i], 0);
                lMax = Math.max(lMax, arr[i]);
                i++;
            }
        }

        return ans;
    }
}
