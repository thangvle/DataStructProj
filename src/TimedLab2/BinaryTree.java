package TimedLab2;

// This is identical to the BinaryTree from class
// but you have some methods to fill out
public class BinaryTree<E extends Comparable<E>> {
    private Node<E> root;

    public BinaryTree() {
        this.root = null;
        //this.size = 0;
    }
    ////////////
    // Problems begin here!
    // Complete the method bodies where directed.
    // you don't have to write new methods or change the method signature
    ///////////


    // Problem Tree 1
    // 25 points
    // finish this method, printSortedTree
    // It will print out all the items stored in the tree
    // it will print them all out in sorted order.

    // The recursive method that prints out the items in the tree
    // or subtree that starts at root.
    // Remember,  the local variable root here is not necessarily THE root of the whole tree


    public static  <E extends  Comparable<E>> void printSortedTree(Node<E> root) {
        //  TODO start with root
        //  TODO compare value
        //  TODO print value


        if (root == null) {
            return;
        }

        printSortedTree(root.left);

        System.out.println(root.item + " ");

        printSortedTree(root.right);
    }



    // Problem Tree 2
    // 25 points
    // finish this method, which counts the number of Strings in the tree
    // which begin with the string prefix
    // Strings have a .startsWith(String) method to make this easy

    // it's a recursive like above
    // you return an int here, so you don't need to print anything out
    public static int countStrings(Node<String> root, String prefix) {
        //  TODO initiate count
        //  TODO compare root.item to prefix
        //  TODO count the string

        //  Base Case: count stop
        int count = 0;

        if (!root.toString().startsWith(prefix)) {
            return count;
        }
        if (root.toString().startsWith(prefix)){
            count = countStrings(root, prefix) + 1;
        }

       return count; // replace this
    }










    /////////////////////
    public int size() {

        return this.size(this.root);
    }


    private int size(Node<E> root) {
        if(root == null) {
            return 0;
        }

        //int mySize = 1;
       //int leftSize = size(root.left);
        //int rightSize = size(root.right);
        return 1 + size(root.left)+ size(root.right);
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
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        BinaryTree<String>  treeString = new BinaryTree<>();

        tree.add(1);
        tree.add(10);
        tree.add(3);
        tree.add(4);
        tree.add(7);

        treeString.add("doom");
        treeString.add("dot");
        treeString.add("toi");
        printSortedTree(tree.root);
        countStrings(treeString.root,"d");

    }

}
