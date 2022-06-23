package array;

import java.util.Scanner;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(majorityElement(arr));
    }

    private static int majorityElement(int[] arr) {
        int n = arr.length;
        int ct = 1, e = arr[0];

        for (int i = 1; i < n; i++) {

            if (ct == 0) {
                e = arr[i];
            }

            if (arr[i] == e) {
                ct++;
            } else {
                ct--;
            }
        }

        return e;
    }
}
