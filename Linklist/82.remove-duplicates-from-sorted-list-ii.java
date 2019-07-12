/*
 * @lc app=leetcode id=82 lang=java
 * Head may be deleted
 * 1->2->3->3->4->4->5
 * 1->1->1->2->3
 * [82] Remove Duplicates from Sorted List II
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode dummy = new ListNode(-1);
        ListNode previous = dummy;
        ListNode current = head;
        previous.next = current;

        while(current!=null){
            while(current.next!=null && current.val == current.next.val)
                current = current.next;

            if(previous.next!=current) {
                //still left one of the duplicate number
                previous.next = current.next;
                current = previous.next;
            }
            else { //no dup, move down both pointer.
                previous = previous.next; 
                current = current.next;
            }
        }
        return dummy.next;
    }
}

