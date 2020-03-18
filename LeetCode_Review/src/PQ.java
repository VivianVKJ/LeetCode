import java.util.*;

public class PQ {
    public static void main(String[] args){
        int[][] items ={{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        highFive_My(items);
    }
    public static int[][] highFive_My(int[][] items) {
        // HashMap<Integer,List> map = new HashMap<>();
        TreeMap<Integer,PriorityQueue> map = new TreeMap<>();
        //treemap automatically sort the key

        int n = items.length;
        for(int i=0;i<n;i++){
            if(map.containsKey(items[i][0])){
                map.get(items[i][0]).offer(items[i][1]);
                map.put(items[i][0],map.get(items[i][0]));
            }
            else {
                PriorityQueue<Integer> pq = new PriorityQueue<>(5,(x,y)->(y-x));
                pq.offer(items[i][1]);
                map.put(items[i][0],pq);
            }
        }

        int[][] ans = new int[map.size()][2];

        int stu_index = 0;
        for(int i : map.keySet()){
            ans[stu_index][0] = i;
            PriorityQueue<Integer> pq = map.get(i);
            int score = 0;
            int count = 5;
            while(count>0){
               score+= pq.poll();
               count--;
            }
            ans[stu_index++][1] = score/5;
        }
        return ans;
    }
    public static int[][] highFive(int[][] items) {

        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        for(int[] item : items){
            int id = item[0];
            int score = item[1];
            if(!map.containsKey(id)){
                PriorityQueue<Integer> pq = new PriorityQueue<Integer>(5);
                pq.offer(score);
                map.put(id, pq);
            }else{
                PriorityQueue<Integer> pq = map.get(id);
                pq.offer(score);
                if(pq.size() > 5)
                    pq.poll();
                map.put(id, pq);
            }
        }

        int index = 0;
        int[][] res = new int[map.size()][2];
        for(int id : map.keySet()){
            res[index][0] = id;
            PriorityQueue<Integer> pq = map.get(id);
            int sum = 0;
            int size = pq.size();
            while(!pq.isEmpty())
                sum+= pq.poll();

            res[index][1] = sum/size;
            index++;

        }
        return res;
    }
}
