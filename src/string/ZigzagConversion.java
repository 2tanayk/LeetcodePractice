package string;

import java.util.*;

public class ZigzagConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int numRows = sc.nextInt();

        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int nR) {
        if (nR == 1) {
            return s;
        }

        int len = s.length();

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < len; i += 2 * nR - 2) {
            ans.append(s.charAt(i));
        }

        int k = 1, zSize = nR - 2, skip = 2 * nR - 2;

        while (k < nR - 1) {
            for (int i = k; i < len; i += skip) {
                ans.append(s.charAt(i));

                int z = i + elementsBelow(i, nR, skip) + zSize;

                if (z < len) {
                    ans.append(s.charAt(z));
                }
            }
            k++;
            zSize--;
        }


        for (int i = nR - 1; i < len; i += skip) {
            ans.append(s.charAt(i));
        }

        return ans.toString();
    }

    private static int elementsBelow(int i, int nR, int skip) {
        return nR - 1 - i % skip;
    }
}
