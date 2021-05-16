package problems.medium;

/**
 * leetcode 208 ImplementTriePrefixTree Medium
 */
public class ImplementTriePrefixTree {
    /**
     * 执行用时： 42 ms , 在所有 Java 提交中击败了 63.11% 的用户 内存消耗： 54.5 MB , 在所有 Java 提交中击败了
     * 5.25% 的用户
     */
    private class Trie {
        private class Node {
            String prefixBuilder;
            boolean exsit = false;
            Node[] subNode = new Node[26];
        }

        Node root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new Node();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node pNode = root;
            StringBuilder currentPrefix = new StringBuilder();
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                currentPrefix.append(c);
                if (pNode.subNode[index] == null) {
                    pNode.subNode[index] = new Node();
                    pNode.subNode[index].prefixBuilder = currentPrefix.toString();
                }
                pNode = pNode.subNode[index];
            }
            pNode.exsit = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node fNode = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (fNode.subNode[index] == null) {
                    return false;
                }
                fNode = fNode.subNode[index];
            }
            if (fNode.exsit) {
                return true;
            }
            return false;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Node fNode = root;
            for (char c : prefix.toCharArray()) {
                int index = c - 'a';
                if (fNode.subNode[index] == null) {
                    return false;
                }
                fNode = fNode.subNode[index];
            }
            return true;
        }
    }

    /**
     * Your Trie object will be instantiated and called as such: Trie obj = new
     * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
     * = obj.startsWith(prefix);
     */
}
