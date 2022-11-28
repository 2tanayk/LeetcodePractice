package hashtable;

import java.util.*;

public class FindPlayersWithZeroOrOneLosses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] matches = new int[n][2];

        for (int i = 0; i < n; i++) {
            matches[i][0] = sc.nextInt();
            matches[i][1] = sc.nextInt();
        }

        System.out.println(findWinners(matches));
    }

    public static List<List<Integer>> findWinners(int[][] matches) {
        int n = matches.length;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int[] m : matches) {
            if (!hm.containsKey(m[0])) {
                hm.put(m[0], 0);
            }

            hm.put(m[1], hm.getOrDefault(m[1], 0) + 1);
        }

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();

        for (int key : hm.keySet()) {
            if (hm.get(key) == 0) {
                temp1.add(key);
            } else if (hm.get(key) == 1) {
                temp2.add(key);
            }
        }


        Collections.sort(temp1);
        Collections.sort(temp2);

        ans.add(temp1);
        ans.add(temp2);

        return ans;
    }
}
