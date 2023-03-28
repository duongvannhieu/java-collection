package src.com.queue;

public class QueueTest {
    public static void main(String[] args) {
        int numberOfOperations = 10000000;
        QueueADT<Integer> circularArrayBaseQueue = new CircularArrayBaseQueue<>(numberOfOperations);

        long startTime = System.nanoTime();
        for (int i = 0; i < numberOfOperations; i++) {
            circularArrayBaseQueue.enQueue(i);
        }
        for (int i = 0; i < numberOfOperations / 2; i++) {
            circularArrayBaseQueue.deQueue();
        }
        for (int i = 0; i < numberOfOperations / 4; i++) {
            circularArrayBaseQueue.enQueue(i);
        }
        for (int i = 0; i < numberOfOperations / 4; i++) {
            circularArrayBaseQueue.deQueue();
        }
        long endTime = System.nanoTime();
        long arrayTime = endTime - startTime;

        QueueADT<Integer> linkedListBasedQueue = new LinkedListBasedQueue<>();

        startTime = System.nanoTime();
        for (int i = 0; i < numberOfOperations; i++) {
            linkedListBasedQueue.enQueue(i);
        }
        for (int i = 0; i < numberOfOperations; i++) {
            linkedListBasedQueue.deQueue();
        }
        endTime = System.nanoTime();
        long linkedListTime = endTime - startTime;
        System.out.println("Circular array based queue took: " + arrayTime);
        System.out.println("Linked list bases stack took: " + linkedListTime);

        System.out.println("The difference: " + (linkedListTime - arrayTime));
    }
}
