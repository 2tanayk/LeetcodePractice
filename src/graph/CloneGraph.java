package graph;

import java.util.*;

public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nV = sc.nextInt();
        List<Node> graph = new ArrayList<>();
        graph.add(null);
        for (int i = 1; i <= nV; i++) {
            graph.add(new Node(i));
        }

        int nE = sc.nextInt();
        for (int i = 0; i < nE; i++) {
            int source = sc.nextInt();
            int dest = sc.nextInt();

            graph.get(source).neighbors.add(graph.get(dest));
            graph.get(dest).neighbors.add(graph.get(source));
        }

        Node ref = cloneGraph(graph.get(1));

    }

    public static void dfs(Node node, Node copy, Node[] visited) {
        visited[copy.val] = copy;// store the current node at it's val index which will tell us that this node is now visited

//         now traverse for the adjacent nodes of root node
        for (Node n : node.neighbors) {
//             check whether that node is visited or not
//              if it is not visited, there must be null
            if (visited[n.val] == null) {
//                 so now if it not visited, create a new node
                Node newNode = new Node(n.val);
//                 add this node as the neighbor of the prev copied node
                copy.neighbors.add(newNode);
//                 make dfs call for this unvisited node to discover whether it's adjacent nodes are explored or not
                dfs(n, newNode, visited);
            } else {
//                 if that node is already visited, retrieve that node from visited array and add it as the adjacent node of prev copied node
//                 THIS IS THE POINT WHY WE USED NODE[] INSTEAD OF BOOLEAN[] ARRAY
                copy.neighbors.add(visited[n.val]);
            }
        }

    }

    public static Node cloneGraph(Node node) {
        if (node == null) return null; // if the actual node is empty there is nothing to copy, so return null
        Node copy = new Node(node.val); // create a new node , with same value as the root node(given node)
        Node[] visited = new Node[101]; // in this question we will create an array of Node(not boolean) why ? , because i have to add all the adjacent nodes of particular vertex, whether it's visited or not, so in the Node[] initially null is stored, if that node is visited, we will store the respective node at the index, and can retrieve that easily.
        Arrays.fill(visited, null); // initially store null at all places
        dfs(node, copy, visited); // make a dfs call for traversing all the vertices of the root node
        return copy; // in the end return the copy node
    }
}
