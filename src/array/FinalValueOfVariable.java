package array;

import java.util.*;

public class FinalValueOfVariable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        System.out.println(finalValueAfterOperations(arr));
    }

    public static int finalValueAfterOperations(String[] arr) {
        int x = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].contains("+")) {
                x++;
            } else {
                x--;
            }
        }

        return x;
    }
}
