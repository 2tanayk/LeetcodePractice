package string;

import java.util.*;

public class PalindromePairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.nextLine();
        }

        System.out.println(palindromePairs(words));
    }

    public static List<List<Integer>> palindromePairs(String[] arr) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();

        if (n == 1) {
            return ans;
        }

        HashMap<String, Integer> hm = new HashMap<>();
        int[] lengths = new int[n];

        for (int i = 0; i < n; i++) {
            hm.put(arr[i], i);
            lengths[i] = arr[i].length();
        }

        Arrays.sort(lengths);

        for (int i = 0; i < n; i++) {
            String cur = arr[i];
            int cLen = cur.length();

            if (cur.length() == 1) {
                if (hm.containsKey("")) {
                    ans.add(Arrays.asList(i, hm.get("")));
                    ans.add(Arrays.asList(hm.get(""), i));
                }
                continue;
            }

            String rev = new StringBuilder(cur).reverse().toString();

            if (hm.containsKey(rev) && hm.get(rev) != i) {
                ans.add(Arrays.asList(i, hm.get(rev)));
            }

            int prev = -1;
            for (Integer len : lengths) {
                if (len == prev) {
                    continue;
                }
                if (len == cLen) {
                    break;
                }

                if (isPalindrome(rev, 0, cLen - 1 - len)) {
                    String s1 = rev.substring(cLen - len);
                    if (hm.containsKey(s1))
                        ans.add(Arrays.asList(i, hm.get(s1)));
                }

                if (isPalindrome(rev, len, cLen - 1)) {
                    String s2 = rev.substring(0, len);
                    if (hm.containsKey(s2))
                        ans.add(Arrays.asList(hm.get(s2), i));
                }
                prev = len;
            }
        }


        return ans;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        if (s.length() <= 1) {
            return true;
        }

        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
