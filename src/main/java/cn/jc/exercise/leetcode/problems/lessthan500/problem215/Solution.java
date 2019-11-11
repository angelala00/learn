package cn.jc.exercise.leetcode.problems.lessthan500.problem215;

class Solution {
    int[] heap;

    public int findKthLargest(int[] nums, int k) {
        heap = new int[k];
        System.arraycopy(nums, 0, heap, 0, k);
        for (int i = 0; i < k; i++) {
            int t = i;
            while (t > 0 && heap[t] < heap[getParentIndex(t)]) {
                swap(t, getParentIndex(t));
                t = getParentIndex(t);
            }
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > heap[0]) {
                heap[0] = nums[i];
                int j = 0;

                while (true) {
                    int left = getLeftIndex(j);
                    int right = getRightIndex(j);
                    if ((left < k && heap[j] > heap[left]) || (right < k && heap[j] > heap[right])) {
                        if (right < k && heap[left] > heap[right]) {
                            swap(j, right);
                            j = right;
                        } else {
                            swap(j, left);
                            j = left;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return heap[0];
    }

    private int getParentIndex(int idx) {
        return (idx - 1) / 2;
    }

    private int getLeftIndex(int idx) {
        return idx * 2 + 1;
    }

    private int getRightIndex(int idx) {
        return idx * 2 + 2;
    }

    private void swap(int a, int b) {
        int tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}
