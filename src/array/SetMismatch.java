package array;

import java.util.*;

public class SetMismatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(findErrorNums(arr)));
    }

    public static int[] findErrorNums(int[] arr) {
        int n = arr.length;

        int[] ans = new int[2];

        for (int i = 0; i < n; i++) {
            int cur = Math.abs(arr[i]);
            if (arr[cur - 1] < 0) {
                ans[0] = cur;
            } else {
                arr[cur - 1] *= -1;
            }
        }


        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                ans[1] = i + 1;
                break;
            }
        }

        return ans;
    }
}
