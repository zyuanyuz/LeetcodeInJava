package problems.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P35 {

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 27.09% 的用户 内存消耗 : 40.6 MB , 在所有 Java 提交中击败了
     * 100.00% 的用户
     */
    public Node copyRandomList(Node head) {
        HashMap<Node, Integer> randomNodeMap = new HashMap<>();
        List<Node> nodeList = new ArrayList<>();

        Node travelNode = head;
        int index = 0;
        while (travelNode != null) {
            nodeList.add(travelNode);
            randomNodeMap.put(travelNode, index++);
            travelNode = travelNode.next;
        }

        List<Node> resultList = new ArrayList<>(nodeList.size());
        for (int i = 0; i < nodeList.size(); i++) {
            resultList.add(new Node(-1));
        }
        for (int i = 0; i < nodeList.size(); i++) {
            resultList.get(i).val = nodeList.get(i).val;
            if (nodeList.get(i).random != null)
                resultList.get(i).random = resultList.get(randomNodeMap.get(nodeList.get(i).random));
            if (i > 0)
                resultList.get(i - 1).next = resultList.get(i);
        }

        return resultList.size() > 0 ? resultList.get(0) : null;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        P35 p = new P35();

    }
}