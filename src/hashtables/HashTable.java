package hashtables;

//Transform arbitrary key to index
//  --> use hashCode()
//  No infinite space to store giant array
//  --> use small array to grow
//  Collision strategy --> Open Addressing and Chaining

public class HashTable<K,V> {
    private int size;
    private Entry[] table;
    private static final double MAX_CAPA = 0.75;

    public HashTable(){
        this.table = new Entry[11];
        this.size = 0;
    }

}
