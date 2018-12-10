package TimedLab3;



import java.util.Hashtable;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class TimedLab3 {

    public static <E> void removeDuplicates(LinkedList<E> list) {
        HashSet<E> discovered = new HashSet<>();

        for (E item : list) {
            if (list.contains(item)) {
                discovered.add(item);

            }
        }

        System.out.print("Original " + list);
        System.out.println();
        System.out.print("Removed " + discovered);
        System.out.println();
    }
    /* Create a method that, given the root of a binary search tree,
     *  finds the smallest item in the tree that is larger than the root.
     *
     *  My solution wasn't recursive
     *
     *  25 points
     */
    public static <E> E smallestLarger(TreeNode root){

        /*
        if (root == null){
            return null;
        }


        */


        return null;
    }
    /* Write a method that determines if the given root of a tree or
    subtree
    *  is a binary search tree
    *
    *
    *  You will need to use .compareTo() on the items.
    *
    *  25 points
    */
    public static <E> boolean isBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        int compareLeft = root.item.compareTo(root.left.item);
        int compareRight = root.item.compareTo(root.right.item);


        if (compareLeft < 0){
            return true;

        } else if (compareLeft > 0) {
            return false;
        }

        else if (compareRight > 0){
            return true;
        }
        else {
            return false;
        }


    }
    // useful for writing your trees
    private static class TreeNode<T extends Comparable <T>> {
        T item;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T item) {
            this.item = item;
        }

    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(4);
        removeDuplicates(list);

        TreeNode<Integer> tree = new TreeNode<Integer>(0);
        tree.left = new TreeNode<Integer>(10);
        tree.right = new TreeNode<Integer>(1);


        System.out.println(isBST(tree));




    }
}
