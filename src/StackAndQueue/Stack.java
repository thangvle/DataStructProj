package StackAndQueue;

public class Stack<E> {
    private Node<E> top;

    public boolean isEmpty(){
        return top == null;
    }

    public E peek() {
        return top.item;
    }

    public E pop() {
        E toReturn = top.item;
        return toReturn;
    }

    public E push() {
        return null;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
    }
}
