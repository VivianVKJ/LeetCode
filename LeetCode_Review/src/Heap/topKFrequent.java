package Heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class topKFrequent {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(topKFrequent(nums, k).size());
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        PriorityQueue<Integer> heap = new PriorityQueue<>(map.size(), (x, y) -> (map.get(y) - map.get(x)));
        for (int i : map.keySet()) heap.add(i);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++)
            ans.add(heap.poll());
        return ans;
    }
}
