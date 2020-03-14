package problems.offer;

import java.util.ArrayList;
import java.util.List;

public class P68I {

    /**
     * 执行用时 : 8 ms , 在所有 Java 提交中击败了 37.01% 的用户 内存消耗 : 41.3 MB , 在所有 Java 提交中击败了
     * 100.00% 的用户
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pList = new ArrayList<>(), qList = new ArrayList<>();

        travelBSTWithNode(pList, root, p);
        travelBSTWithNode(qList, root, q);

        for (int i = 0; i < pList.size(); i++) {
            if (qList.contains(pList.get(i))) {
                return pList.get(i);
            }
        }
        return null;
    }

    boolean travelBSTWithNode(List<TreeNode> list, TreeNode node, TreeNode n) {
        if ((node == n) || (node.val > n.val && node.left != null && travelBSTWithNode(list, node.left, n))
                || (node.val < n.val && node.right != null && travelBSTWithNode(list, node.right, n))) {
            list.add(node);
            return true;
        }
        return false;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        P68I p = new P68I();
        //TreeNode root = new 
    }
}