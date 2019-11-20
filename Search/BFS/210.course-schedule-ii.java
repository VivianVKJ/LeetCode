/*
 * @lc app=leetcode id=210 lang=java
 * return one of the possible answer
 * [210] Course Schedule II
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int num_pre = prerequisites.length;
        List<List<Integer>> post =new ArrayList<>();
        int[] indegree = new int[numCourses];
        int[] ans = new int[numCourses];
        for(int i=0;i<numCourses;i++)
            post.add(new ArrayList<>());
        for(int i=0;i<num_pre;i++){
            post.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++)
            if(indegree[i]==0) 
                queue.offer(i);
        int index = 0;
        while(!queue.isEmpty()){
            int take =  queue.poll();
            ans[index++] = take;
            for(int taken : post.get(take)){
                indegree[taken]--;
                if(indegree[taken]==0) queue.offer(taken);
            }
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]>0)
            return (new int[0]);
        }
        return ans;
    }
}

