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
        while (true) {
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
        if (root == null) {
            return null;
        }
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

    public List<BinaryTreeNode<T>> getAllNodes(T value) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<BinaryTreeNode<T>> list = new ArrayList<>();
        BinaryTreeNode<T> traveller = this.getFirstNode(value);
        while (true) {
            if (comparator.compare(traveller.value, value) != 0) {
                break;
            } else {
                list.add(traveller);
                traveller = traveller.right;
            }
        }
        return list;
    }

}