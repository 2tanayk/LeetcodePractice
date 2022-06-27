package greedy;

import java.util.*;

public class JumpGame2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(jump(arr));
    }

    public static int jump(int[] arr) {
        int n = arr.length;

        if (n == 1) {
            return 0;
        }

        int jumps = 0;

        for (int i = 0; i < n; ) {
            int cur = arr[i];

            if (i + cur >= n - 1) {
                break;
            }

            int max = arr[i + 1] + i + 1, pos = i + 1;

            for (int j = i + 2; j <= i + cur; j++) {
                if (arr[j] + j > max) {
                    max = arr[j] + j;
                    pos = j;
                }
            }


            jumps++;
            i = pos;
        }

        jumps++;

        return jumps;
    }
}
