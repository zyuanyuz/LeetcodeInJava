package contest.contest177;

import java.util.HashSet;
import java.util.Set;

public class ValidateBinaryTreeNodes {

    /**
     * 执行用时 : 21 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗 : 42.4 MB , 在所有 Java 提交中击败了
     * 100.00% 的用户
     * 
     * @param n
     * @param leftChild
     * @param rightChild
     * @return
     */
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> candicateRoot = new HashSet<>();
        Set<Integer> notDoubleChild = new HashSet<>();
        for (int i = 0; i < n; i++) {
            candicateRoot.add(i);
        }
        for (int i = 0; i < n; i++) {
            if (notDoubleChild.contains(leftChild[i]) || notDoubleChild.contains(rightChild[i])) {
                return false;
            } else {
                if (leftChild[i] != -1)
                    notDoubleChild.add(leftChild[i]);
                if (rightChild[i] != -1)
                    notDoubleChild.add(rightChild[i]);
            }
            candicateRoot.remove(leftChild[i]);
            candicateRoot.remove(rightChild[i]);
        }
        if (candicateRoot.size() > 1 || candicateRoot.isEmpty())
            return false;
        int rootIndex = -1;
        for (int index : candicateRoot) {
            rootIndex = index;
        }

        boolean[] isReach = new boolean[n];
        valide(isReach, leftChild, rightChild, rootIndex);
        for (boolean reach : isReach) {
            if (!reach)
                return false;
        }
        return true;
    }

    public void valide(boolean[] isReach, int[] leftChild, int[] rightChild, int index) {
        isReach[index] = true;
        if (leftChild[index] != -1 && !isReach[leftChild[index]])
            valide(isReach, leftChild, rightChild, leftChild[index]);
        if (rightChild[index] != -1 && !isReach[rightChild[index]])
            valide(isReach, leftChild, rightChild, rightChild[index]);
    }

    public static void main(String[] args) {
        ValidateBinaryTreeNodes v = new ValidateBinaryTreeNodes();
        System.out.println(v.validateBinaryTreeNodes(4, new int[] { 1, -1, 3, -1 }, new int[] { 2, -1, -1, -1 }));
    }
}