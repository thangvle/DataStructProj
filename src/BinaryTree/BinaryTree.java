package BinaryTree;

public class BinaryTree<E extends Comparable<E>> {

    private Node<E> root;
    private int size;

    public int size(){
        return this.size;
    }

    public void add(E item){
        this.root = add(this.root, item);

    }

    private Node<E> add (Node<E> root, E item) {
        if (root == null) {
            return new Node<E>(item);
        }
        int comparison = item.compareTo(root.item);

        if (comparison == 0) {
            root.left = add(root.left, item);
            return root;
        }
        else if (comparison < 0){
            root.left = add(root.left, item);
            return root;
        }
        else {
            root.right = add(root.right, item);
            return root;
        }
    }

    public void remove(E item){

    }

    public boolean contains(E item){

        return contains(this.root,item);
    }

    private boolean contains(Node<E> root, E item) {
        if (root == null) {
            return false;
        } else {
            int comparisonResult = item.compareTo(root.item);
            if (comparisonResult == 0) {
                return true;
            } else if (comparisonResult < 0) {
                return contains(root.left, item);
            } else {
                return contains(root.right, item);
            }
        }
    }

    public String toString() {
        return "Finish";
    }

    private static class Node<E extends Comparable<E>>{
        private E item;
        private Node<E> left;   //left child
        private Node<E> right;  //right child

        public Node(E item) {
            this.item = item;
        }
    }
}
