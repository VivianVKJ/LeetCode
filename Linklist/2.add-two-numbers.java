/*
 * @lc app=leetcode id=2 lang=java
 * [1]\n[9,9]
 * [2] Add Two Numbers
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2 ==null) return null;
        ListNode p1 = l1, p2=l2;
        ListNode dummy = new ListNode(0);
        ListNode p3 = dummy;
        int ten=0;
        while(p1!=null || p2!=null || ten!=0 ){
            if(p1!=null){
                ten+=p1.val;
                p1 = p1.next;
            }
            if(p2!=null){
                ten+=p2.val;
                p2 = p2.next;
            }
            p3.next = new ListNode(ten%10);
            ten = ten/10;
            p3 = p3.next;
        }
        return dummy.next;
    }
    public ListNode addTwoNumbers_My(ListNode l1, ListNode l2) {
        if(l1==null && l2 ==null) return null;
        ListNode p1 = l1, p2=l2;
        ListNode ans = new ListNode(0);
        ListNode p3 = ans;
        int ten = 0;
        while(p1!=null && p2!=null){
            p3.val = (p1.val+p2.val+ten)%10;
            ten = (p1.val+p2.val+ten)/10;
            p1=p1.next;
            p2=p2.next;
            if(p1==null && p2 ==null){
                if(ten==0) p3.next =null;
                else {
                    p3.next = new ListNode(1);
                    p3.next.next=null;
                    return ans;
                }
            } 
            else {
                p3.next = new ListNode(0);
                p3=p3.next;
            }
        }
        while(p2!=null){
            p3.val = (p2.val+ten)%10;
            ten = (p2.val+ten)/10;
            p2 = p2.next;
            if(p2==null){
                if(ten==0) p3.next =null;
                else {
                    p3.next = new ListNode(1);
                    p3.next.next=null;
                    return ans;
                }
            }
            else
                p3.next = new ListNode(0); p3=p3.next;
        }
        while(p1!=null){
            p3.val = (p1.val+ten)%10;
            ten = (p1.val+ten)/10;
            p1 = p1.next;
            if(p1==null){
                if(ten==0) p3.next =null;
                else {
                    p3.next = new ListNode(1);
                    p3.next.next=null;
                    return ans;
                }
            }
            else
                p3.next = new ListNode(0); p3=p3.next;
        }           
        return ans;
    }
}

