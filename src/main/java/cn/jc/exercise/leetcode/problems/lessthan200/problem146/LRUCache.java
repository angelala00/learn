package cn.jc.exercise.leetcode.problems.lessthan200.problem146;

/**
 * 未完成，目前还抛异常
 */
class LRUCache {
    Node head;
    Node tail;
    int capacity;
    int len;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        Node cur = head;
        while(cur != null && cur.key != key){
            cur = cur.next;
        }
        if (cur != null) {
            if (cur != head) {
                cur.pre.next = cur.next;
                if (cur != tail) {
                    cur.next.pre = cur.pre;
                } else {
                    tail = cur.pre;
                }
                cur.pre = null;

                cur.next = head;
                head.pre = cur;
                head = cur;
            }
            return cur.val;
        } else {
            return -1;
        }

    }

    public void put(int key, int value) {
        int v = get(key);
        if (v == -1) {
            Node n = new Node(key,value);
            if (len == 0) {
                tail = n;
                head = n;
                len +=1;
            } else {
                if (len == capacity) {
                    tail.pre.next = null;
                    tail = tail.pre;
                } else {
                    len +=1;
                }
                n.next = head;
                head.pre = n;
                head = n;
            }
        }
    }
    class Node{
        int key;
        int val;
        Node next;
        Node pre;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
//        LRUCache cache = new LRUCache(2);
//        cache.put(1,1);
//        cache.put(2,2);
//        cache.get(1);
//        cache.put(3,3);
//        cache.get(2);
//        cache.put(4,4);
//        cache.get(1);
//        cache.get(3);
//        cache.get(4);
        LRUCache cache = new LRUCache(1);
        cache.put(2,1);
        cache.get(2);
        cache.put(3,2);
        cache.get(2);
        cache.get(3);
    }
}
