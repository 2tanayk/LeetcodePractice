package array;

import java.util.*;

public class ConcatenationOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(getConcatenation(arr)));
    }

    public static int[] getConcatenation(int[] arr) {
        int n = arr.length;

        int[] ans = new int[2 * n];

        for (int i = 0; i < n; i++) {
            ans[i] = ans[i + n] = arr[i];
        }

        return ans;
    }
}
