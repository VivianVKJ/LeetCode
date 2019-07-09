/*
 * @lc app=leetcode id=173 lang=cpp
 * BST feature: inorder traversal to get an increasing sequence
 * [173] Binary Search Tree Iterator
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
class BSTIterator {
public:
    stack<TreeNode*> s;
    vector<int> out;
    int i;

    //inorder traversal using s;
    //left-root-right
    vector<int> inorderTraversal (TreeNode* root){
        TreeNode* temp = root;
        while(!s.empty() || temp){
            while(temp){
                s.push(temp);
                temp=temp->left;
            }
            temp=s.top(); s.pop();
            out.push_back(temp->val);
            temp=temp->right;
        }
        return out;
    }
    BSTIterator(TreeNode* root) {
        inorderTraversal(root);
        i=0;
    }
    
    /** @return the next smallest number */
    int next() {
        return out[i++];
    }
    
    /** @return whether we have a next smallest number */
    bool hasNext() {
        return i<out.size();
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */

