/*
 * @lc app=leetcode id=701 lang=cpp
 *
 * [701] Insert into a Binary Search Tree
 */
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* insertIntoBST(TreeNode* root, int val) {
        if(root) cout<<root->val<<"  ";
        if(root==NULL) return new TreeNode(val);
        if(val > root->val) root->right = insertIntoBST(root->right,val);
        else if(val < root->val) root->left= insertIntoBST(root->left,val);         

        return root;   //what's the meaning of returining root?
    }
};

