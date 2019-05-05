package problems.medium;

import java.util.*;

/**
 * leetcode 116 PopulatingNextRightPointersinEachNodeII Medium
 *
 * Note:You may only use constant extra space. Recursive approach is fine,
 * implicit stack space does not count as extra space for this problem.
 */
public class PopulatingNextRightPointersinEachNodeII {
    //Runtime: 2 ms, faster than 63.20% of Java online submissions for Populating Next Right Pointers in Each Node II.
    //Memory Usage: 53.3 MB, less than 38.27% of Java online submissions for Populating Next Right Pointers in Each Node II.
    public Node connect(Node root) {
        if (root == null)
            return null;
        Queue<Node> queueone = new LinkedList<>(); // not constant extra space!
        Queue<Node> queuetwo = new LinkedList<>();
        boolean queueSwitch = true;
        queueone.offer(root);
        while (!queueone.isEmpty() || !queuetwo.isEmpty()) {
            Queue<Node> queueTake = queueSwitch ? queueone : queuetwo;
            Queue<Node> queueOffer = queueSwitch ? queuetwo : queueone;
            Node linkNode = new Node(); // queueTake is not empty
            while (!queueTake.isEmpty()) {
                linkNode.next = queueTake.poll();
                linkNode = linkNode.next;
                if (linkNode.left != null)
                    queueOffer.offer(linkNode.left);
                if (linkNode.right != null)
                    queueOffer.offer(linkNode.right);
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