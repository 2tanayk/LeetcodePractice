package heap;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = sc.nextLine();
        }

        int k = sc.nextInt();

        System.out.println(topKFrequent(words, k));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();

        HashMap<String, Integer> hm = new HashMap<>();

        for (String s : words) {
            hm.put(s, hm.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> hm.get(s1) == hm.get(s2) ? s2.compareTo(s1) : hm.get(s1) - hm.get(s2));

        for (String key : hm.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else {
                String t = pq.peek();

                if (hm.get(t) < hm.get(key) || (hm.get(t) == hm.get(key) && t.compareTo(key) > 0)) {
                    pq.poll();
                    pq.add(key);
                }
            }
        }

        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }

        Collections.reverse(ans);

        return ans;
    }
}
