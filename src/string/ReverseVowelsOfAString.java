package string;

import java.util.*;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();

        int i = 0, j = len - 1;

        while (i < j) {
            while (i < j && !isVowel(arr[i])) {
                i++;
            }

            if (i >= j) {
                break;
            }

            while (i < j && !isVowel(arr[j])) {
                j--;
            }

            if (i >= j) {
                break;
            }

            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;

            i++;
            j--;
        }

        return String.valueOf(arr);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U';
    }
}
