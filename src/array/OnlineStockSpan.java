package array;

import java.util.*;

public class OnlineStockSpan {
    static class StockSpanner {

        List<Integer> p;
        List<Integer> skips;

        public StockSpanner() {
            p = new ArrayList<>();
            p.add(Integer.MAX_VALUE);
            skips = new ArrayList<>();
            skips.add(-1);
        }

        public int next(int price) {
            int i = p.size() - 1;

            while (price >= p.get(i)) {
                i = skips.get(i);
            }

            skips.add(i);
            p.add(price);

            return p.size() - 1 - i;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StockSpanner obj = new StockSpanner();
        int price = sc.nextInt();
        int param_1 = obj.next(price);
    }
}