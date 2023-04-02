package src.com.tree;

import java.util.Iterator;

public class TreeTest {
    public static void main(String[] args) {
        TreeADT<Integer> treeADT = new BinarySearchTree<>();
        treeADT.add(5);
        treeADT.add(4);
        treeADT.add(6);
        treeADT.add(7);
        treeADT.add(3);
        treeADT.add(2);
        treeADT.add(10);

        Iterator iterator = treeADT.traverse(TreeIteratorType.IN_ORDER);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("Tree height " + treeADT.height());
        System.out.println(treeADT.contains(10));
    }
}
