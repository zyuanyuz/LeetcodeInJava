package basic.structure;

import java.util.Comparator;

public class AVLTree<T> extends BinarySearchTree<T> {

    public AVLTree(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    public void putNode(BinaryTreeNode<T> node) {
        if(!(node instanceof AVLTreeNode)){
            return;
        }
        super.putNode(node);
        //TODO check balance and fix it
    }

    @Override
    public void deleteValue(T value) {
        super.deleteValue(value);
        //TODO check balance and fix it
    }

    public static class AVLTreeNode<T> extends BinaryTreeNode<T>{
        
        public int height;

        public AVLTreeNode(BinaryTreeNode<T> left, BinaryTreeNode<T> right, T value,int height) {
            super(left, right, value);
            this.height = height;
        }
        
    }
}
