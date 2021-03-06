/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
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
    public ListNode reverseList(ListNode head) {
        //Recursion
        if(head==null || head.next ==null) return head;
        ListNode reverseHead = reverseList(head.next);
        head.next.next = head; //trickey [1]: head.next hasn't change
        head.next=null;
        return reverseHead; //always return reverseHead
    }
    public ListNode reverseList_2(ListNode head) {
        ListNode pre = null;
        while(head!=null){
            ListNode post = head.next;
            head.next = pre;
            pre = head;
            head = post;
        }
        return pre;
    }
    public ListNode reverseList_1(ListNode head) {
        if(head==null) return null;
        ListNode temp = head;
        ListNode previous = null;
        while(head.next!=null) {
                temp = head.next;
                head.next = previous;
                previous = head;
                head = temp;
        }
        head.next = previous;
        return head;
    }
}

