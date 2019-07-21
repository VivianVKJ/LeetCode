import java.util.HashMap;

/*
 * @lc app=leetcode id=138 lang=java
 * HaspMap Method
 * [138] Copy List with Random Pointer
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        HashMap<Node,Node> map = new HashMap<>();
        Node cur = head;
        while(cur!=null){
            Node copy = new Node(cur.val);
            map.put(cur,copy);
            cur = cur.next;
        }
        cur = head;
        while(cur!=null){
            //ERROR
            //map.get(cur).next=cur.next;
            map.get(cur).next = map.get(cur.next);
            //map.get(cur).random = cur.random;
            map.get(cur).random =map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}

