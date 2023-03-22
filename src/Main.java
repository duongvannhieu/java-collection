package src;

import src.com.arrays.DynamicArray;
import src.com.linkedList.DefaultDoublyLinkedList;

public class Main {
    public static void main(String[] args) {
//        test array
        /**
        DynamicArray<String> dynamicArray = new DynamicArray<>();
        dynamicArray.add("d");
        dynamicArray.add("u");
        dynamicArray.add("o");
        dynamicArray.add("n");
        dynamicArray.add("g");
        dynamicArray.add("n");
        dynamicArray.add("h");
        dynamicArray.add("i");
        dynamicArray.add("e");
        dynamicArray.add("u");

        System.out.println(dynamicArray.toString());
         **/

        DefaultDoublyLinkedList<String> doublyLinkedList = new DefaultDoublyLinkedList<>();
        doublyLinkedList.add("Duong");
        doublyLinkedList.add("Van");
        doublyLinkedList.add("Nhieu");
        System.out.println(doublyLinkedList.toString());
        doublyLinkedList.addFirst("2k2");
        doublyLinkedList.addLast("cute");
        System.out.println(doublyLinkedList.toString());
    }
}
