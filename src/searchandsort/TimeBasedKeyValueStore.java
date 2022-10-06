package searchandsort;

import java.util.*;

public class TimeBasedKeyValueStore {
    static class TimeMap {
        HashMap<String, List<Integer>> tm;
        HashMap<String, String> hm;

        public TimeMap() {
            tm = new HashMap<>();
            hm = new HashMap<>();
        }

        public void set(String key, String val, int ts) {
            List<Integer> tmp = tm.getOrDefault(key, new ArrayList<>());
            tmp.add(ts);
            tm.put(key, tmp);

            hm.put(key + " " + ts, val);
        }

        public String get(String key, int ts) {
            List<Integer> tmp = tm.getOrDefault(key, new ArrayList<>());

            int n = tmp.size();

            if (n == 0 || ts < tmp.get(0)) {
                return "";
            }

            if (ts >= tmp.get(n - 1)) {
                return hm.get(key + " " + tmp.get(n - 1));
            }

            int l = 0, h = n - 1;

            while (l <= h) {
                int m = (l + h) / 2;

                if (tmp.get(m) == ts) {
                    return hm.get(key + " " + tmp.get(m));
                }

                if (tmp.get(m) < ts) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }

            return hm.get(key + " " + tmp.get(h));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String key = sc.nextLine();
        String value = sc.nextLine();
        int timestamp = sc.nextInt();

        TimeMap obj = new TimeMap();
        obj.set(key, value, timestamp);
        String param_2 = obj.get(key, timestamp);
    }
}
