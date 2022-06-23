package bitmanipulation;

import java.util.*;

public class ReduceNumberToZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(noOfSteps(n));
    }

    private static int noOfSteps(int num) {
        int ct = 0;
        while (num > 0) {
            num = (num & 1) == 0 ? num >> 1 : num - 1;
            ct++;
        }
        return ct;
    }
}
