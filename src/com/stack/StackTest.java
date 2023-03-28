package src.com.stack;

public class StackTest {
    public static void main(String[] args) {
        int numberOfOperations = 10000000;

        StackADT<Integer> stackArray = new ArrayBasedStack<>(numberOfOperations);

        long startTime = System.nanoTime();
        for (int i = 0; i < numberOfOperations; i++) {
            stackArray.push(i);
        }
        for (int i = 0; i < numberOfOperations; i++) {
            stackArray.pop();
        }
        long endTime = System.nanoTime();
        long timeArrayStack = endTime - startTime;

        StackADT<Integer> stackLinkedList = new LinkedListBasedStack<>();

        startTime = System.nanoTime();
        for (int i = 0; i < numberOfOperations; i++) {
            stackLinkedList.push(i);
        }
        for (int i = 0; i < numberOfOperations; i++) {
            stackLinkedList.pop();
        }
        endTime = System.nanoTime();
        long timeStackLinkedList = endTime - startTime;

        System.out.println("Stack array based took: " + timeArrayStack);
        System.out.println("Linked list based took: " + timeStackLinkedList);
    }
}
