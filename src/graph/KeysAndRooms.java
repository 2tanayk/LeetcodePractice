package graph;

import java.util.*;

public class KeysAndRooms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<List<Integer>> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                tmp.add(sc.nextInt());
            }
        }

        System.out.println(canVisitAllRooms(rooms));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];


        q.add(0);
        vis[0] = true;

        int tot = 0;

        while (!q.isEmpty()) {
            int ct = q.size();

            while (ct > 0) {
                int cur = q.poll();

                for (int room : rooms.get(cur)) {
                    if (vis[room]) {
                        continue;
                    }

                    q.add(room);
                    vis[room] = true;
                }

                tot++;

                ct--;
            }
        }

        return tot == n;
    }
}
