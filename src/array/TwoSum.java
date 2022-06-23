package array;

import java.util.*;

public class TwoSum {
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

    public static int[] twoSum(int[] arr, int target) {
        int n = arr.length;
        HashMap<Integer, Integer> seen = new HashMap<>();
        seen.put(arr[0], 0);


        for (int i = 1; i < n; i++) {
            if (seen.containsKey(target - arr[i])) {
                return new int[]{i, seen.get(target - arr[i])};
            } else {
                seen.put(arr[i], i);
            }
        }

        return new int[]{-1, -1};
    }
}
