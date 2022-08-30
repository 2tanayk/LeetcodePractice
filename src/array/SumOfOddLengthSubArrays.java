package array;

import java.util.*;

public class SumOfOddLengthSubArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(sumOddLengthSubarrays(arr));
    }

    public static int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;

        int tot = 0;

        for (int i = 1; i < n + 1; i += 2) {
            int sum = 0;

            for (int j = 0; j < i; j++) {
                sum += arr[j];
            }

            tot += sum;

            int j = 0, k = i;

            while (k < n) {
                sum -= arr[j++];
                sum += arr[k++];

                tot += sum;
            }
        }

        return tot;
    }
}
