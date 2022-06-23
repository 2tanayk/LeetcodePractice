package array;

import java.util.Scanner;

public class MinOperationsToReduceX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(minOperations(arr, x));
    }

    private static int minOperations(int[] arr, int x) {
        int sum = 0;

        for (int num : arr) sum += num;

        int maxLength = -1, currSum = 0;
        for (int l = 0, r = 0; r < arr.length; r++) {
            currSum += arr[r];
            while (l <= r && currSum > sum - x) currSum -= arr[l++];
            if (currSum == sum - x) maxLength = Math.max(maxLength, r - l + 1);
        }

        return maxLength == -1 ? -1 : arr.length - maxLength;
    }
}
