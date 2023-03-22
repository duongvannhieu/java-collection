package src.com.linkedList;

import java.util.Iterator;

public interface DoublyLinkedList<T> {

    void clear();
    int size();
    boolean isEmpty();
    void add(T element);
    void addFirst(T element);
    void addLast(T element);
    T peekFirst();
    T peekLast();
    T removeFirst();
    T removeLast();
    T remove(Node<T> node);
    boolean removeObject(Object object);
    T removeAt(int index);
    int indexOf(Object object);
    boolean contains(Object object);
    Iterator<T> iterator();

}
