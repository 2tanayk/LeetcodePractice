package array;

import java.util.*;

public class MajorityElement2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(majorityElement(arr));
    }

    private static List<Integer> majorityElement(int[] arr) {
        int len = arr.length;

        List<Integer> ans = new ArrayList<>();

        int n1 = Integer.MIN_VALUE, n2 = Integer.MIN_VALUE, ct1 = 0, ct2 = 0;

        for (int i = 0; i < len; i++) {
            if (arr[i] == n1) {
                ct1++;
            } else if (arr[i] == n2) {
                ct2++;
            } else if (ct1 == 0) {
                n1 = arr[i];
                ct1 = 1;
            } else if (ct2 == 0) {
                n2 = arr[i];
                ct2 = 1;
            } else {
                ct1--;
                ct2--;
            }
        }

        ct1 = 0;
        ct2 = 0;

        for (int i = 0; i < len; i++) {
            if (arr[i] == n1) {
                ct1++;
            } else if (arr[i] == n2) {
                ct2++;
            }

            if (ct1 > len / 3 && ct2 > len / 3) {
                return Arrays.asList(n1, n2);
            }
        }

        if (ct1 > len / 3) {
            ans.add(n1);
        }

        if (ct2 > len / 3) {
            ans.add(n2);
        }

        return ans;
    }
}
