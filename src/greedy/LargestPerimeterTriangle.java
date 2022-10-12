package greedy;

import java.util.*;

public class LargestPerimeterTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(largestPerimeter(arr));
    }

    public static int largestPerimeter(int[] arr) {
        int n = arr.length;

        Arrays.sort(arr);

        for (int i = n - 1; i >= 2; i--) {
            if (arr[i] < arr[i - 1] + arr[i - 2]) {
                return arr[i] + arr[i - 1] + arr[i - 2];
            }
        }

        return 0;
    }
}
