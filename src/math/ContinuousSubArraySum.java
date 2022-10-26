package math;

import java.util.*;

public class ContinuousSubArraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(checkSubarraySum(arr, k));
    }

    public static boolean checkSubarraySum(int[] arr, int k) {
        int n = arr.length;

        HashMap<Integer, Integer> hm = new HashMap<>();

        hm.put(0, -1);

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            int rem = sum % k;

            if (hm.containsKey(rem)) {
                int idx = hm.get(rem);
                int diff = i - idx;

                if (diff > 1) {
                    return true;
                }
            } else {
                hm.put(rem, i);
            }
        }

        return false;
    }
}
