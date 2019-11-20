/*
// Definition for a Node.
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
        if (node == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();		// store unvisited node
        queue.add(node);
        Map<Node, Node> map = new HashMap<Node,Node>();    

        while(!queue.isEmpty()) {   
            Node cur = queue.poll();    // visit a node
            Node clone = new Node(node.val,new ArrayList<>());
            map.put(cur, clone);
            if (cur.neighbors != null) {
                for (Node neighbor : cur.neighbors) {
                    if (!map.containsKey(neighbor)) {    // neighbor node hasn't been cloned
                        queue.add(neighbor);    // add neighbor node into queue
                        map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));    // clone the neighbor node
                    }
                    map.get(cur).neighbors.add(map.get(neighbor));    
                }
            }
        }
        return map.get(node);
    }
}

