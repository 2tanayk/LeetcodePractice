package heap;

import java.util.*;

public class TaskScheduler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        char[] tasks = new char[n];

        for (int i = 0; i < n; i++) {
            tasks[i] = sc.nextLine().charAt(0);
        }

        System.out.println(leastInterval(tasks, n));
    }

    static class Pair {
        char c;
        int f;

        Pair(char c, int f) {
            this.c = c;
            this.f = f;
        }
    }

    public static int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for (char c : tasks) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.f != p2.f ? p2.f - p1.f : p1.c - p2.c);

        for (char c : hm.keySet()) {
            pq.add(new Pair(c, hm.get(c)));
        }

        int t = 0;

        while (!pq.isEmpty()) {
            int interval = n + 1;
            Queue<Pair> q = new LinkedList<>();

            while (!pq.isEmpty() && interval > 0) {
                Pair cur = pq.poll();
                cur.f -= 1;
                q.add(cur);
                t++;
                interval--;
            }

            while (!q.isEmpty()) {
                Pair temp = q.poll();

                if (temp.f > 0) {
                    pq.add(temp);
                }
            }

            if (pq.isEmpty()) {
                break;
            }

            t += interval;
        }

        return t;
    }
}
