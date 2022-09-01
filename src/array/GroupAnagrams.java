package array;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] arr = new String[n];

        sc.nextLine();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        System.out.println(groupAnagrams(arr));
    }

    public static List<List<String>> groupAnagrams(String[] arr) {
        int n = arr.length;

        List<List<String>> ans = new ArrayList<>();

        HashMap<String, List<String>> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String sorted = sort(arr[i], arr[i].length());

            List<String> temp = hm.getOrDefault(sorted, new ArrayList<>());
            temp.add(arr[i]);
            hm.put(sorted, temp);
        }

        for (Map.Entry<String, List<String>> e : hm.entrySet()) {
            ans.add(hm.get(e.getKey()));
        }

        return ans;
    }

    private static String sort(String s, int len) {
        if (len == 0 || len == 1) {
            return s;
        }

        int min = s.charAt(0) - 'a';
        int max = s.charAt(0) - 'a';

        for (int i = 1; i < len; i++) {
            int cur = s.charAt(i) - 'a';

            min = Math.min(min, cur);
            max = Math.max(max, cur);
        }

        int[] fArr = new int[max - min + 1];

        for (int i = 0; i < len; i++) {
            int cur = s.charAt(i) - 'a';
            fArr[cur - min]++;
        }

        for (int i = 1; i < fArr.length; i++) {
            fArr[i] += fArr[i - 1];
        }

        char[] sorted = new char[len];

        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int cur = c - 'a';
            sorted[--fArr[cur - min]] = c;
        }

        return String.valueOf(sorted);
    }
}
