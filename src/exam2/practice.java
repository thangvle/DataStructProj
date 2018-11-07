package exam2;

import java.util.HashMap;
import java.util.Map;

public class practice {
    public static int sizeTree(Node<E> root){
        if (root == null){
            return 0;
        }

        return 1 + sizeTree(root.left) + sizeTree(root.right);
    }

    public static <E> boolean isFull(Node<E> tree){
        if (tree == null) {
            return true;
        }

        if (tree.left == null && tree.right == null) {
            return true;
        }

        if (tree.left != null && tree.right == null) {
            return false;
        }
        if (tree.left == null && tree.right == null) {
            return false;
        }

        return isFull(tree.left ) && isFull(tree.right);
    }

    public static Map <Character, Integer> count(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (char letter : word.toCharArray()){
            /**
            if (map.containsKey(letter)) {
                int occurances = map.get(letter);
                map.put(letter, occurances + 1);
            }
            else {
                map.put(letter,1);
            }
             **/
            if (!map.containsKey(letter)) {
                map.put(letter, 0);
            }
            map.put(letter, map.get(letter) + 1);
        }
    }
}
