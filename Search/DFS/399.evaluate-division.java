/*
 * @lc app=leetcode id=399 lang=java
 * [399] Evaluate Division
 */

// @lc code=start
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String,Double>> map = new HashMap<>();
        for(int i=0;i<equations.size();i++){
            String a =equations.get(i).get(0), b=equations.get(i).get(1);
            map.putIfAbsent(a,new HashMap<>());
            map.putIfAbsent(b,new HashMap<>());
            map.get(a).put(b,values[i]);
            map.get(b).put(a,1/values[i]);
        }
        double[] ans = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            String s = queries.get(i).get(0), t = queries.get(i).get(1);
            if(!map.containsKey(s) || !map.containsKey(t)) ans[i] = -1.0;
            else if(s==t) ans[i] = 1.0;
            ans[i] = dfs(map,s,t,1.0,new HashSet<>());
        }
        return ans;
    }
    public static double dfs(HashMap<String, HashMap<String,Double>> map,String s, String t, double res,HashSet<String> visited){
        if(!map.containsKey(s) || visited.contains(s)) return -1;
        visited.add(s);
        HashMap<String,Double> chain = map.get(s);
        for(String post : chain.keySet()){
            if(post.compareTo(t) == 0) return res*chain.get(post);
            //judge if return -1, ignore and go on the for loop
            double temp_res = dfs(map,post,t,res*chain.get(post),visited);
            if(temp_res!=-1) return temp_res;
        }
        return -1;
    }
}
// @lc code=end

