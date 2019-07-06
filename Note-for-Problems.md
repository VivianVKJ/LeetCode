## Array
**26. Remove Duplicates from Sorted Array I**
* exceptional case
  * if( nums.empty() ) return 0;  
>use two pointers: `slow` and `fast`. 
if `nums[slow]`==`nums[fast]`，pointer `fast` increas 1;
if`nums[slow]`!=`nums[fast]`, they both increase one.  return slow+1

***
**80. Remove Duplicates from Sorted Array II**
>use two pointers as well  
use a `count` variable to keep how many times the duplicated element appears.  
count is initialized to be 0;  the first time `nums[slow]`==`nums[fast]` both pointers and `count` increase 1; and jump other cases when `count`==1;  

***
**189. Rotate Array**
* exceptional case
  * nums.size()==0;
  * k<0
  * k>nums.size()

```cpp
//Solution1:
vector<int> copynum(k);
```

```cpp
//Solution2:
reverse(nums.begin(),nums.end());
reverse(nums.begin(), nums.begin()+k);
reverse(nums.begin()+k, nums.end());
```

```cpp
//solution3:
for (int i = 0;i<n-k;i++){
	nums.push_back(nums[0]); 
	nums.erase(nums.begin());
}
```

**299. Bulls and Cows**
* String
    ```cpp 
    string A = to_null('0'+2) + A;
    ```
> My solution:  
Scan and delete the equal number. 
Then use two extra vectors to record how many times each number(0 to 9) occurs. Compare two vectors and add the bigger one to result `cows`.

> Another solution: Hash Table

***
**274. H-index**
* exceptional case
  * input [0]: h=0; 
  * input [];  h=0; --> `return citations.size();`
  * input [100]; h=1;
* sort( citations.begin( ), citations.end( ),**greater<int>( )** );  //sort from big to small
> Solution:  
    1. use index [1,n]	: index<=>people return r-1;
    2. use index[0,n-1]: return r; `(already -1)`
>> **a.** if (i=people <= citations[**i-1**]) go on people++;
>> **b.** once people > citations[i-1]; no enough people have citations of equal number. 
>> **c.** return **r-1**: return last element <= target
    
```cpp
/*
 * h papers at least h citations
 * citations[i-1]:6,5,3,1,0
 *       index i :1,2,3,4,5
 *                √ √ √ ×
 *       return i-1;
 */
class Solution {
public:
    int hIndex(vector<int>& citations) {
        sort(citations.begin(),citations.end(),greater<int>());
		for (int i = 1; i <=citations.size(); i++) 
			if (i > citations[i-1])
				return (i-1);
		return citations.size();
    }
};

```
## Binary Search

**275. H-index-ii**
* Array already sorted: Binary Search
* Cornor Case: [0], [ ];
> Solution:
    1. change the index mid to i; i = size()-mid;
    2. use the same method in 274 in the reserve order:
    >> **a.** if citations[i]<= index, not OK, go on i++;
    >> **b.** once citation[i]>index, OK,  `return i; //already -1`
    >> **c.** return last element <=target
```cpp
/* citations[i]:0,1,3,5,6
 *     index i :4,3,2,1,0
 *   index mid :0,1,2,3,4
*/
    ... ... 
    return citations.size()-l;
```
**35. search-insert-position**
> Solution: 
    1. Binary Search Type **3: Find 1st element > target**
    >> if target is not found, the 1st elemnent > target `will be the index we want. `

**69. sqrt-x**
* Binary Search, find last element < function(target);
* Cornor Case: the `number^2` will be `lager than integer`, use `’/'` rather than `'*'`

**74. search-a-2D-matrix**
* Compute the row and column in 2D matrix：
    * row = matrix.size();
    * column = matrix[0].size();
* **`Cornor Case`** 
    * [ [ ] ];
    * [ [1] ];
    * target < all the numbers -> check `if rowIndex <0`
> Solution: 
    1. find the `rowIndex` by search the fisrt column: `matrix[i][0]`
    2. when finding the index of row: we are finding the last element < target (if not the same)

## Stack & Queue
**394. decode-string**
* Stack处理嵌套的字符串：
    * 遇到']'说明短的循环结束，要在上一层的循环节上附加处理之后的循环节。
    * 数字可能大于10，所以循环处理，   `count=count*10+stack[i]-'0';`
    * 遇到'['，两个栈分别存`循环次数`和`当前字符串`
* 递归的方法：

**225. implement-stack-using-queue**
* Method：save the numbers in an reserve order in the final queue;
    * `push(x)` dequeue all in the reserve queue and save all the numbers in another queue `temp`, `push(x)` then enqueue the numbers in temp.
    * queue `reserve` save the final queue in a stack'stack way.

**394. implement-queue-using-stack**
* Method1：like 225
* Method2：only reserve the sort when `pop()` & `top()`

## Binary Tree
**144. Binary Tree Preorder Traversal**
* Non-Recursion:
```cpp
    /* push root to stack first  
     * then cout val
     * then push right & left node into stack */
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> out;
        TreeNode* temp = root;
        stack<TreeNode*> stack;
        stack.push(root);
        while(!stack.empty()){
            temp = stack.top();
            stack.pop();
            out.push_back(temp->val);
            if(temp->right) stack.push(temp->right);
            if(temp->left) stack.push(temp->left);
        }
    }
```
**94. Binary Tree Inorder Traversal**
* Non-Recursion: Use Stack
```cpp
    /* travel left node to the leaf first 
     * then cout val
     * then push right node into stack */
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
```

**94. Binary Tree Inorder Traversal**

**102. Binary Tree Level Order Traversal**
* Method:
    * Use queue to traverse every level;
    * Use `queue.size()` to save  current level then `clear()`;
## Divide & Conquer
**110. Balenced Binary Tree**
* Method: Divide into left and right subTree
* Tip: 
    * `if(depth==-1)` return -1; not balenced;
    * back to last layer: depth+1;

