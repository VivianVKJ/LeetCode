
/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
    public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
        return null;
    }
    
    Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
        @Override
        public int compare(ListNode l1,ListNode l2){
            return l1.val - l2.val;
        }
    });
    for(ListNode head:lists){
        if(head!=null) heap.add(head);
    }
    
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    while (!heap.isEmpty()) {
        ListNode head = heap.poll();
        tail.next = head;
        tail = head;
        if (head.next != null) {
            heap.add(head.next);
        }
    }
    return dummy.next;
    }
}

