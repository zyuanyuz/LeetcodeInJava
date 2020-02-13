package basic.structure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinarySearchTree<T> implements BinaryTree<T> {

    BinaryTreeNode<T> root;

    Comparator<T> comparator = (o1, o2) -> 0;

    public BinarySearchTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void putValue(T value) {
        this.putNode(new BinaryTreeNode<>(value));
    }

    @Override
    public boolean hasValue(T value) {
        return this.getFirstNode(value) != null;
    }

    public void putNode(BinaryTreeNode<T> node) {
        if (root == null) {
            root = node;
            return;
        }
        BinaryTreeNode<T> traveller = root;
        while (traveller != null) {
            if (comparator.compare(traveller.value, node.value) > 0) {
                if (traveller.left == null) {
                    traveller.left = node;
                    return;
                }
                traveller = traveller.left;
            } else if (comparator.compare(traveller.value, node.value) <= 0) {
                if (traveller.right == null) {
                    traveller.right = node;
                    return;
                }
                traveller = traveller.right;
            }
        }
    }

    public BinaryTreeNode<T> getFirstNode(T value) {
        BinaryTreeNode<T> traveller = root;
        while (traveller != null) {
            if (comparator.compare(traveller.value, value) > 0) {
                traveller = traveller.left;
            } else if (comparator.compare(traveller.value, value) < 0) {
                traveller = traveller.right;
            } else {
                return traveller;
            }
        }
        return null;
    }

    // TODO delete value
    @Override
    public void deleteValue(T value) {
        if (root == null) {
            return;
        }
        if (comparator.compare(root.value, value) == 0) {
            BinaryTreeNode<T> oldRoot = root;
            this.root = getMinNodeInNodeRightSubTree(oldRoot);
            root.right = oldRoot.right;

        }
        BinaryTreeNode<T> traveller = root;
        while (true) {
            if (traveller.left == null && traveller.right == null) {
                return;
            }
            if (traveller.left != null && comparator.compare(traveller.value, value) > 0) {

            } else if (traveller.right != null) {

            }

        }

    }

    public BinaryTreeNode<T> getMinNodeInNodeRightSubTree(BinaryTreeNode<T> node) {
        if (node == null || node.right == null) {
            return null;
        }
        BinaryTreeNode<T> traveller = node.right, travellerParent = node;
        while (traveller.left != null) {
            travellerParent = traveller;
            traveller = traveller.left;
        }
        if (traveller.right != null) {
            travellerParent.left = traveller.right;
            traveller.right = null;
        }
        return traveller;
    }

    /**
     * Morris
     */
    @Override
    public List<BinaryTreeNode<T>> preOrderTreeList() {
        List<BinaryTreeNode<T>> list = new ArrayList<>();
        BinaryTreeNode<T> node = root, prev = null;
        while (node != null) {
            list.add(node);
            if (node.left == null) {
                node = node.right;
            } else {
                prev = node.left;
                while (prev.right != null && prev.right != node)
                    prev = prev.right;
                if (prev.right == null) {
                    prev.right = node;
                    node = node.left;
                } else {
                    node = node.right;
                    prev.right = null;
                }
            }
        }
        return list;
    }

    @Override
    public List<BinaryTreeNode<T>> inOrderTreeList() {
        List<BinaryTreeNode<T>> list = new ArrayList<>();
        BinaryTreeNode<T> node = root, prev = null;
        while (node != null) {
            if (node.left == null) {
                list.add(node);
                node = node.right;
            } else {
                prev = node.left;
                while (prev.right != null && prev.right != node)
                    prev = prev.right;
                if (prev.right == null) {
                    prev.right = node;
                    node = node.left;
                } else {
                    list.add(prev);
                    prev.right = null;
                    node = node.right;
                }
            }
        }
        return list;
    }

    @Override
    public List<BinaryTreeNode<T>> postOrdertreeList() {
        List<BinaryTreeNode<T>> list = new ArrayList<>();
        BinaryTreeNode<T> node = root, prev = null;
        while (node != null) {
            if (node.left == null) {
                node = node.right;
            } else {
                prev = node.left;
                while (prev.right != null && prev.right != node)
                    prev = prev.right;
                if (prev.right == null) {
                    prev.right = node;
                    node = node.left;
                } else {
                    list.add(prev);
                    prev.right = null;
                    node = node.right;
                }
            }
        }
        return list;
    }

}