package problems.offer;

public class P36 {
    /**
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗 : 39.6 MB , 在所有 Java 提交中击败了
     * 100.00% 的用户
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node head = new Node();
        build(head, root);
        Node moveNode = head;
        while (moveNode.right != null) {
            moveNode = moveNode.right;
        }
        moveNode.right = head.right;
        head.right.left = moveNode;
        return head.right;
    }

    private Node build(Node preListNode, Node nowNode) {
        if (nowNode.left != null) {
            preListNode = build(preListNode, nowNode.left);
        }
        nowNode.left = preListNode;
        preListNode.right = nowNode;
        preListNode = nowNode;
        if (nowNode.right != null) {
            preListNode = build(nowNode, nowNode.right);
        }
        return preListNode;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}