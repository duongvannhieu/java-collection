package src.com.stack;

import src.com.arrays.DynamicArray;

import java.util.Iterator;

public class ArrayBasedStack<T> implements StackADT<T>{
    private DynamicArray<T> dynamicArray;
    private int index = -1;

    public ArrayBasedStack(int initSize) {
        dynamicArray = new DynamicArray<>(initSize);
    }
    @Override
    public void push(T element) {
        index++;
        dynamicArray.add(element);
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack empty");
        return dynamicArray.removeWithoutMoving(index--);
    }

    @Override
    public T top() {
        return dynamicArray.get(index);
    }

    @Override
    public int size() {
        return dynamicArray.size();
    }

    @Override
    public boolean isEmpty() {
        return dynamicArray.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return dynamicArray.iterator();
    }
}
