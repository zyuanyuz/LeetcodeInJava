package problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 133 CloneGroph Medium
 */

public class CloneGraph {
    //Runtime: 3 ms, faster than 6.33% of Java online submissions for Clone Graph.
    //Memory Usage: 33.5 MB, less than 97.65% of Java online submissions for Clone Graph.
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        List<Node> oldNodes = new ArrayList<>();
        List<Node> newNodes = new ArrayList<>();
        oldNodes.add(node);
        makeupNodes(oldNodes, newNodes);
        return newNodes.get(0);
    }

    void makeupNodes(List<Node> oldNodes, List<Node> newNodes) {
        Node newNode = new Node(oldNodes.get(oldNodes.size() - 1).val, new ArrayList<>());
        newNodes.add(newNode);
        for (Node node : oldNodes.get(oldNodes.size() - 1).neighbors) {
            for (int i = 0; i < oldNodes.size(); i++) {
                if (node == oldNodes.get(i)) {
                    newNode.neighbors.add(newNodes.get(i));
                    break;
                } else if (i == oldNodes.size() - 1) {
                    oldNodes.add(node);
                    makeupNodes(oldNodes, newNodes);
                }
            }
        }
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}