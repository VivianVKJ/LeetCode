/*
 * @lc app=leetcode id=341 lang=cpp
 *
 * [341] Flatten Nested List Iterator
 */
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * class NestedInteger {
 *   public:
 *     // Return true if this NestedInteger holds a single integer, rather than a nested list.
 *     bool isInteger() const;
 *
 *     // Return the single integer that this NestedInteger holds, if it holds a single integer
 *     // The result is undefined if this NestedInteger holds a nested list
 *     int getInteger() const;
 *
 *     // Return the nested list that this NestedInteger holds, if it holds a nested list
 *     // The result is undefined if this NestedInteger holds a single integer
 *     const vector<NestedInteger> &getList() const;
 * };
 */
class NestedIterator {
public:
    stack<NestedInteger> nstack;
    
    NestedIterator(vector<NestedInteger> &nestedList) {
        for(int i = nestedList.size()-1; i>=0; i--)
            nstack.push(nestedList[i]);
    }

    int next() {
        NestedInteger t = nstack.top();
        nstack.pop();
        return t.getInteger();
    }

    bool hasNext() {
        while(!nstack.empty()){
            NestedInteger t = nstack.top();
            if(t.isInteger()) return true;
            else { //a nest list
                nstack.pop();
                for(int i = t.getList().size()-1; i>=0; i--)
                    nstack.push(t.getList()[i]);
            }
        }
        return false;
    }
    
};

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i(nestedList);
 * while (i.hasNext()) cout << i.next();
 */

