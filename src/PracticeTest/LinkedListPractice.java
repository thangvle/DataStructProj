package PracticeTest;

import linkedList.DoubleLinkedList;
import linkedList.LinkedList;

import java.util.List;

public class LinkedListPractice<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public int size(){
        return this.size;
    }

    public LinkedListPractice() {
        this.head = null;
        this.tail = null;
        size = 0;
    }
    public boolean add(E item){
        this.add(size,item);
        return true;
    }

    public void add(int index, E item){
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

    private Node<E> getNode(int index){
        //ask about this
        Node<E> current = head;
        for (int i = 0; i < index; i++){
            current = current.next;
        }

        return null;
    }

    public void deleteList(){
        while(this.size() > 0) {
            this.remove(0);
        }

    }

    public static <E> int count (E item) {
        int count = 0;

        Node<E> current = new Node<>(item);

        while (current != null) {
            if (item.equals(current.item)){
                count++;

            }
            current = current.next;
        }

        return count;
    }

    public static DoubleLinkedList<Integer> merge (DoubleLinkedList<Integer> listA, DoubleLinkedList<Integer> listB) {

        return null;
    }

    private static class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item){
            this.item = item;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>();

        l.add(1);
        l.add(4);
        l.add(3);
        l.add(2);
        l.add(1);

        System.out.println(count(l));

    }
}
