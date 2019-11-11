package cn.jc.exercise.leetcode.problems.lessthan200.problem146;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
    LinkedHashMap<Integer, Integer> cache;
    private int capacity;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return cache.size() > capacity;
    }
}
