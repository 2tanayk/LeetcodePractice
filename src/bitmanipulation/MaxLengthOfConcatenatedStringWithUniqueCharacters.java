package bitmanipulation;

import java.util.*;

public class MaxLengthOfConcatenatedStringWithUniqueCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sc.nextLine();

        List<String> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextLine());
        }

        System.out.println(maxLength(arr));
    }

    public static int maxLength(List<String> arr) {
        List<Integer> dp = new ArrayList<>();
        dp.add(0);

        int max = 0;

        for (String s : arr) {
            int dup = 0, a = 0;
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';
                dup |= a & (1 << c);
                a |= (1 << c);
            }

            if (dup > 0) {
                continue;
            }

            for (int i = dp.size() - 1; i >= 0; i--) {
                if ((dp.get(i) & a) > 0) {
                    continue;
                }

                dp.add(dp.get(i) | a);

                max = Math.max(max, Integer.bitCount(dp.get(i) | a));
            }
        }

        return max;
    }
}
