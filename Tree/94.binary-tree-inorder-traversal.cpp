/*
 * @lc app=leetcode id=94 lang=cpp
 *
 * [94] Binary Tree Inorder Traversal
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
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> out;
        stack<TreeNode*> stack;
        TreeNode* temp = root;
        while(!stack.empty()||temp){
            while(temp){
                stack.push(temp);
                temp = temp ->left;
            }
            temp = stack.top();
            stack.pop();
            out.push_back(temp->val);
            temp=temp->right;
        }
        return out;
    }
};

