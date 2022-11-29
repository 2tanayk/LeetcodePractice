package hashtable;

import java.util.*;

public class InsertDeleteGetRandom {
    static class RandomizedSet {
        HashMap<Integer, Integer> hm;
        List<Integer> l;

        public RandomizedSet() {
            hm = new HashMap<>();
            l = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (hm.containsKey(val)) {
                return false;
            }

            l.add(val);
            hm.put(val, l.size() - 1);

            return true;
        }

        public boolean remove(int val) {
            if (!hm.containsKey(val)) {
                return false;
            }

            int last = l.get(l.size() - 1);

            hm.put(last, hm.get(val));

            l.set(hm.get(val), last);
            l.remove(l.size() - 1);
            hm.remove(val);

            return true;
        }

        public int getRandom() {
            Random r = new Random();

            return l.get(r.nextInt(l.size()));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int val = sc.nextInt();

        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(val);
        boolean param_2 = obj.remove(val);
        int param_3 = obj.getRandom();
    }
}
