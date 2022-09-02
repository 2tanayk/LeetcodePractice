package array;

import java.util.*;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }

    public static int[] productExceptSelf(int[] arr) {
        int n = arr.length;

        int[] ans = new int[n];

        int prod = 1;
        for (int i = 0; i < n; i++) {
            ans[i] = prod;
            prod *= arr[i];
        }

        prod = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= prod;
            prod *= arr[i];
        }

        return ans;
    }
}
