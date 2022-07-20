package binarytree;

import java.util.*;

public class SerializeDeserializeBinaryTree {
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

        String sz = serialize(root);
        deserialize(sz);
    }

    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sz = new StringBuilder("");

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();

            if (cur == null) {
                sz.append("n ");
                continue;
            }

            sz.append(cur.val + " ");

            q.add(cur.left);
            q.add(cur.right);
        }

        System.out.println(sz.toString());

        return sz.toString();
    }

    public static TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] bArr = data.trim().split(" ");
        int n = bArr.length;
        int i = 0;

        TreeNode root = new TreeNode(Integer.parseInt(bArr[i]));

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                continue;
            }


            if (2 * i + 1 < n) {
                if (!bArr[2 * i + 1].equals("n")) {
                    TreeNode lc = new TreeNode(Integer.parseInt(bArr[2 * i + 1]));
                    node.left = lc;
                    q.add(lc);
                } else {
                    q.add(null);
                }
            }

            if (2 * i + 2 < n) {
                if (!bArr[2 * i + 2].equals("n")) {
                    TreeNode rc = new TreeNode(Integer.parseInt(bArr[2 * i + 2]));
                    node.right = rc;
                    q.add(rc);
                } else {
                    q.add(null);
                }
            }

            i++;
        }

        return root;
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
