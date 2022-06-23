package divideandconquer;

import java.util.*;

public class BinaryTreeFromPostAndInTraversals {
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

    static int i = -1;
    static HashMap<Integer, Integer> hm = new HashMap<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] in = new int[n];

        for (int i = 0; i < n; i++) {
            in[i] = sc.nextInt();
        }

        int[] post = new int[n];

        for (int i = 0; i < n; i++) {
            post[i] = sc.nextInt();
        }

        System.out.println(buildTree(in, post));
    }

    private static TreeNode buildTree(int[] in, int[] post) {
        int n = in.length;
        i = n - 1;

        for (int i = 0; i < n; i++) {
            hm.put(in[i], i);
        }

        return build(in, post, 0, n - 1);
    }

    public static TreeNode build(int[] in, int[] post, int l, int h) {
        if (l > h) {
            return null;
        }

        if (l == h) {
            return new TreeNode(post[i--]);
        }

        TreeNode node = new TreeNode(post[i--]);

        int index = hm.get(node.val);

        node.right = build(in, post, index + 1, h);
        node.left = build(in, post, l, index - 1);

        return node;
    }
}
