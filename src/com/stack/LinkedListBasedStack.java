package src.com.stack;

import src.com.linkedList.DefaultDoublyLinkedList;
import src.com.linkedList.DoublyLinkedList;

import java.util.Iterator;

public class LinkedListBasedStack<T> implements StackADT<T>{
    DoublyLinkedList<T> doublyLinkedList = new DefaultDoublyLinkedList<>();

    public LinkedListBasedStack() {

    }

    public LinkedListBasedStack(T element) {
        doublyLinkedList.add(element);
    }

    @Override
    public void push(T element) {
        doublyLinkedList.addLast(element);
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        return doublyLinkedList.removeLast();
    }

    @Override
    public T top() {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        return doublyLinkedList.peekLast();
    }

    @Override
    public int size() {
        return doublyLinkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return doublyLinkedList.iterator();
    }
}
