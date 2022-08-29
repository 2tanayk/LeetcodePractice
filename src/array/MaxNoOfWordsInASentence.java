package array;

import java.util.*;

public class MaxNoOfWordsInASentence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        System.out.println(mostWordsFound(arr));
    }

    public static int mostWordsFound(String[] arr) {
        int n = arr.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, countSpace(arr[i].trim()) + 1);
        }

        return max;
    }

    private static int countSpace(String s) {
        int ct = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                ct++;
            }
        }

        return ct;
    }
}
