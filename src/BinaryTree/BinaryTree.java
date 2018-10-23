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
        this.root = remove(this.root, item);
    }

    private Node<E> remove(Node<E> root, E item) {
        if (root == null){
            return null;
        }

        int comparison = item.compareTo(root.item);
        if (comparison < 0) {
            root.left = remove(root.left, item);
            return root;
        }
        else if (comparison > 0) {
            root.right = remove(root.right, item);
            return root;
        }
        else {

            //  Case: Root is leaf
            if (root.left == null && root.right == null){
                return null;
            }

            //  Case: Root has only left child
            else if (root.left != null && root.right == null) {
                return root.left;
            }

            else if (root.left == null && root.right != null) {
                return root.right;
            }
            else {
                Node<E> rootOfLeft = root.left;
                Node<E> predecessor = null;
                Node<E> parentsPredecessor = null;

                if (rootOfLeft.right == null) {
                    root.item = rootOfLeft.item;
                    root.left = rootOfLeft.left;
                    return root;
                } else {
                    parentsPredecessor = rootOfLeft;
                    Node<E> current = rootOfLeft;

                    while (current.right != null) {
                        parentsPredecessor = current;
                        current = current.right;
                    }

                    predecessor = current;
                    root.item = predecessor.item;
                    parentsPredecessor.right = predecessor.left;
                    return root;
                }

            }


        }


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

    public String toString(Node<E> root) {

        if (root == null) {
            return "";
        }
        String output = "";

        output += root.item + " ";
        output += toString(root.left);

        output += toString(root.right);
        return output;
    }

    private void preOrderTraverse(Node<E> root, int depth, StringBuilder sb) {
        for (int i = 1; i < depth; i++) {
            sb.append("  "); // indentation
        }
        if (root == null) {
            sb.append("null\n");
        } else {
            sb.append(root.toString());
            sb.append("\n");
            preOrderTraverse(root.left, depth + 1, sb);
            preOrderTraverse(root.right, depth + 1, sb);
        }
    }

    private static class Node<E extends Comparable<E>>{
        private E item;
        private Node<E> left;   //left child
        private Node<E> right;  //right child

        public Node(E item) {
            this.item = item;
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.add(5);
        tree.add(1);
        tree.add(0);
        tree.add(2);
        tree.add(3);
        tree.add(12);
        tree.add(7);
        tree.add(15);
        tree.add(14);
        tree.add(20);

        System.out.println(tree);
    }
}
