import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            nums.add(p.val);
            p = p.next;
        }
        int l = 0, r = nums.size() - 1;
        while (l < r) {
            if (!nums.get(l).equals(nums.get(r)))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
// @lc code=end
