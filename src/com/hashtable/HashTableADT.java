package src.com.hashtable;

public interface HashTableADT<K, V> extends Iterable<K>{
    int size();
    boolean idEmpty();
    // hash code
    int hashCodeToIndex(int hashKey);
    void clear();
    boolean hash(K key);
    V insert(K key, V value);
    V get(K key);
    V remove(K key);
}
