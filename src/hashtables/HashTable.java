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

    public V get(K key) {

        return null;
    }

    public boolean contains(K key) {
        return false;
    }

    public V delete(K key) {
        return null;
    }

    private int find(K key) {
        // Find return the index
        return -1;
    }

    private void rehash(){

    }
}
