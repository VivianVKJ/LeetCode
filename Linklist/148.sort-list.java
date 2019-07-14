/*
 * @lc app=leetcode id=148 lang=java
 * Sort a linked list in O(n log n) time using constant space complexity.
 * [148] Sort List
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


class Solution {
    public ListNode findMiddle(ListNode head){
        ListNode slow = head, fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val) {
                head.next = l1; l1 = l1.next;
            } else {
                head.next = l2; l2 = l2.next;
            }
            head = head.next;
        }
        if(l1==null) head.next = l2;
        else head.next = l1;
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode mid = findMiddle(head);
        ListNode right = sortList(mid.next);
        mid.next = null; //import to cut off
        ListNode left = sortList(head);

        return merge(left,right);
    }
}

