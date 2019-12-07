package cn.jc.interview.airbnb.date201912.first;

// There is a tree having n nodes, numbered from 1 to n. Each node i has an initial value init-i, which is either 0 or 1. *The root of the tree is node 1.*

// One can perform several (possibly, zero) operations on the tree. The only available type of operation is to pick a node x. Right after the node x is picked:

// * the value of node x flips
// * the values of x's children remain the same
// * the values of x's grand children (children of children) flip
// * the values of x's great-grand-children remain the same, and so on.


// The goal is to get each node i to have value target-i, which can also be only 0 or 1. You need to reach the goal by using minimum number of operations.


// Sample Input:
// // number of nodes in the tree (N)
// 10
// // edges connecting nodes in the tree (N-1 edges)
// 2 1
// 3 1
// 4 2
// 5 1
// 6 2
// 7 5
// 8 6
// 9 8
// 10 5
// // init value for each node
// 1 0 1 1 0 1 0 1 0 1
// // target value for each node
// 1 0 1 0 0 1 1 1 0 1


// Sample Output:
// // the minimum number of operations
// 2
// // the node to be picked for each operation
// 4
// 7


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    static int[] initValue = new int[]{1,0,1,1,0,1,0,1,0,1};
    static int[] targetValue = new int[]{1,0,1,0,0,1,1,1,0,1};
    static Map<Integer, List<Integer>> allMap = new HashMap<Integer,List<Integer>>();
    public static void main(String[] args) {
//        ArrayList<String> strings = new ArrayList<String>();
//        strings.add("Hello, World!");
//        strings.add("Welcome to CoderPad.");
//        strings.add("This pad is running Java " + Runtime.version().feature());
//
//        for (String string : strings) {
//            System.out.println(string);
//        }

        int n = 10;
        int[][] arr = new int[][]{{2,1},{3,1},{4,2},{5,1},{6,2},{7,5},{8,6},{9,8},{10,5}};
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i][0];
            int b = arr[i][1];

            if (!allMap.containsKey(a)) {
                allMap.put(a, new ArrayList<>());
            }
            allMap.get(a).add(b);
            if (!allMap.containsKey(b)) {
                allMap.put(b, new ArrayList<>());
            }
            allMap.get(b).add(a);
        }
        System.out.println(allMap);
        System.out.println("=====");
        Node root = new Node();
        root.idx = 1;
        root.parent = 0;//TODO
        buildNode(root);
        bianli(root);
        System.out.println("=====");
        System.out.println(result);
        System.out.println(picks);
    }

    private static void buildNode(Node root) {
        List<Integer> children = allMap.get(root.idx);
        if (children != null) {
            root.children = new HashMap<Integer, Node>();
            for (Integer child : children) {
                if (child != root.parent) {
                    Node childNode = new Node();
                    childNode.idx = child;
                    childNode.parent = root.idx;
                    root.children.put(child, childNode);
                    buildNode(childNode);
                }
            }
        }
    }

    static List<Integer> picks = new ArrayList<>();
    public static void bianli(Node node) {
        System.out.println(node.idx);
        if (needPick(node)) {
            pick(node, true);
            result++;
            picks.add(node.idx);
        }
        if (node.children != null) {
            for (Node childNode : node.children.values()) {
                bianli(childNode);
            }
        }
    }
    public static void pick(Node node, boolean tag){
        if (tag) {
            initValue[node.idx - 1] = targetValue[node.idx - 1];
        }
        if (node.children != null) {
            for (Node childNode : node.children.values()) {
                pick(childNode, !tag);//
            }
        }
    }

    public static boolean needPick(Node node){
        if (initValue[node.idx - 1] != targetValue[node.idx - 1]) {
            return true;
        } else {
            return false;
        }
    }

    static int result = 0;
    static class Node {
        int idx;
        int parent;
        Map<Integer, Node> children;
    }
}
