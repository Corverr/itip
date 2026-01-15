import java.util.LinkedList;

public class HashTable<K,V>{


    private static class Entry <K, V> {
        private K key;
        private V value;


    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
    }


    private LinkedList<Entry<K,V>>[] linkedList;
    private int size;

    public HashTable(int capacity) {
        linkedList = new LinkedList[capacity];
        size=0;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return linkedList.length;
    }



    private int hash(K key) {
        return Math.abs(key.hashCode()) % linkedList.length;
    }

    public void put(K key, V value) {
        int index = hash(key);

        if (linkedList[index]== null) {
            linkedList[index]= new LinkedList<>();
        }

        for (Entry<K, V> entry : linkedList[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        linkedList[index].add(new Entry<>(key,value));
        size++;
    }


    public V get(K key) {
        int index = hash(key);

        if (linkedList[index] != null) {
            for (Entry<K,V> entry : linkedList[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }


    public void remove(K key){
        int index= hash(key);

        if (linkedList[index] != null) {
            for (Entry<K,V> entry : linkedList[index]) {
                if (entry.getKey().equals(key)) {
                    linkedList[index].remove(entry);
                    size--;
                    return;
                }
            }
        }
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }
}
