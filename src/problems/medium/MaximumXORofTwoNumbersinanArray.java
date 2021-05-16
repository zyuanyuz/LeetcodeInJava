package problems.medium;

/**
 * leetcode 421 MaximumXORofTwoNumbersinanArray
 */

public class MaximumXORofTwoNumbersinanArray {
    /**
     * 执行用时： 41 ms , 在所有 Java 提交中击败了 67.24% 的用户 内存消耗： 46.7 MB , 在所有 Java 提交中击败了
     * 51.24% 的用户
     * 
     * @param nums
     * @return
     */
    public int findMaximumXOR(int[] nums) {
        BinaryTrie t = new BinaryTrie();
        for (int num : nums) {
            t.insert(num);
        }
        int maxResult = 0;
        for (int num : nums) {
            int result = t.findMost(num);
            maxResult = result > maxResult ? result : maxResult;
        }
        return maxResult;
    }

    private class BinaryTrie {
        private class BinaryNode {
            int currentValue;
            boolean exsit = false; // if the node is leaf node,it exsit
            BinaryNode[] subNode = new BinaryNode[2];
        }

        BinaryNode root;

        BinaryTrie() {
            root = new BinaryNode();
        }

        void insert(int num) {
            BinaryNode node = root;
            for (int k = 30; k >= 0; k--) {
                int current = (num >> k) & 1;
                if (node.subNode[current] == null) {
                    node.subNode[current] = new BinaryNode();
                    node.subNode[current].currentValue = current;
                }
                node = node.subNode[current];
            }
            node.exsit = true;
        }

        int findMost(int num) {
            BinaryNode node = root;
            int targetNum = 0;
            for (int k = 30; k >= 0; k--) {
                int current = (num >> k) & 1;
                if (current == 0 && node.subNode[1] != null) {
                    node = node.subNode[1];
                } else if (current == 1 && node.subNode[0] != null) {
                    node = node.subNode[0];
                } else if (node.subNode[0] != null) { // 找不到合适的node，证明存在有一个节点为空
                    node = node.subNode[0];
                } else {
                    node = node.subNode[1];
                }
                if (node.currentValue == 1) {
                    targetNum = targetNum | (1 << k);
                }
            }
            // System.out.println(num + "=>" + targetNum + "=" + (targetNum ^ num));
            return targetNum ^ num;
        }
    }

    public static void main(String[] args) {
        // [32,18,33,42,29,20,26,36,15,46]
        MaximumXORofTwoNumbersinanArray m = new MaximumXORofTwoNumbersinanArray();
        m.findMaximumXOR(new int[] { 32, 18, 33, 42, 29, 20, 26, 36, 15, 46 });
    }
}
