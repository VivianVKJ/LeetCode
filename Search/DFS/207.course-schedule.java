/*
 * @lc app=leetcode id=207 lang=java
 * 3\n[[1,2],[2,1],[2,3]]
 * [207] Course Schedule
 */

java.util.*;// @lc code=start

class Solution {
    HashMap<Integer,HashSet<Integer>> map;
    List<Integer> trace ;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        trace = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            map.put(i,new HashSet<>());
        for(int i=0;i<prerequisites.length;i++){
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i=0;i<numCourses;i++){
            int[] color = new int[numCourses];
            if(dfs(i,color)==true) return false;
        }
        return true;
    }
    public boolean dfs(int curr, int[] color){
        if(color[curr]==1) {
            int i = trace.indexOf(curr);
            if(i!=-1){
                System.out.print("Cycle:  ");
                while(i<trace.size()){
                    System.out.print(trace.get(i)+" ");
                    i++;
                }
                System.out.print("\n");
            }
            return true; //have cycle
        }
        if(color[curr]==2) return false; //no cycle
        trace.add(curr);
        color[curr] = 1; //visiting,grey
        for(int post:map.get(curr))
            if(dfs(post,color)==true) return true;
        color[curr] = 2;
        trace.remove(trace.size()-1);
        return false;
    }
}
// @lc code=end

