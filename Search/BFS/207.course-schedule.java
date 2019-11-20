/*
 * @lc app=leetcode id=207 lang=java
 * use HashMap<Integer,List> to save the post classes 
 * so that whenever we dequeue (take a class)
 * the indegree of post classes will -1
 * [207] Course Schedule
 */

 // 3\n [[1,0],[2,0]]
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites){
        int num_pre = prerequisites.length;
        List<List<Integer>> post = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i =0;i<numCourses;i++)
            post.add(new ArrayList<>());
            
        for(int i=0;i<num_pre;i++){
            post.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)  queue.offer(i);
        }
        while(!queue.isEmpty()){
            int take = queue.poll();
            indegree[take]-=1;
            for(int i : post.get(take)){
                indegree[i]--;
                if(indegree[i]==0) queue.offer(i);  
            }
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]>0) return false;
        }
        return true;

    }
    public boolean canFinish_HashMap(int numCourses, int[][] prerequisites) {
        int num_pre = prerequisites.length;
        // System.out.printf("pre.size=%d",num_pre);
        HashMap<Integer,List<Integer>> post_class = new HashMap<Integer,List<Integer>>();
        int[] indegree = new int[numCourses];
        for(int i=0;i<num_pre;i++){
            indegree[prerequisites[i][0]]++;
            if(post_class.containsKey(prerequisites[i][1])){
                post_class.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
            else{
                List<Integer> pre = new ArrayList<>();   
                pre.add(prerequisites[i][0]);
                post_class.put(prerequisites[i][1],pre);
            }
        }
        //HashMap: 0-->1

        Queue<Integer> queue = new LinkedList();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)  queue.offer(i);
        }
      
        while(!queue.isEmpty()){
            int take_class = queue.poll();

            indegree[take_class]--;
            if(post_class.containsKey(take_class)){
                for(int get_post : post_class.get(take_class)){
                    indegree[get_post]--;
                    if(indegree[get_post]==0) queue.offer(get_post);
                }
            }
            else{
                System.out.printf("map not found %d!",take_class);
            }
            post_class.remove(take_class);

        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]>0) return false;
        }
        return true;
    }
}

