package basic.structure;

public interface BinaryTree<T>{
    void putValue(T value);

    boolean hasValue(T value);

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
    }
}