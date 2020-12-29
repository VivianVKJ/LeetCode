import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import sun.tools.serialver.resources.serialver;

/*
 * @lc app=leetcode id=1268 lang=java
 *
 * [1268] Search Suggestions System
 */

// @lc code=start
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<String> pds = Arrays.asList(products);
        Collections.sort(pds);
        List<List<String>> ans = new ArrayList<>();
        TreeMap<String, Integer> treemap = new TreeMap<>();
        for (int i = 0; i < pds.size(); i++)
            treemap.put(pds.get(i), i);
        String word = "";
        for (int i = 0; i < searchWord.length(); i++) {
            word += searchWord.charAt(i);
            String ceil = treemap.ceilingKey(word);
            String floor = treemap.floorKey(word + "{");
            if (ceil == null || floor == null)
                ans.add(new ArrayList<String>());
            else
                ans.add(pds.subList(treemap.get(ceil), Math.min(treemap.get(ceil) + 3, treemap.get(floor) + 1)));
        }
        return ans;
    }
}
// @lc code=end
