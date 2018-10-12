package linkedList;

public class LinkedList<E> {

    private Node<E> head;
    private int size = 0;

    public int size() {
        return this.size;
    }

    public LinkedList(){
        head = null;
        size = 0;
    }



    public void trippleCut (){
        LinkedList<E> tempTop = new LinkedList<>();
        LinkedList<E> tempBot = new LinkedList<>();

        Node<E> current = this.head;
        /*
        while (current.item != 53 || current != 54) {
            tempTop.add(this.remove(0));
            current = current.next;
        }
        */
    }

    public boolean add(E item){
        this.add(size,item);
        return true;
    }

    private Node<E> getNode(int index){
        //ask about this
        Node<E> current = head;
        for (int i = 0; i < index; i++){
            current = current.next;
        }

        return null;
    }

    public String toString(){
        //ask about this part
        String output = "[";
        Node<E> current = head;
        while (current != null){
            output += current.item.toString() + "  ";
            current = current.next;
        }
        return output + "]";
    }

    public void add(int index, E item){
        //Case 1: index out of bound

        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Not valid index");
        }
        //Case 2: adding new head

        //adding to the head of the linked list
        Node<E> temp = new Node<>(item);
        if (index == 0) {
            temp.next = head;
            head = temp;
        }


        //Case 3: everything else

        //Inserting value in between the linked list

        else{
            Node<E> before = getNode(index-1);
            temp.next = before.next;
            before.next = temp;
        }
    }

    public E remove(int index){
        E toReturn = null;

        //out of bound exception
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Can't Remove That.");
        }
        //removing the head
        if (index == 0){
            toReturn = head.item;
            head = head.next;
        }

        //removing other index
        else {
            Node<E> before = getNode(index-1);
            toReturn = before.next.item;
            before.next = before.next.next; //Skipping the index to delete
        }
        size--;
        return toReturn;

    }

    private static class Node<E>{
        E item;
        Node<E> next;

        public Node(E item){
            this.item = item;
        }
    }

    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<>();
        LinkedList<Integer> tempTop = new LinkedList<>();
        LinkedList<Integer> tempMid = new LinkedList<>();
        LinkedList<Integer> tempBot = new LinkedList<>();

        l.add(0,"a");
        l.add(1,"b");
        l.add(2, "c");
        l.add(0, "d");
        l.add(2, "e");
        System.out.println(l.remove(0));
        System.out.println(l);
        System.out.println(l.remove(0));
        System.out.println(l);
    }
}
