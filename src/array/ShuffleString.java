package array;

import java.util.*;

public class ShuffleString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int n = sc.nextInt();
        int[] index = new int[n];

        for (int i = 0; i < n; i++) {
            index[i] = sc.nextInt();
        }

        System.out.println(restoreString(s, index));
    }

    public static String restoreString(String s, int[] indices) {
        char[] arr = new char[s.length()];

        for (int i = 0; i < arr.length; i++) {
            arr[indices[i]] = s.charAt(i);
        }

        return String.valueOf(arr);
    }
}
