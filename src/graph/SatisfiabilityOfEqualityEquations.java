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

    static int[] p = new int[26];
    static int[] rank = new int[26];

    public static boolean equationsPossible(String[] eqns) {
        for (int i = 0; i < 26; i++) {
            p[i] = i;
        }

        for (String e : eqns) {
            int src = e.charAt(0) - 'a';
            char op = e.charAt(1);
            int dst = e.charAt(3) - 'a';

            if (op == '=') {
                int rS = find(src);
                int rD = find(dst);

                if (rank[rS] < rank[rD]) {
                    p[rS] = rD;
                } else if (rank[rS] > rank[rD]) {
                    p[rD] = rS;
                } else {
                    p[rS] = rD;
                    rank[rD]++;
                }
            }
        }

        for (String e : eqns) {
            int src = e.charAt(0) - 'a';
            char op = e.charAt(1);
            int dst = e.charAt(3) - 'a';

            if (op == '!' && find(src) == find(dst)) {
                return false;
            }
        }

        return true;
    }

    private static int find(int c) {
        if (p[c] == c) {
            return c;
        }

        return p[c] = find(p[c]);
    }
}
