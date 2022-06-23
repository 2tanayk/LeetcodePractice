package array;

import java.util.*;

public class MaxErasureValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(maximumUniqueSubArray(arr));
    }

    private static int maximumUniqueSubArray(int[] arr) {
        int n = arr.length;

        if (n == 1) {
            return arr[0];
        }

        int i = 0, j = 0;
        HashSet<Integer> s = new HashSet<>();
        int sum = 0, max = 0;

        while (i <= j && j < n) {

            if (!s.contains(arr[j])) {
                sum += arr[j];
                s.add(arr[j]);
                j++;
            } else {
                sum -= arr[i];
                s.remove(arr[i]);
                i++;
            }

            if (max < sum) {
                max = sum;
            }
        }

        return max;
    }
}
