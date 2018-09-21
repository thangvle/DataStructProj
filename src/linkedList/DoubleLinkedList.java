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
        return false;

    }

    public void add(int index, E item) {
        //Case 1: out of bound
        if (index<0 || index > size){
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node<E> temp = new Node<>(item);

        //Case: Adding very first item
        if (size == 0) {

        }
        //Case 2: adding new head
        //Case 3: adding new tail

        //Case 4: Other case

        //

        size++;
    }

    private static class Node<E> {
        private E item;
        private Node<E> next;
        private Node<E> prev;

        public Node(E item){
            this.item = item;
        }
    }

}
