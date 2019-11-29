import java.util.Iterator;
import java.util.Set;

import com.sun.media.jfxmedia.events.NewFrameEvent;

import javafx.scene.Node;

/*
 * @lc app=leetcode id=133 lang=java
 * 1. clone node 2.clone edg3
 * traverse the graph: BFS - QUEUE
 * 弹出队首元素，克隆队首，相邻节点加入队列
 * map: initial -> null
 * queue： initial -> head
 * Loop1: queue--node 2.map--edge
 * [133] Clone Graph
 */

// Definition for a Node.
/*
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;

        Queue<Node> queue = new LinkedList<>();
        HashMap<Node,Node> map = new HashMap<Node,Node>();
        queue.offer(node);

        //map.put(node,null);
        //1.add node to map by queue
        while(!queue.isEmpty()){
            Node current = queue.poll();
            Node clone = new Node(current.val,new ArrayList<>());
            map.put(current,clone);
            if(current.neighbors!=null){
                for(Node nextNode:current.neighbors){
                    if(!map.containsKey(nextNode)){
                        queue.offer(nextNode);
                        map.put(nextNode,null);
                    }
                }  
            }
        } //end add node;
        //map: old -- new 

        for(Node ori:map.keySet()){   //get old Node set
            System.out.println('ori:'+ori.val);
            Node cpy = map.get(ori);  //get old Node ori's new
            if(ori.neighbors!=null){
                for(Node nei:ori.neighbors){      
                    Node newNeighbor = map.get(nei);
                    System.out.println('nei:'+nei.val+' ,nei''+newNeighbor.val);
                    cpy.neighbors.add(newNeighbor);
                }
            }
         
        }
        return map.get(node);
    }
}

