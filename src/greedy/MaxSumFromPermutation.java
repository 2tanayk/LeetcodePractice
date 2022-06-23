package greedy;

import java.util.*;

public class MaxSumFromPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int m = sc.nextInt();

        int[][] requests = new int[m][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                requests[i][j] = sc.nextInt();
            }
        }

        System.out.println(maxSumRangeQuery(arr, requests));
    }

    private static int maxSumRangeQuery(int[] arr, int[][] requests) {
        int n = arr.length;
        long m = 1000000007;

        Arrays.sort(arr);

        HashMap<Integer, Integer> fm = new HashMap<>();

        int[] fArr = new int[n];

        for (int i = 0; i < requests.length; i++) {
            int start = requests[i][0];
            int end = requests[i][1];

            fArr[start]++;

            if (end + 1 < arr.length) {
                fArr[end + 1]--;
            }
        }

        int fCt = 0;

        for (int i = 0; i < n; i++) {
            fCt += fArr[i];
            fArr[i] = fCt;
        }

        Arrays.sort(fArr);

        long ans = 0;

        for (int i = n - 1; i >= 0 && fArr[i] > 0; i--) {
            ans += (((long) fArr[i] * arr[i]) % m);
            ans = ans % m;
        }

        return (int) (ans % m);
    }
}
