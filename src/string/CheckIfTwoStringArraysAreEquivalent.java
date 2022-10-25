package string;

import java.util.*;

public class CheckIfTwoStringArraysAreEquivalent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] word1 = new String[n];
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            word1[i] = sc.nextLine();
        }

        n = sc.nextInt();
        String[] word2 = new String[n];

        sc.nextLine();

        for (int i = 0; i < n; i++) {
            word2[i] = sc.nextLine();
        }

        System.out.println(arrayStringsAreEqual(word1, word2));
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for (String s : word1) {
            s1.append(s);
        }

        for (String s : word2) {
            s2.append(s);
        }

        return s1.toString().equals(s2.toString());
    }
}
