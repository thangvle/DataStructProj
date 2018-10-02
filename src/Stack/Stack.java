package Stack;

public class Stack <E> {

    private Node<E> top;

    public boolean isEmpty() {
        return top == null;
    }

    public E peek() {
        return top.item;
    }

    public E pop() {
        E toReturn = top.item;
        top = top.next;
        return toReturn;
    }

    public E push (E item) {
        Node<E> newTop = new Node<E>(item);
        newTop.next = top;
        top = newTop;
        return item;
    }

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<Character>();
        for (Character c : expression.toCharArray()){
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else if ( c == ')' || c == ']' || c == '}'){
                if (stack.isEmpty()){
                    return false;
                }
                char opener = stack.pop();
                if (!((opener == '(' && c == ')') || (opener == '[' && c == ']') || (opener == '{' && c == '}'))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isPalindrome (String word) {
        Stack<Character> stack = new Stack<Character>();

        for (Character c:word.toCharArray()) {
            stack.push(c);
        }

        for (int i = 0; i < word.length(); i++) {
            char c = stack.pop();
            if (c != word.charAt(i)){
                return false;
            }

        }
        return true;
    }
    private static class Node<E> {
        E item;
        Node<E> next;

        public Node (E item ) {
            this.item = item;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        Stack<Character> characterStack = new Stack<Character>();

        System.out.println(isPalindrome("kayak"));
        System.out.println(isBalanced("()()()"));

        for (int i = 0; i <= 10; i++) {
            s.push(i);
        }

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }


    }
}
