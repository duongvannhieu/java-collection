package src.com.queue;

import java.util.Iterator;

public class CircularArrayBaseQueue<T> implements QueueADT<T>{
    private final T[] array;
    private int front;
    private int rear;
    private final int size;

    public CircularArrayBaseQueue(int maxSize) {
        front = rear = 0;
        size = maxSize + 1;
        array = (T[]) new Object[size];
    }

    @Override
    public void enQueue(T element) {
        array[rear] = element;
        if (++rear == size) rear = 0;
        if (rear == front) throw new RuntimeException("Queue empty");
    }

    @Override
    public T deQueue() {
        if (isEmpty()) throw new RuntimeException("Queue empty");
        T deQueue = array[front];
        if (++front == size) front = 0;
        return deQueue;
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue empty");
        return array[front];
    }

    @Override
    public int size() {
        if (front > rear) return (rear + size - front);
        return rear - front;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }
}
