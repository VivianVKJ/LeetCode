/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        ListNode temp = null,previousM=null,startM=null,postN=null,endN=null,previous = null;
        dummy.next = head; head = dummy;
        int i = 0;
        for(i = 0; i<m-1;i++)  head = head.next;
        //head = m-1; 
        previousM = head;
        head = previousM.next; startM = head; i=m;//m
        while(i<n){
            temp = head.next;
            head.next = previous;
            previous = head;
            head = temp;
            i++;
        }
        previousM.next = head;
        postN = head.next;
        head.next = previous;
        startM.next = postN;
        return dummy.next;
    }
}

