package math;

import java.util.*;

public class AddDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(addDigits(n));
    }

    public static int addDigits(int num) {
        if (num == 0) {
            return 0;
        }

        return num % 9 == 0 ? 9 : num % 9;
    }
}
