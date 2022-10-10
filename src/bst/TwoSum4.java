package bst;

import java.util.*;

public class TwoSum4 {
    private static final Scanner sc = new Scanner(System.in);
    static int i = 0;

    static class TreeNode {
        TreeNode left, right;
        int val;

        TreeNode(int data) {
            this.val = data;
        }
    }

    public static void main(String[] args) {
        TreeNode root = createBinaryTree();

        int k = sc.nextInt();

        System.out.println(findTarget(root, k));
    }

    static HashSet<Integer> hs = new HashSet<>();

    public static boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        boolean l = findTarget(root.left, k);
        if (hs.contains(k - root.val)) {
            return true;
        }
        hs.add(root.val);
        boolean r = findTarget(root.right, k);

        return l || r;
    }


    private static TreeNode createBinaryTree() {
        System.out.println("Enter data:");
        int data = sc.nextInt();

        if (data == -1) return null;

        TreeNode rootNode = new TreeNode(data);

        System.out.println("Enter left value for " + data + ":");
        rootNode.left = createBinaryTree();

        System.out.println("Enter right value for " + data + ":");
        rootNode.right = createBinaryTree();

        return rootNode;
    }
}
