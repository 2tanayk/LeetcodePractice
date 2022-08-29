package array;

import java.util.*;

public class NumberOfGoodPairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(numIdenticalPairs(arr));
    }

    public static int numIdenticalPairs(int[] arr) {
        int n = arr.length;

        int ct = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (hm.containsKey(arr[i])) {
                ct += hm.get(arr[i]);
            }
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }

        return ct;
    }
}
