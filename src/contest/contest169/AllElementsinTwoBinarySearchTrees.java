package contest.contest169;

import java.util.ArrayList;
import java.util.List;

public class AllElementsinTwoBinarySearchTrees {

    // some way to optmize
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();

        List<Integer> listOne = new ArrayList<>(), listTwo = new ArrayList<>();
        if (root1 != null)
            bstTreeToList(listOne, root1);
        if (root2 != null)
            bstTreeToList(listTwo, root2);
        if (listOne.isEmpty()) {
            return listTwo;
        }
        if (listTwo.isEmpty()) {
            return listOne;
        }

        int indexOne = 0, indexTwo = 0;
        for (; indexOne < listOne.size() && indexTwo < listTwo.size();) {
            if (listOne.get(indexOne) < listTwo.get(indexTwo)) {
                result.add(listOne.get(indexOne));
                indexOne++;
            } else if (listOne.get(indexOne) == listTwo.get(indexTwo)) {
                result.add(listOne.get(indexOne));
                result.add(listTwo.get(indexTwo));
                indexOne++;
                indexTwo++;
            } else {
                result.add(listTwo.get(indexTwo));
                indexTwo++;
            }
        }

        if (indexOne < listOne.size() || indexTwo < listTwo.size()) {
            int indexRemain = 0;
            List<Integer> listRemain;
            if (indexOne < listOne.size()) {
                indexRemain = indexOne;
                listRemain = listOne;
            } else {
                indexRemain = indexTwo;
                listRemain = listTwo;
            }
            for (; indexRemain < listRemain.size(); indexRemain++) {
                result.add(listRemain.get(indexRemain));
            }
        }

        return result;
    }

    private void bstTreeToList(List<Integer> list, TreeNode root) {
        if (root.left != null) {
            bstTreeToList(list, root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            bstTreeToList(list, root.right);
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}