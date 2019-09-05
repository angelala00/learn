package cn.jc.exercise.leetcode.problems.problem705;

class MyHashSet {

    byte[] data = null;
    /** Initialize your data structure here. */
    public MyHashSet() {
        data = new byte[1000000];
    }

    public void add(int key) {
        if (!contains(key)) {
            data[key] = 1;
        }
    }

    public void remove(int key) {
        data[key] = 0;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return data[key] == 1;
    }
    private int getHash(int key){
        return key;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
