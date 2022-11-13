package math;

import java.util.*;

public class ConvertTheTemperature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double celsius = sc.nextDouble();
        System.out.println(Arrays.toString(convertTemperature(celsius)));
    }

    public static double[] convertTemperature(double cel) {
        double[] ans = new double[2];

        ans[0] = cel + 273.15;
        ans[1] = cel * 1.80 + 32;

        return ans;
    }
}
