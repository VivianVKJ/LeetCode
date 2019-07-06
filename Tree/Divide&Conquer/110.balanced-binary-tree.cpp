/*
 * @lc app=leetcode id=110 lang=cpp
 * '[1,2,2,3,3,null,null,4,4]'
 * [110] Balanced Binary Tree
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
    bool isBalanced(TreeNode* root) {
        stack<TreeNode*> stack;
        return MaxDepth(root)!=-1;

    }
private:
    //Balence: return depth; else return -1;
    //Divide and Conqure
    int MaxDepth(TreeNode* temp){
        if(temp==nullptr) return 0;
        else {
            int left = MaxDepth(temp->left);
            int right = MaxDepth(temp->right);
            if(abs(left-right)>1||left==-1||right==-1) 
                return -1;
            else return max(left,right)+1; //exit this layer then +1
        }
    }
};

