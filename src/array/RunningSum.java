package array;

import java.util.*;

public class RunningSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(runningSum(arr)));
    }

    public static int[] runningSum(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
        }

        return arr;
    }
}
