package array;

import java.util.Scanner;

public class MaxSubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(maxSubArray(arr));
    }

    private static int maxSubArray(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE, sum = 0, maxSum = 0;
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (!flag && arr[i] > 0) {
                flag = true;
            }

            if (!flag && max < arr[i]) {
                max = arr[i];
            }

            if (maxSum < sum) {
                maxSum = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        return flag ? maxSum : max;
    }
}
