package stackandqueue;

import java.util.*;

public class CarFleet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int target = sc.nextInt();

        int n = sc.nextInt();

        int[] position = new int[n];
        int[] speed = new int[n];

        for (int i = 0; i < n; i++) {
            position[i] = sc.nextInt();
            speed[i] = sc.nextInt();
        }

        System.out.println(carFleet(target, position, speed));
    }

    static class Pair {
        int p, s;

        Pair(int p, int s) {
            this.p = p;
            this.s = s;
        }
    }

    public static int carFleet(int target, int[] pos, int[] s) {
        int n = pos.length;

        ArrayList<Pair> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            cars.add(new Pair(pos[i], s[i]));
        }

        Collections.sort(cars, (c1, c2) -> c2.p - c1.p);

        Stack<Double> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            Pair car = cars.get(i);

            st.push((target - car.p) * 1.0 / car.s);

            if (st.size() >= 2) {
                double t1 = st.pop();
                double t2 = st.pop();

                if (t1 <= t2) {
                    st.push(t2);
                } else {
                    st.push(t2);
                    st.push(t1);
                }
            }
        }

        return st.size();
    }
}
