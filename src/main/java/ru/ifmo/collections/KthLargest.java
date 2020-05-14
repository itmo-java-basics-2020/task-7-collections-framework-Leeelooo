package ru.ifmo.collections;

import java.util.Set;
import java.util.TreeSet;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {
    private final Set<Wrapper> orderedSet = new TreeSet<>();
    private final int k;

    public KthLargest(int k, int[] numbers) {
        for (int number : numbers) {
            orderedSet.add(new Wrapper(number));
        }
        this.k = k;
    }

    public int add(int val) {
        orderedSet.add(new Wrapper(val));
        return orderedSet.stream()
                .skip(orderedSet.size() - k)
                .findFirst()
                .map(Wrapper::getValue)
                .orElse(-1);
    }

    private static class Wrapper implements Comparable<Wrapper> {
        private final int value;

        public Wrapper(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public int compareTo(Wrapper o) {
            int compareResult = Integer.compare(value, o.value);
            if (compareResult == 0) {
                return -1;
            } else {
                return compareResult;
            }
        }
    }

}