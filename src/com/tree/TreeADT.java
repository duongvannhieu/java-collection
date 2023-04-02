package src.com.tree;

import java.util.Iterator;

public interface TreeADT<T extends Comparable<T>> {
    boolean isEmpty();
    int size();
    int height();
    boolean contains(T element);
    boolean add(T element);
    boolean remove(T element);
    Iterator<T> traverse(TreeIteratorType treeIteratorType);
}
