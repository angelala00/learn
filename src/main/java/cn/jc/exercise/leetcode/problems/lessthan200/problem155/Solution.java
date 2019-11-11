package cn.jc.exercise.leetcode.problems.lessthan200.problem155;

import java.util.ArrayList;
import java.util.List;
class MinStack {

    private List<Integer> list;
    /** initialize your data structure here. */
    public MinStack() {
        list = new ArrayList<Integer>();
    }

    public void push(int x) {
        list.add(x);
    }

    public void pop() {
        list.remove(list.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        Integer min = null;
        for (Integer i : list) {
            if (min == null) {
                min = i;
            } else {
                if (min > i) {
                    min = i;
                }
            }
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
