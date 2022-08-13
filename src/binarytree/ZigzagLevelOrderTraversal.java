package binarytree;

import java.util.*;

public class ZigzagLevelOrderTraversal {
    public static final Scanner sc = new Scanner(System.in);

    static public class TreeNode {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeNode root = createBinaryTree();

        System.out.println(zigzagLevelOrder(root));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int lvl = 0;
        while (!q.isEmpty()) {
            int ct = q.size();
            List<Integer> temp = new ArrayList<>();

            while (ct-- > 0) {
                TreeNode cur = q.poll();
                temp.add(cur.val);

                if (cur.left != null) {
                    q.add(cur.left);
                }

                if (cur.right != null) {
                    q.add(cur.right);
                }
            }

            if (lvl % 2 != 0) {
                Collections.reverse(temp);
            }

            ans.add(temp);
            lvl++;
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
