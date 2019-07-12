/*
 * @lc app=leetcode id=82 lang=cpp
 * [1,2,2] the second while(delete duplicate) has an edge: head->next!=NULL
 * [1,1,1,2,3] ! head = dummy;
 * [82] Remove Duplicates from Sorted List II
 */
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if(!head) return NULL;
        ListNode* dummy = new ListNode(-1);
        dummy->next = head;
        head = dummy; 
        while(head->next){
            if(head->next->next && head->next->val == head->next->next->val){
                int duplicate = head->next->val;
                while( head->next && head->next->val == duplicate)
                    head->next = head->next->next;
            }
            else head = head->next;
        }
        return dummy->next;
    }
};

