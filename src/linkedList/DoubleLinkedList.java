package linkedList;

public class DoubleLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoubleLinkedList(){
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public boolean add(E item){
        add(size, item);
        return true;

    }

    public void add(int index, E item) {
        //Case 1: out of bound
        if (index<0 || index >= size){
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node<E> temp = new Node<>(item);

        //Case: Adding very first item
        if (size == 0) {
            this.head = temp;
            this.tail = temp;
        }
        //Case 2: adding new head
        else if (index == 0) {
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
        //Case 3: adding new tail
        else if (index == size) {
            temp.prev = tail;
            tail.next = temp;
            tail = temp;
        }
        //Case 4: Other case


        else {
            Node<E> before = this.getNode(index-1);
            temp.next = before.next;
            temp.prev = before;
            before.next = temp;
            temp.next.prev = temp;

        }


        size++;
    }

    public E remove(int index){
        E removed = null;

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Error");
        }

        if (size == 1) {
            removed = head.item;
            head = null;
            tail = null;
        }

        else if (index == 0){
            removed = head.item;
            head = head.next;
            head.prev = null;
        }

        else if (index == size -1 ) {
            removed = tail.item;
            tail = tail.prev;
        }

        else {
            Node<E> before = getNode(index-1);
            removed = before.next.item;
            before.next = before.next.next;
            before.next.prev = before;
        }

        size--;
        return removed;

    }

    public String toString() {
        //ask about this part
        String output = "[";
        Node<E> current = head;
        while (current != null){
            output += current.item.toString() + "  ";
            current = current.next;
        }
        return output + "]";
    }

    private Node<E> getNode(int index){
        //ask about this
        Node<E> current = head;
        for (int i = 0; i < index; i++){
            current = current.next;
        }

        return null;
    }

    private static class Node<E> {
        private E item;
        private Node<E> next;
        private Node<E> prev;

        public Node(E item){
            this.item = item;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList<String> l = new DoubleLinkedList<>();
        l.add("a");
        l.add("b");
        l.add("c");
        l.add(0, "d");
        l.add(1,"e");
        System.out.println(l.remove(1));
        System.out.println(l.remove(0));
        System.out.println(l.remove(0));
        System.out.println(l);
    }

}
