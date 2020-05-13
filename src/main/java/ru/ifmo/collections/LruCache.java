package ru.ifmo.collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents LRU cache with fixed maximum capacity.
 *
 * get() should return null if there is no value for a given key.
 * elements() should return number of elements in cache.
 *
 * This class should not have any other public methods.
 *
 * Implementing this cache in (almost) the same manner as it was implemented during the lecture will result in extra points.
 */
public class LruCache<K, V> {
    private final Map<K, V> cache;
    private final int capacity;

    public LruCache(int capacity) {
        cache = new LinkedHashMap<>(capacity, 1f, true);
        this.capacity = capacity;
    }

    public V get(K key) {
        return cache.get(key);
    }

    public void put(K key, V value) {
        if (cache.size() == capacity) {
            cache.remove(cache.keySet().iterator().next());
        }
        cache.put(key, value);
    }

    public int elements() {
        return cache.size();
    }
}