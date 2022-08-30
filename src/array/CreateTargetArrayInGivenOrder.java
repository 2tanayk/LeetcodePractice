package array;

import java.util.*;

public class CreateTargetArrayInGivenOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];
        int[] index = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            index[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(createTargetArray(nums, index)));
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++) {
            insert(ans, nums[i], index[i]);
        }


        return ans;
    }

    private static void insert(int[] arr, int num, int pos) {
        if (arr[pos] == -1) {
            arr[pos] = num;
            return;
        }

        for (int i = arr.length - 2; i >= pos; i--) {
            arr[i + 1] = arr[i];
        }

        arr[pos] = num;
    }
}
