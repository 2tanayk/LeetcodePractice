package binarytree;

import java.util.*;

public class NaryTreeLevelOrderTraversal {
    public static final Scanner sc = new Scanner(System.in);

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = createNaryTree();

        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int ct = q.size();
            List<Integer> temp = new ArrayList<>();
            while (ct > 0) {
                Node cur = q.poll();
                temp.add(cur.val);
                q.addAll(cur.children);
                ct--;
            }
            ans.add(temp);
        }

        return ans;
    }

    private static Node createNaryTree() {
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        Node node = new Node(data);

        int n = sc.nextInt();
        List<Node> children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Node child = createNaryTree();

            if (child == null) {
                continue;
            }
            children.add(child);
        }
        node.children = children;

        return node;
    }
}
