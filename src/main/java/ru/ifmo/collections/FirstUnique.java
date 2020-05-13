package ru.ifmo.collections;

import java.util.*;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {
    // Since we are only inserting into stream we can skip counting and use set
    private final Set<Integer> uniqueNumbers = new LinkedHashSet<>();
    private final Set<Integer> seenNumbers = new HashSet<>();

    public FirstUnique(int[] numbers) {
        for (int number : numbers) {
            insertIfUnique(number);
            seenNumbers.add(number);
        }
    }

    public int showFirstUnique() {
        var iterator = uniqueNumbers.iterator();
        if (iterator.hasNext()) return iterator.next();
        else return -1;
    }

    public void add(int value) {
        insertIfUnique(value);
        seenNumbers.add(value);
    }

    private void insertIfUnique(int value) {
        if (!uniqueNumbers.contains(value) && !seenNumbers.contains(value)) {
            uniqueNumbers.add(value);
        } else {
            uniqueNumbers.remove(value);
        }
    }

}
