import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=692 lang=java
 *
 * [692] Top K Frequent Words
 */

// @lc code=start
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<String>(map.size(),
                (x, y) -> (map.get(x) == map.get(y) ? x.compareTo(y) : map.get(y) - map.get(x)));
        for (String word : map.keySet()) {
            pq.add(word);
        }
        List<String> ans = new ArrayList<>();
        while (!pq.isEmpty() && ans.size() < k) {
            ans.add(pq.poll());
        }
        return ans;
    }
}
// @lc code=end
