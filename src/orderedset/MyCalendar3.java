package orderedset;

import java.util.*;

public class MyCalendar3 {
    static class MyCalendarThree {

        TreeMap<Integer, Integer> t;

        public MyCalendarThree() {
            t = new TreeMap<>();
        }

        public int book(int st, int en) {
            t.put(st, t.getOrDefault(st, 0) + 1);
            t.put(en, t.getOrDefault(en, 0) - 1);

            int cur = 0, k = 1;
            for (Integer v : t.values()) {
                cur += v;
                k = Math.max(k, cur);
            }

            return k;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyCalendarThree myCalendarThree = new MyCalendarThree();
        int start = sc.nextInt();
        int end = sc.nextInt();

        myCalendarThree.book(start, end);
    }
}
