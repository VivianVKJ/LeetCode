/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head; //same start
        while(fast!=null&&fast.next!=null){ //ERROR1
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }
}

