package greedy;

import java.util.*;

public class FindOriginalArrayFromDoubled {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(findOriginalArray(arr)));
    }

    public static int[] findOriginalArray(int[] arr) {
        int n = arr.length;

        if (n % 2 != 0) {
            return new int[]{};
        }

        int[] ans = new int[n / 2];

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int e : arr) {
            hm.put(e, hm.getOrDefault(e, 0) + 1);
        }

        if (hm.containsKey(0) && hm.get(0) % 2 != 0) {
            return new int[]{};
        }

        Arrays.sort(arr);

        int j = 0;
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(arr[i]) && hm.containsKey(2 * arr[i])) {
                ans[j++] = arr[i];

                int ef = hm.get(arr[i]) - 1;

                if (ef == 0) {
                    hm.remove(arr[i]);
                } else {
                    hm.put(arr[i], ef);
                }

                int df = hm.get(2 * arr[i]) - 1;

                if (df == 0) {
                    hm.remove(2 * arr[i]);
                } else {
                    hm.put(2 * arr[i], df);
                }
            }
        }

        if (hm.size() != 0) {
            return new int[]{};
        }

        return ans;
    }
}
