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
struct Command{
    bool next;  //ture-go/false-print
    TreeNode* node;
    Command(bool next, TreeNode* node): next(next),node(node){} //init
};
class Solution {
    
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> out;
        if(root){
            stack<Command> stack;
            stack.push(Command(true,root));
            while(!stack.empty()){
                Command command = stack.top();
                stack.pop();
                if(!command.next) out.push_back(command.node -> val);
                else {
                    assert(command.next);//true
                    //preorder: reserve right-left-root
                    if(command.node ->right)
                    stack.push(Command(true,command.node->right));
                    if(command.node ->left)
                    stack.push(Command(true,command.node->left));
                    stack.push(Command(false,command.node));
                }
            }
            return out;
        }
        else return out;
    }

};

