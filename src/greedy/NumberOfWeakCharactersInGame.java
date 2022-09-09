package greedy;

import java.util.*;

public class NumberOfWeakCharactersInGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(numberOfWeakCharacters(arr));
    }

    public static int numberOfWeakCharacters(int[][] arr) {
        int n = arr.length;

        Arrays.sort(arr, (c1, c2) -> c1[0] != c2[0] ? c1[0] - c2[0] : c2[1] - c1[1]);

        int maxD = arr[n - 1][1];

        int ct = 0;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i][1] < maxD) {
                ct++;
            }
            maxD = Math.max(maxD, arr[i][1]);
        }

        return ct;
    }
}
