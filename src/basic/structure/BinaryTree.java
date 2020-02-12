package basic.structure;

import java.util.List;

public interface BinaryTree<T> {
    void putValue(T value);

    boolean hasValue(T value);

    void deleteValue(T value);

    List<BinaryTreeNode<T>> preOrderTreeList();

    List<BinaryTreeNode<T>> inOrderTreeList();

    List<BinaryTreeNode<T>> postOrdertreeList();
 
    public static class BinaryTreeNode<T> {

        public BinaryTreeNode<T> left;
        public BinaryTreeNode<T> right;
        public T value;

        public BinaryTreeNode(T value) {
            this(null, null, value);
        }

        public BinaryTreeNode(BinaryTreeNode<T> left, BinaryTreeNode<T> right, T value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        @Override
        public String toString(){
            return this.value==null?null:this.value.toString();
        }
    }
}