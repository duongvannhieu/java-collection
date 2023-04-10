package src.com.hashtable;

public class Node<K, V> {
    private int hash;
    private K key;
    private V value;

    public Node(K key, V value) {
        this.hash = key.hashCode();
        this.key = key;
        this.value = value;
    }

    public boolean equal(Node<K, V> other) {
        if (other.hash != hash) return false;
        return key.equals(other.key);
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public int getHash() {
        return hash;
    }

    @Override
    public String toString() {
        return "key=" + key + ", value=" + value;
    }
}
