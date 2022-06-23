package divideandconquer;

import java.util.*;

public class BinaryTreeFromPreAndInTraversals {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static HashMap<Integer, Integer> pm = new HashMap<>();
    static int i = 0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] in = new int[n];

        for (int i = 0; i < n; i++) {
            in[i] = sc.nextInt();
        }

        int[] pre = new int[n];

        for (int i = 0; i < n; i++) {
            pre[i] = sc.nextInt();
        }

        System.out.println(buildTree(pre, in));
    }

    private static TreeNode buildTree(int[] pre, int[] in) {
        int n = in.length;

        for (int i = 0; i < n; i++) {
            pm.put(in[i], i);
        }

        return build(in, pre, 0, n - 1);
    }

    private static TreeNode build(int[] in, int[] pre, int l, int r) {
        if (l > r) {
            return null;
        }

        if (l == r) {
            return new TreeNode(pre[i++]);
        }

        TreeNode node = new TreeNode(pre[i++]);

        int pIndex = pm.get(node.val);


        node.left = build(in, pre, l, pIndex - 1);
        node.right = build(in, pre, pIndex + 1, r);

        return node;
    }
}
