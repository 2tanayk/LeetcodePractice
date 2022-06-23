package math;

import java.util.*;

public class ValidBoomerang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[3][2];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(isBoomerang(arr));
    }

    private static boolean isBoomerang(int[][] arr) {
        if (Arrays.equals(arr[0], arr[1]) || Arrays.equals(arr[1], arr[2]) || Arrays.equals(arr[0], arr[2])) {
            return false;
        }

        if (arr[0][0] == arr[1][0] && arr[1][0] == arr[2][0]) {
            return false;
        }

        double slope1 = ((arr[0][1] - arr[1][1]) * 1.0) / (arr[0][0] - arr[1][0]);

        double slope2 = ((arr[1][1] - arr[2][1]) * 1.0) / (arr[1][0] - arr[2][0]);

        return !(slope1 == slope2);
    }
}
