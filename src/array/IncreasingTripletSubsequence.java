package array;

import java.util.*;

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(increasingTriplet(arr));
    }

    public static boolean increasingTriplet(int[] arr) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

        for (int e : arr) {
            if (e <= first) {
                first = e;
            } else if (e <= second) {
                second = e;
            } else {
                return true;
            }
        }

        return false;
    }
}
