package graph;

import java.util.*;

public class MinimumGeneticMutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String start = sc.nextLine();
        String end = sc.nextLine();

        int n = sc.nextInt();
        sc.nextLine();
        String[] bank = new String[n];

        for (int i = 0; i < n; i++) {
            bank[i] = sc.nextLine();
        }

        System.out.println(minMutation(start, end, bank));
    }

    public static int minMutation(String st, String en, String[] b) {
        char[] ops = {'A', 'C', 'G', 'T'};

        HashSet<String> hs = new HashSet<>(Arrays.asList(b));

        int ct = 0;

        HashSet<String> vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(st);
        vis.add(st);

        while (!q.isEmpty()) {
            int size = q.size();

            while (size > 0) {
                String cur = q.poll();

                if (cur.equals(en)) {
                    return ct;
                }

                StringBuilder s = new StringBuilder(cur);

                for (int i = 0; i < cur.length(); i++) {
                    char c = s.charAt(i);
                    for (char nc : ops) {
                        if (nc == c) {
                            continue;
                        }

                        s.setCharAt(i, nc);

                        if (!vis.contains(s.toString()) && hs.contains(s.toString())) {
                            q.add(s.toString());
                            vis.add(s.toString());
                        }
                    }
                    s.setCharAt(i, c);
                }

                size--;
            }
            ct++;
        }

        return -1;
    }
}
