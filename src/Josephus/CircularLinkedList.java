
package Josephus;



import java.util.Iterator;
import java.util.LinkedList;
import java.util.*;

public class CircularLinkedList <E> implements Iterable<E> {

    // Your variables
    Node<E> head;
    Node<E> tail;
    int size;
    // BE SURE TO KEEP TRACK OF THE SIZE
    // implement this constructor


    @Override
    public Iterator<E> iterator() {
        return null;
    }

    public static <E> void josephus(LinkedList<E> list, int index){

    }

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
        this.tail.next = null;
        size = 0;
    }
    // I highly recommend using this helper method
    // Return Node<E> found at the specified index
    // be sure to handle out of bounds cases
    private Node<E> getNode(int index ) {

        Node<E> current = head;
        for (int i = 0; i < index; i++){
            current = current.next;
        }

        return null;
    }
    // attach a node to the end of the list
    public boolean add(E item) {
        this.add(size,item);
        return false;
    }
    // Cases to handle
    // out of bounds
    // adding to empty list
    // adding to front
    // adding to "end"
    // adding anywhere else
    // REMEMBER TO INCREMENT THE SIZE
    public void add(int index, E item){
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
        // Case: Adding new tail
        else if (index == size) {
            temp.prev = tail;
            tail.next = temp;
            tail = temp;


            System.out.println(temp.next);
        }

        //Everything else
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
            tail.next = null;
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

    private static class Node<E> {
        private E item;
        private Node<E> next;
        private Node<E> prev;

        public Node(E item){
            this.item = item;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>();
        l.add(0,4);
        l.add(0,3);
        l.add(0,1);
        l.add(2,2);
        System.out.println(l.remove(0));
        System.out.println(l);


    }

}

