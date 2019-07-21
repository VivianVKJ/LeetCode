/*
 * @lc app=leetcode id=109 lang=java
 * O(nlogn)
 * [109] Convert Sorted List to Binary Search Tree
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return buildBST(head);
    }

    public TreeNode buildBST(ListNode head){
        if(head==null) return null;
        if(head.next==null) return new TreeNode(head.val);
        ListNode slow = head, fast = head.next;
        while(fast.next!=null && fast.next.next!=null){
            slow =slow.next;
            fast=fast.next.next;
        }
        //Error 1: slow stop at mid-1;
        //[left,mid-1]; mid ; [mid+1,right];
        ListNode mid = slow.next;
        slow.next =null; //head -- slow [left - mid-1]
        TreeNode root = new TreeNode(mid.val);
        root.left = buildBST(head);
        root.right = buildBST(mid.next);
        return root;
    }
}

