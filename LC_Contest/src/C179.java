import java.util.*;

public class C179 {
    public static void main(String[] args) {
        int[] light = new int[]{2,1,3,5,4};
        //System.out.println(numTimesAllBlue1(light));
        int n = 11;
        int headID = 4;
        int[] manager = new int[]{5,9,6,10,-1,8,9,1,9,3,4};
        int[] informTime = new int[]{0,213,0,253,686,170,975,0,261,309,337};
        //System.out.println(numOfMinutes(n,headID,manager,informTime));
        int[][] edges = {{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};  //7 2 4
        int[][] edges1 = {{2,1},{3,2}}; //3 1 2
        int[][] edges2 = {{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}}; //7 20 6
        int[][] edges3 = {{2,1},{3,2},{4,1},{5,1},{6,4},{7,1},{8,7}}; //8 7 7
        System.out.println(frogPosition(3,edges1,1,2));
    }
    public static int numTimesAllBlue(int[] light) {
        int n = light.length, blue = 0, max = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++) pq.add(i);

        for(int i=0;i<n;i++){
            int turnOn = light[i]-1;
            max = Math.max(max, turnOn);
            pq.remove(turnOn);
            if(pq.isEmpty() || pq.peek() >= max) blue++;
        }
        return blue;
    }
    public static int numTimesAllBlue1(int[] light){
        int n = light.length, blue = 0, max = 0;
        for(int i=0;i<n;i++){
            int bulb = light[i];
            max = Math.max(max, bulb);
            if(i+1>=max) blue++;
        }
        return blue;
    }

    // need to store manageID & time in BFS queue
    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            List<Integer> sub = map.getOrDefault(manager[i], new ArrayList<>());
            sub.add(i);
            map.put(manager[i], sub);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{headID, 0}); //[manager, time]
        int res = 0;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int man = cur[0];
            cur[1] += informTime[man];
            res = Math.max(res,cur[1]);
            if(map.containsKey(man)){
                List<Integer> sub = map.get(man);
                for(int emp : sub) {
                    queue.offer(new int[]{emp, cur[1]});
                }
            }
        }
        return res;
    }

    static class Node{
        int index;
        double prob;
        public Node(int n, double p){
            this.index = n;
            this.prob = p;
        }
    }
    //leetcode 1377
    public static double frogPosition(int n, int[][] edges, int t, int target) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<=n; i++) map.putIfAbsent(i, new ArrayList<>());
        for(int i=0; i<edges.length;i++){
            int from = edges[i][0], to = edges[i][1];
            map.get(from).add(to);
            map.get(to).add(from);
        }
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(new Node(1,1.0)); //node, prob

        while(!queue.isEmpty() && t>=0 ){
            for(int size = queue.size(); size>0; size--){  //node from same level
                Node node  = queue.poll();
                visited.add(node.index);
                int count = 0;
                for(int next : map.get(node.index)){
                    if(!visited.contains(next)) count ++;
                }
                //end condition: [1)time expire 2)jump forever] && target
                if(target == node.index && (count == 0 || t==0) ) return node.prob;
                for(int next: map.get(node.index)){
                    if(!visited.contains(next))
                        queue.offer(new Node(next, node.prob/count));
                }
            }
            t--;
        }
        return 0.0;
    }
}
