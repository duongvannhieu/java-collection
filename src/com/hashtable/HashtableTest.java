package src.com.hashtable;

import java.util.Random;

public class HashtableTest {
    static final int NUMBER_OF_KEY = 1000000;
    static final int MOD = 1000000;
    static int[] keys = new int[NUMBER_OF_KEY];
    static int[] values = new int[NUMBER_OF_KEY];
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < keys.length; i++) {
            keys[i] = random.nextInt() % MOD;
            values[i] = random.nextInt() % MOD;
        }
        testSeparateChaining();
    }

    private static void testSeparateChaining() {
        HashTableADT<Integer, Integer> hashTable = new SeparateChainingHashtable<>(NUMBER_OF_KEY);
        long start = System.nanoTime();
        for (int i = 0; i < NUMBER_OF_KEY; i++) {
            hashTable.insert(keys[i], values[i]);
            int value = hashTable.get(keys[i]);
            if (value != values[i]) System.out.println("Code tam bay");
        }
        long end = System.nanoTime();
        System.out.println("Separate chaining: " + (end - start) / 1e9);
    }
}
