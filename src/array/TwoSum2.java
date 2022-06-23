package array;

import java.util.*;

public class TwoSum2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(twoSum(arr, target)));
    }

    private static int[] twoSum(int[] arr, int target) {
        int n = arr.length;
        if (n == 2) {
            return new int[]{1, 2};
        }

        int i = 0, j = n - 1;

        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }

        return new int[]{-1, -1};
    }
}
