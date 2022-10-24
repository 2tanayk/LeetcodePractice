package greedy;

import java.util.*;

public class MinNumberOfOperationsToMakeArraysSimilar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];
        int[] target = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            target[i] = sc.nextInt();
        }

        System.out.println(makeSimilar(nums, target));
    }

    public static long makeSimilar(int[] nums, int[] target) {
        int n = nums.length;

        long ans = 0;

        Arrays.sort(nums);
        Arrays.sort(target);


        int ie = 0, je = 0, io = 0, jo = 0;


        while (ie < n && je < n) {
            while (ie < n && nums[ie] % 2 != 0) {
                ie++;
            }

            if (ie >= n) {
                break;
            }

            while (je < n && target[je] % 2 != 0) {
                je++;
            }

            if (je >= n) {
                break;
            }

            ans += Math.abs(nums[ie++] - target[je++]) / 2;
        }

        while (io < n && jo < n) {
            while (io < n && nums[io] % 2 == 0) {
                io++;
            }

            if (io >= n) {
                break;
            }

            while (jo < n && target[jo] % 2 == 0) {
                jo++;
            }

            if (jo >= n) {
                break;
            }

            ans += Math.abs(nums[io++] - target[jo++]) / 2;
        }

        return ans / 2;
    }
}
