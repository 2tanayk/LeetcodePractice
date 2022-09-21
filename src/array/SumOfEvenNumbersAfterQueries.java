package array;

import java.util.*;

public class SumOfEvenNumbersAfterQueries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[][] queries = new int[n][2];

        for (int i = 0; i < n; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }

        System.out.println(Arrays.toString(sumEvenAfterQueries(arr, queries)));
    }

    public static int[] sumEvenAfterQueries(int[] arr, int[][] q) {
        int n = arr.length;

        int[] ans = new int[n];

        int eSum = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                eSum += arr[i];
            }
        }

        for (int i = 0; i < n; i++) {
            int bfr = arr[q[i][1]];

            arr[q[i][1]] += q[i][0];

            if (arr[q[i][1]] % 2 == 0) {
                if (bfr % 2 == 0) {
                    eSum += q[i][0];
                } else {
                    eSum += arr[q[i][1]];
                }
            } else {
                if (bfr % 2 == 0) {
                    eSum -= bfr;
                }
            }


            ans[i] = eSum;
        }

        return ans;
    }
}
