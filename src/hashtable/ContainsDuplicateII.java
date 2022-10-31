package hashtable;

import java.util.*;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(containsNearbyDuplicate(arr, k));
    }

    public static boolean containsNearbyDuplicate(int[] arr, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(arr[i]) && i - hm.get(arr[i]) <= k) {
                return true;
            }

            hm.put(arr[i], i);
        }

        return false;
    }
}
