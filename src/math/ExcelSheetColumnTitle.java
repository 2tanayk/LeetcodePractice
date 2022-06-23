package math;

import java.util.Scanner;

public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(convertToTitle(n));
    }

    private static String convertToTitle(int cNum) {
        StringBuilder s = new StringBuilder("");

        while (cNum > 0) {
            int r = cNum % 26;

            if (r == 0) {
                s.append("Z");
                cNum = (cNum - 26) / 26;
            } else {
                s.append((char) (64 + r));
                cNum = (cNum - r) / 26;
            }
        }

        return s.reverse().toString();
    }
}
