/*
 * @lc app=leetcode id=144 lang=cpp
 *
 * [144] Binary Tree Preorder Traversal
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
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> out;
        preTraversal(root,out);
        return out;
    }
    void preTraversal(TreeNode* root, vector<int>& out){
        if(root){
            out.push_back(root->val);
            preTraversal(root->left,out);
            preTraversal(root->right,out);
        }
        else return;
    }
};

