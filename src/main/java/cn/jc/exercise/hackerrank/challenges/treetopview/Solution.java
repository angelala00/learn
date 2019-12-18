package cn.jc.exercise.hackerrank.challenges.treetopview;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    public static void topView(Node root) {
        Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<Integer>();
        queue.add(root);
        queue2.add(0);
        while (queue.peek() != null) {
            Node tmp = queue.poll();
            Integer level = queue2.poll();
            if (!map.containsKey(level)) {
                map.put(level, tmp.data);
                System.out.println(map);
            }
            if (tmp.left != null) {
                queue.offer(tmp.left);
                queue2.offer(level - 1);
            }
            if (tmp.right != null) {
                queue.offer(tmp.right);
                queue2.offer(level + 1);
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
             System.out.print(entry.getValue());
             System.out.print(" ");
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int t = scan.nextInt();
//        Node root = null;
//        while(t-- > 0) {
//            int data = scan.nextInt();
//            root = insert(root, data);
//        }
//        scan.close();
        Node root = null;
        String input = "1 14 3 7 4 5 15 6 13 10 11 2 12 8 9";
        for (String s : input.split(" ")) {
            root = insert(root, Integer.parseInt(s));
        }
        topView(root);


    }
}
