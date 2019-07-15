import java.util.concurrent.PriorityBlockingQueue;

/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x:nums) pq.add(x);
        for(int i=0;i<nums.length-k;i++)  pq.remove();
        return pq.peek();
    }
}

