/*
 * @lc app=leetcode id=86 lang=java
 * dummy left and dummy right
 * [86] Partition List
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy_left = new ListNode(0);
        ListNode dummy_right = new ListNode(0);
        ListNode left = dummy_left, right = dummy_right;
        while(head!=null){
            if(head.val<x) {
                left.next = head;
                left = head; 
            }
            else {
                right.next = head;
                right =head;
            }
            head = head.next;
        }
        left.next = dummy_right.next;
        right.next = null; //cut off
        return dummy_left.next;
    }
}

