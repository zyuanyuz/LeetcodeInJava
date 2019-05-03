package problems.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 116 PopulatingNextRightPointersinEachNode Medium
 * 
 */

public class PopulatingNextRightPointersinEachNode {
    //Runtime: 1 ms, faster than 43.19% of Java online submissions for Populating Next Right Pointers in Each Node.
    //Memory Usage: 35.9 MB, less than 74.32% of Java online submissions for Populating Next Right Pointers in Each Node. 
    public Node connect(Node root) {
        if (root == null)
            return root;
        Queue<Node> oneQueue = new LinkedList<>();
        Queue<Node> twoQueue = new LinkedList<>();
        oneQueue.offer(root);
        boolean queueSwitch = true;
        while (!oneQueue.isEmpty() || !twoQueue.isEmpty()) {
            Queue<Node> takeQueue = queueSwitch ? oneQueue : twoQueue;
            Queue<Node> offerQueue = queueSwitch ? twoQueue : oneQueue;
            Node linkNode = new Node();
            while (!takeQueue.isEmpty()) {
                if(takeQueue.peek()==null){
                    linkNode = new Node();  
                    takeQueue.poll();
                    continue;
                }
                linkNode.next = takeQueue.poll();
                linkNode = linkNode.next;
                offerQueue.offer(linkNode.left);
                offerQueue.offer(linkNode.right);
            }
            queueSwitch = !queueSwitch;
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}