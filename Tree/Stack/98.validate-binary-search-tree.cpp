/*
 * @lc app=leetcode id=98 lang=cpp
 * 1. divide and conquer; left subtree return max; right return min
 * 2. inorder traversal: an increasing sequence
 * [98] Validate Binary Search Tree
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
    bool isValidBST(TreeNode* root) {
        //left-root-right Inorder;
        stack<TreeNode*> stack;
        vector<int> inorder;
        TreeNode* temp  = root;
        while(temp||!stack.empty()){
            while(temp){
                stack.push(temp);
                temp=temp->left;
            }
            temp=stack.top();
            stack.pop();
            inorder.push_back(temp->val);
            temp = temp->right;
        }
        return checkValid (inorder);
    }
    bool checkValid (vector<int> v){
        for(int i = 1; i<v.size();i++){
            if(v[i-1]>=v[i]) return false;
        }
        return true;
    }
};

