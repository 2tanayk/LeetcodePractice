package string;

import java.util.*;

public class SortingTheSentences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(sortSentence(s));
    }

    public static String sortSentence(String s) {
        String[] arr = s.split(" ");
        int n = arr.length;

        for (int i = 0; i < n; ) {
            int len = arr[i].length();
            int index = arr[i].charAt(len - 1) - '0';
            if (index != i + 1) {
                String temp = arr[i];
                arr[i] = arr[index - 1];
                arr[index - 1] = temp;
            } else {
                arr[i] = arr[i].substring(0, len - 1);
                i++;
            }
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {
            ans.append(arr[i]).append(" ");
        }

        ans.deleteCharAt(ans.length() - 1);

        return ans.toString();
    }
}
