package graph;

import java.util.*;

public class SatisfiabilityOfEqualityEquations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] equations = new String[n];
        for (int i = 0; i < n; i++) {
            equations[i] = sc.nextLine();
        }

        System.out.println(equationsPossible(equations));
    }

    public static boolean equationsPossible(String[] eqns) {
        int[] p = new int[26];

        for (int i = 0; i < 26; i++) {
            p[i] = i;
        }

        for (String e : eqns) {
            int src = e.charAt(0) - 'a';
            char op = e.charAt(1);
            int dst = e.charAt(3) - 'a';

            if (op == '=') {
                p[find(p, src)] = find(p, dst);
            }
        }

        for (String e : eqns) {
            int src = e.charAt(0) - 'a';
            char op = e.charAt(1);
            int dst = e.charAt(3) - 'a';

            if (op == '!' && find(p, src) == find(p, dst)) {
                return false;
            }
        }

        return true;
    }

    private static int find(int[] p, int c) {
        if (p[c] != c) {
            p[c] = find(p, p[c]);
        }

        return p[c];
    }
}
