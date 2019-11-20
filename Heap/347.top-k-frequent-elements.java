/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> count = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            count.put(nums[i],count.getOrDefault(nums[i],0)+1);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>((x,y)->count.get(x)-count.get(y));
        for(int n:count.keySet()){
            heap.add(n);
            if(heap.size()>k)
            heap.poll();
        }
 
        List<Integer> res = new ArrayList<Integer>();
        while(!heap.isEmpty()){
            res.add(heap.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
// @lc code=end

