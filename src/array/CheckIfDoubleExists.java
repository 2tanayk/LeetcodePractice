package array;

import java.util.*;

public class CheckIfDoubleExists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(checkIfExist(arr));
    }

    private static boolean checkIfExist(int[] arr) {
        if (arr.length == 2) {
            return arr[0] == 2 * arr[1] || arr[1] == 2 * arr[0];
        }

        int n = arr.length;
        int zCt = 0;
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zCt++;
            }

            if (zCt >= 2) {
                return true;
            }

            hs.add(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            hs.remove(arr[i]);
            if (hs.contains(2 * arr[i])) {
                return true;
            }
            hs.add(arr[i]);
        }

        return false;
    }
}
