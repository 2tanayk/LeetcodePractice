package binarytree;

import java.util.*;

public class AverageOfLevelsInBinaryTree {
    public static final Scanner sc = new Scanner(System.in);

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = createBinaryTree();

        System.out.println(averageOfLevels(root));
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int ct = q.size();
            double n = ct, sum = 0;
            while (ct > 0) {
                TreeNode cur = q.poll();
                sum += cur.val;

                if (cur.left != null) {
                    q.add(cur.left);
                }

                if (cur.right != null) {
                    q.add(cur.right);
                }

                ct--;
            }

            ans.add(sum / n);
        }

        return ans;
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
