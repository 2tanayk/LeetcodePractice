package hashtable;

import java.util.*;

public class UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        int n = arr.length;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int e : arr) {
            hm.put(e, hm.getOrDefault(e, 0) + 1);
        }

        HashSet<Integer> hs = new HashSet<>();

        for (int key : hm.keySet()) {
            if (hs.contains(hm.get(key))) {
                return false;
            }
            hs.add(hm.get(key));
        }

        return true;
    }
}
