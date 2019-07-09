/*
 * @lc app=leetcode id=102 lang=cpp
 * save queue has vector<int>
 * push vector<int> 
 * [102] Binary Tree Level Order Traversal
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
    vector<vector<int>> levelOrder(TreeNode* root) {
        queue<TreeNode* > queue; //save TreeNode
        vector<int> layer;
        vector<vector<int>> result;
        if(root) queue.push(root);

        while(!queue.empty()){
            int current_len = queue.size(); //ERROR 1
            for(int i = 0; i <current_len;i++){
                TreeNode* temp = queue.front();
                layer.push_back(temp->val);            
                queue.pop();
                if(temp->left) queue.push(temp->left);
                if(temp->right) queue.push(temp->right);
            }
            result.push_back(layer);
            layer.clear();
        }
        return result;
    }
};

