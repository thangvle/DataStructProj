package hashtables;

//  hashcode return memory address, could be toString method

//Transform arbitrary key to index
//  --> use hashCode()
//  No infinite space to store giant array
//  --> use small array to grow
//  Collision strategy --> Open Addressing and Chaining

import java.util.ArrayList;
import java.util.Arrays;

public class HashTable<K,V> {
    private int size;
    private int numDeleted; // Why?
    private Entry <K, V> [] table;
    private static final double MAX_CAPA = 0.75;
    private final Entry DELETE = new Entry<>(null, null); // Why?

    public HashTable() {
        this.table = new Entry[11];
        this.size = 0;
        this.numDeleted = 0;
    }


    private int find(K key) {
        int index = key.hashCode() % table.length; //  hashCode() return a hash code value for the object.
        //  if two object are equal, calling the hash code
        if (table[index] == null || table[index].key.equals(key)) {
            return index;
        } else {
            while (table != null && table[index].key.equals(key)) {
                index = index + 1 % table.length;

            }
            return index;
        }
    }

    public V put(K key, V val) {
        int index = this.find(key);
        if (table[index] == null) {
            size++;
        }
        table[index] = new Entry(key, val);
        if ((size + numDeleted*1.0)/table.length > MAX_CAPA) {   //  if max capacity exceed
            rehash();
        }
        return val;

    }

    public V get (K key) {
        int index = find(key);
        if (table[index] == null) {
            return null;
        }
        return table[index].value;
    }

    public boolean contains (K key ) {
        int index = find(key);
        return table[index] != null;
    }

    public V delete(K key) {
        int index = find(key);
        V reval = null;
        if (table[index] != null) {
            reval = table[index].value;
            table[index] = DELETE;
            size--;
            numDeleted++;
        }
        return reval;
    }
    private void rehash() {
        Entry<K,V>[] oldTable = table;
        table = new Entry[table.length * 2 + 1];
        size = 0;

        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] == null || oldTable[i] == DELETE) {
                continue;
            }

            K key = oldTable[i].key;
            V val = oldTable[i].value;

            this.put(key,val);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(table);
    }

    public static void main(String[] args) {
        HashTable<Integer, String> hashTable = new HashTable<>();
        for (int i = 0; i < 5; i++) {
            hashTable.put(i, " " + i);
            System.out.println(hashTable);
        }
        hashTable.put(16, "16");
        hashTable.put(15, "16");
        System.out.println(hashTable);

        hashTable.delete(16);
        System.out.println(hashTable);
        System.out.println(hashTable.contains(15)); //  return true
    }
}
