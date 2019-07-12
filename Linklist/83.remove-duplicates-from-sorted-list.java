/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
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
        if(head==null) return head;
        ListNode current = head;
        while(current.next!=null){
            if(current.val==current.next.val)
                current.next=current.next.next; //delete untill not equal
            else current = current.next;
        }
        return head;
    }
}

