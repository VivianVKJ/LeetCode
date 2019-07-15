/*
 * @lc app=leetcode id=138 lang=java
 * Error 1: {"$id":"1","next":null,"random":null,"val":-1}
 * Reason 1: head.random = null
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
    public void copyNode(Node head){
        while(head!=null){ //edge
            Node n = new Node(head.val,head.next);
            head.next = n;
            head = n.next;
        }
    }
    //copyNode √

    public void copyRandom(Node head){

        while(head!=null){  //edge
            if(head.random!=null) //Error 1
                head.next.random = head.random.next;
            head = head.next.next;
        }
    }

    public Node splitList(Node head){
        Node dummy = new Node(0);
        dummy.next = head.next;
        Node split = dummy;
        while(head!=null){
            Node temp = head.next;
            head.next = temp.next;
            split.next = temp;
            split = temp;
            head = head.next;
        }
        return dummy.next;
    }
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        copyNode(head);
        copyRandom(head);
        return splitList(head);
    }
}

/**
 * We can avoid using extra space for old node ---> new node mapping
 * by tweaking the original linked list. 
 * Simply interweave the nodes of the old and copied list. For e.g.
 * Old List: A --> B --> C --> D
 * InterWeaved List: A --> A' --> B --> B' --> C --> C' --> D --> D'
 * dummy_old & dummy_new to divide the list
 */
