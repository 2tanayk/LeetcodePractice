package math;

import java.util.*;

public class IntegerToRoman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        System.out.println(intToRoman(num));
    }

    public static String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();

        int q = num / 1000;

        while (q > 0) {
            ans.append('M');
            q--;
        }

        num %= 1000;

        if (num / 100 == 9) {
            ans.append("CM");
            num %= 900;
        } else if (num / 100 >= 5) {
            ans.append('D');
            num %= 500;
        }

        q = num / 100;

        if (q < 4) {
            while (q > 0) {
                ans.append('C');
                q--;
            }
        } else {
            ans.append("CD");
        }

        num %= 100;

        if (num / 10 == 9) {
            ans.append("XC");
            num %= 90;
        } else if (num / 10 >= 5) {
            ans.append('L');
            num %= 50;
        }

        q = num / 10;

        if (q < 4) {
            while (q > 0) {
                ans.append('X');
                q--;
            }
        } else {
            ans.append("XL");
        }

        num %= 10;

        if (num == 9) {
            ans.append("IX");
        } else if (num >= 5) {
            ans.append('V');
            num %= 5;
        } else if (num == 4) {
            ans.append("IV");
        }

        if (num < 4) {
            while (num > 0) {
                ans.append('I');
                num--;
            }
        }

        return ans.toString();
    }
}
