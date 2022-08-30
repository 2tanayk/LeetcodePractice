package array;

import java.util.*;

public class CountItemsMatchingARule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        List<List<String>> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.nextLine();
            String color = sc.nextLine();
            String name = sc.nextLine();

            items.add(new ArrayList<>(Arrays.asList(type, color, name)));
        }

        String ruleKey = sc.nextLine();
        String ruleValue = sc.nextLine();

        System.out.println(countMatches(items, ruleKey, ruleValue));
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ct = 0;

        for (List<String> item : items) {
            if (ruleKey.equals("type")) {
                if (item.get(0).equals(ruleValue)) {
                    ct++;
                }
            } else if (ruleKey.equals("color")) {
                if (item.get(1).equals(ruleValue)) {
                    ct++;
                }
            } else {
                if (item.get(2).equals(ruleValue)) {
                    ct++;
                }
            }
        }

        return ct;
    }
}
