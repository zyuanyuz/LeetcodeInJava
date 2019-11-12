package problems.medium;

/**
 * leetcode 138
 */

public class CopyListwithRandomPointer {
    //
    public Node copyRandomList(Node head) {
        Node moveOldNode = head, headOldNode = head;
        Node resultHeadNode = new Node(0, null, null);
        Node moveNewNode = resultHeadNode, headNewNode;
        while (moveOldNode != null) {
            moveNewNode.next = new Node(moveOldNode.val, null, null);
            moveNewNode = moveNewNode.next;
            moveOldNode = moveOldNode.next;
        }
        headNewNode = resultHeadNode.next;
        while(headOldNode!=null){
            moveOldNode = head;
            moveNewNode = resultHeadNode.next;
            while(moveOldNode!=null && moveOldNode!=headOldNode.random){
                moveOldNode = moveOldNode.next;
                moveNewNode = moveNewNode.next;
            }
            if(moveOldNode != null){
                headNewNode.random = moveNewNode;
            }
            headOldNode = headOldNode.next;
            headNewNode = headNewNode.next;
        }
        return resultHeadNode.next;
    }

    private class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };
}