package array;

import java.util.*;

public class HowManyNosSmallerThanCurrentNo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(Arrays.toString(smallerNumbersThanCurrent(arr)));
    }

    public static int[] smallerNumbersThanCurrent(int[] arr) {
        int n = arr.length;

        int[] fArr = new int[101];

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            fArr[arr[i]]++;
        }

        for (int i = 1; i < 101; i++) {
            fArr[i] += fArr[i - 1];
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                ans[i] = 0;
                continue;
            }
            ans[i] = fArr[arr[i] - 1];
        }

        return ans;
    }
}
