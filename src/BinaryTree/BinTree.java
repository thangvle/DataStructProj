package BinaryTree;

public class BinTree<E extends Comparable<E>> {

    public Node<E> root;
    //private int size;

    public BinTree() {
        this.root = null;
        //this.size = 0;
    }

    public int size() {

        return this.size(this.root);
    }


    private int size(Node<E> root) {
        if (root == null) {
            return 0;
        }

        //int mySize = 1;
        //int leftSize = size(root.left);
        //int rightSize = size(root.right);
        return 1 + size(root.left) + size(root.right);
    }


    public void add(E item) {
        this.root = add(this.root, item);

    }


    private Node<E> add(Node<E> root, E item) {
        if (root == null) {
            return new Node<E>(item);
        }
        int comparisonResult = item.compareTo(root.item);
        if (comparisonResult == 0) {
            root.left = add(root.left, item);
            return root;
        } else if (comparisonResult < 0) {
            root.left = add(root.left, item);
            return root;
        } else {
            root.right = add(root.right, item);
            return root;
        }

    }



    private void otherAdd(Node<E> root, E item) {
        int comparisonResult = item.compareTo(root.item);
        if(comparisonResult <= 0) {
            if(root.left == null){
                root.left = new Node<>(item);

            } else{
                otherAdd(root.left,item);
            }
        } else{
            if(root.right == null) {
                root.right = new Node<>(item);
            } else{
                otherAdd(root.right, item);
            }
        }

    }

    public void remove(E item) {
        this.root = remove(this.root, item);
    }

    private Node<E> remove(Node<E> root, E item) {
        if (root == null) {
            return null;
        }
        int comparisonResult = item.compareTo(root.item);
        if (comparisonResult < 0) {
            root.left = remove(root.left, item);
            return root;
        } else if (comparisonResult > 0) {
            root.right = remove(root.right, item);
            return root;
        } else {  // root is the item we want to delete

            // case 1, root is leaf
            if (root.left == null && root.right == null) {
                return null;
            } // case 2, root has only left child
            else if (root.left != null && root.right == null) {
                return root.left;
            } else if (root.left == null && root.right != null) {
                return root.right;
            } else {
                Node<E> rootOfLeftSubtree = root.left;
                Node<E> parentOfPredecessor = null;
                Node<E> predecessor = null;

                if (rootOfLeftSubtree.right == null) {
                    root.item = rootOfLeftSubtree.item;
                    root.left = rootOfLeftSubtree.left;
                    return root;
                } else {
                    parentOfPredecessor = rootOfLeftSubtree;
                    Node<E> current = rootOfLeftSubtree.right;
                    while (current.right != null) {
                        parentOfPredecessor = current;
                        current = current.right;
                    }

                    predecessor = current;
                    root.item = predecessor.item;
                    parentOfPredecessor.right = predecessor.left;
                    return root;

                }
            }

        }


    }

    public boolean contains(E item) {
        return contains(this.root, item);
    }

    private boolean contains(Node<E> root, E item) {
        if (root == null) {
            return false;
        }
        int comparisonResult = item.compareTo(root.item);
        if (comparisonResult == 0) {
            return true;
        } else if (comparisonResult < 0) {
            return contains(root.left, item);
        } else {
            return contains(root.right, item);
        }


    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }


    private String toString(Node<E> root) {
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


    public Node<E> rightRotate (Node<E> root) {
        Node<E> temp = root.left;
        root.left = temp.right;
        temp.right = root;
        root = temp;

        return temp;
    }

    private static class Node<E extends Comparable<E>> {
        private E item;
        private Node<E> left;  // left child
        private Node<E> right; // right child

        public Node(E item) {
            this.item = item;
        }


        public String toString() {
            return item.toString();
        }
    }

    public static void main(String[] args) {
        BinTree<Integer> tree = new BinTree<Integer>();
        BinTree<Integer> tree1 = new BinTree<Integer>();

        tree.add(5);
        tree.add(1);
        tree.add(0);
        tree.add(2);

        tree1.add(5);
        tree1.add(1);
        tree1.add(0);
        tree1.add(2);

        tree.remove(1);

        System.out.println(tree);

        //System.out.println(equals(tree, tree1));
    }
}

