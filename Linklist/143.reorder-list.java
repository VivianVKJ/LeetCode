/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next ==null) return; //ERROR 3
        ListNode slow = head, fast = head.next;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        } 
        if(slow.next == fast) return;
        ListNode tail = slow.next;
        slow.next =null;
        tail = reverseList(tail);

        merge(head, tail);
    }
    public ListNode reverseList(ListNode head){
        ListNode temp  = null, previous = null;
        while(head!=null){
            temp = head.next;
            head.next = previous;
            previous = head;
            head = temp;
        }
        //while(head.next!=null)
        // ... head.next = previous;  //ERROR 1;
        //return head
        return previous;
    }

    //not consise merge function
    public void reoderMerge(ListNode l1, ListNode l2){
        ListNode pl1 = null,pl2=null;
        while(l1.next!=null && l2.next!=null){  //ERROR 2
            pl1 =l1.next; //same
            pl2 = l2.next;
            l1.next = l2; l2.next = pl1;
            l1 = pl1; l2 = pl2;
        }
        if(l1.next==null) { //1-2 3-4
            l1.next =l2; //same
            l2.next = null;
        }
        else{  //1-2-3 4-5
            pl1=l1.next;  //same1             
            l1.next = l2; l2.next = pl1;
            pl1.next=null;
        }
    }
    //consise merge function
    public void merge(ListNode l1, ListNode l2){ 
        while(l1!=null){
            ListNode p1 = l1.next, p2 = l2.next;
            l1.next = l2;
            if(p1==null) {break;}
            l2.next = p1;
            l1=p1; l2=p2;
        }
    }
}

