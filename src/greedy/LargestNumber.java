package greedy;

import java.util.*;

public class LargestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(largestNumber(arr));
    }

    private static String largestNumber(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();

        for (int num : nums) {
            arr.add(num);
        }


        Collections.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                String s1 = i1 + "" + i2;
                String s2 = i2 + "" + i1;

                return s1.compareTo(s2) > 0 ? -1 : 1;
            }
        });

        StringBuilder sb = new StringBuilder();

        boolean flag = false;

        for (int num : arr) {
            if (!flag && num == 0) {
                continue;
            }

            flag = true;
            sb.append(num);
        }

        if (sb.length() == 0) {
            sb.append(0);
        }

        return sb.toString();
    }
}
