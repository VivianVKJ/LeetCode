/*
 * @lc app=leetcode id=24 lang=java
 * 
 * [24] Swap Nodes in Pairs
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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head.next!=null){
            if(head.next.next==null) 
                return dummy.next;
            else {
                ListNode temp = head.next;
                head.next = temp.next;
                temp.next = temp.next.next;
                head.next.next = temp;
                head = temp;
            }
        }
        return dummy.next;
    }
}

