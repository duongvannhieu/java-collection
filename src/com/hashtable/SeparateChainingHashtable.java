package src.com.hashtable;

import src.com.linkedList.DefaultDoublyLinkedList;
import src.com.linkedList.DoublyLinkedList;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class SeparateChainingHashtable<K, V> implements HashTableADT<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final double DEFAULT_LOAD_FACTORY = 0.5;
    private final double loadFactory;
    private int size = 0, capacity, threshold;

    public SeparateChainingHashtable(int capacity) {
        this(DEFAULT_LOAD_FACTORY, capacity);
    }

    public SeparateChainingHashtable() {
        this(DEFAULT_LOAD_FACTORY, DEFAULT_CAPACITY);
    }

    public SeparateChainingHashtable(double loadFactory, int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Capacity loi");
        if (loadFactory <= 0 || Double.isNaN(loadFactory) || Double.isInfinite(loadFactory)) {
            throw new IllegalArgumentException("Load Factory loi");
        }
        this.loadFactory = loadFactory;
        this.capacity = Math.max(DEFAULT_CAPACITY, capacity);
        this.threshold = (int) (this.capacity * loadFactory);
        table = new DefaultDoublyLinkedList[capacity];
    }

    private DoublyLinkedList<Node<K, V>>[] table;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean idEmpty() {
        return size() == 0;
    }

    @Override
    public int hashCodeToIndex(int hasKey) {
        return (int) ((hasKey & 0xFFFFFFFFFL) % capacity);
    }

    @Override
    public void clear() {
        Arrays.fill(table, null);
    }

    @Override
    public boolean hash(K key) {
        int index = hashCodeToIndex(key.hashCode());
        DoublyLinkedList<Node<K, V>> linkedList = table[index];
        if (linkedList == null || linkedList.isEmpty()) return false;
        Iterator<Node<K, V>> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Node<K, V> node = iterator.next();
            if (node.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V insert(K key, V value) {
        int index = hashCodeToIndex(key.hashCode());
        DoublyLinkedList<Node<K, V>> linkedList = table[index];
        if (linkedList == null) table[index] = linkedList = new DefaultDoublyLinkedList<>();

        Node<K, V> existedNode = null;
        Iterator<Node<K, V>> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Node<K, V> node = iterator.next();
            if (node.getKey().equals(key)) existedNode = node;
        }

        if (existedNode == null) {
            linkedList.add(new Node<>(key, value));
            if (++size > threshold) resizeTable();
            return null;
        } else {
            V oldValue = existedNode.getValue();
            existedNode.setValue(value);
            return oldValue;
        }
    }

    private void resizeTable() {
        capacity *= 2;
        threshold = (int) (this.capacity * loadFactory);
        DoublyLinkedList<Node<K, V>>[] newTable = new DefaultDoublyLinkedList[capacity];

        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) continue;

            Iterator<Node<K, V>> iterator = table[i].iterator();
            while (iterator.hasNext()) {
                Node<K, V> node = iterator.next();
                int index = hashCodeToIndex(node.getHash());
                DoublyLinkedList<Node<K, V>> linkedList = newTable[index];
                if (linkedList == null ) {
                    newTable[index] = linkedList = new DefaultDoublyLinkedList<>();
                } else {
                    linkedList.add(node);
                }
            }
            table[i].clear();
            table[i] = null;
        }
        table = newTable;
    }

    @Override
    public V get(K key) {
        int index = hashCodeToIndex(key.hashCode());
        DoublyLinkedList<Node<K, V>> linkedList = table[index];
        if (linkedList == null || linkedList.isEmpty()) return null;
        Iterator<Node<K, V>> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Node<K, V> node = iterator.next();
            if (node.getKey().equals(key)) return node.getValue();
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = hashCodeToIndex(key.hashCode());
        DoublyLinkedList<Node<K, V>> linkedList = table[index];

        if (linkedList == null || linkedList.isEmpty()) return null;
        Iterator<Node<K, V>> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            if (iterator.hasNext()) {
                linkedList.removeObject(iterator.next());
                --size;
                return iterator.next().getValue();
            }
        }
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        final int elementCount = size();

        return new Iterator<K>() {
            int index = 0;
            Iterator<Node<K, V>> bucketIterator = table[index] == null ? null : table[0].iterator();
            @Override
            public boolean hasNext() {
                if (elementCount != size()) throw new ConcurrentModificationException("Table bi doi");
                if (bucketIterator == null || !bucketIterator.hasNext()) {
                    while (++index < capacity) {
                        if (table[index] != null && !table[index].isEmpty()) {
                            bucketIterator = table[index].iterator();
                            break;
                        }
                    }
                }
                return index < capacity;
            }

            @Override
            public K next() {
                return bucketIterator.next().getKey();
            }
        };
    }
}
