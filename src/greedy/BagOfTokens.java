package greedy;

import java.util.*;

public class BagOfTokens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] tokens = new int[n];

        for (int i = 0; i < n; i++) {
            tokens[i] = sc.nextInt();
        }

        int power = sc.nextInt();

        System.out.println(bagOfTokensScore(tokens, power));
    }

    public static int bagOfTokensScore(int[] arr, int power) {
        int n = arr.length;

        if (n == 0) {
            return 0;
        }

        Arrays.sort(arr);

        int i = 0, j = n - 1;
        int score = 0, max = 0;

        while (i <= j) {
            if (power >= arr[i]) {
                score++;
                max = Math.max(max, score);
                power -= arr[i];
                i++;
            } else if (score >= 1) {
                score--;
                power += arr[j];
                j--;
            } else {
                break;
            }
        }

        return max;
    }
}
