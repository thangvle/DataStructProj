package Josephus;

public class CircularLinkedList implements Iterable<E> {

    // Your variables
    Node<E> head;
    Node<E> tail;
    int size;  // BE SURE TO KEEP TRACK OF THE SIZE
    // implement this constructor
    public CircularLinkedList() {
    }
    // I highly recommend using this helper method
// Return Node<E> found at the specified index
// be sure to handle out of bounds cases
    private Node<E> getNode(int index ) {
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
    }
// remove must handle the following cases
// out of bounds
// removing the only thing in the list


}
