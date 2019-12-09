import java.awt.HeadlessException;

/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                slow = head;
                while(slow!=fast){
                    slow = slow.next;  fast = fast.next;}
                return slow;  
            }
        }
        return null;
    }
        public ListNode detectCycle_Dec4(ListNode head) {
        if(head==null) return null;
        ListNode left = head, right = head;
        while(right.next!=null){
            right = right.next.next;
            if(right==null) return null;
            left = left.next;
            if(left==right) break;
        }
        if(right.next==null) return  null;
        while(head!=left){
            head=head.next;
            left=left.next;
        }
        return head;
    }
}

