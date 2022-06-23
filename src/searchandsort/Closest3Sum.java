package searchandsort;

import java.util.*;

public class Closest3Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        System.out.println(threeSumClosest(arr, target));
    }

    private static int threeSumClosest(int[] arr, int target) {
        int n = arr.length;

        if (n == 3) {
            return arr[0] + arr[1] + arr[2];
        }

        Arrays.sort(arr);
        int closest = Integer.MAX_VALUE, cSum = -1;


        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, h = n - 1;

            while (l < h) {
                int sum = arr[i] + arr[l] + arr[h];

                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    l++;
                } else {
                    h--;
                }

                if (Math.abs(target - sum) < closest) {
                    closest = Math.abs(target - sum);
                    cSum = sum;
                }
            }
        }

        return cSum;
    }
}
