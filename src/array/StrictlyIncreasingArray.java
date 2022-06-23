package array;

import java.util.*;

public class StrictlyIncreasingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(canBeIncreasing(arr));
    }

    private static boolean canBeIncreasing(int[] arr) {
        int n = arr.length;

        int niCt = 0, max = arr[0];
        int[] sus = new int[2];

        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else {
                niCt++;
                if (niCt == 1) {
                    sus[0] = i - 1;
                    sus[1] = i;
                    max = arr[i];
                }
            }

            if (niCt > 1) {
                return false;
            }
        }

        if (niCt == 0) {
            return true;
        }

        for (int i = 0; i < 2; i++) {
            boolean flag = false;
            int e = sus[i];
            max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                if (j == e) {
                    continue;
                }

                if (arr[j] > max) {
                    max = arr[j];
                } else {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                return true;
            }
        }

        return false;
    }
}
