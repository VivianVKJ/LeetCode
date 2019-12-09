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
>     1. Binary Search Type **3: Find 1st element > target**
>
> > if target is not found, the 1st elemnent > target `will be the index we want. `

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

**145. Binary Tree Postorder Traversal**

**102. Binary Tree Level Order Traversal**
* Method 1： Just one queue:
    * Use queue to traverse every level;
    * Use `queue.size()` to save  current level then `clear()`;
```cpp
    while(!queue.empty()){
        int current_len = queue.size();  
        for(int i = 0; i <current_len;i++){
            ... ...
        }
```
* Method 2: Dummy Node
    * Add ‘#’ after each layer

## Binary Search Tree
**700. Search in a Binary Search Tree**
* Tip: recursion function must use **`return`**
```cpp
    if(val>root->val) return searchBST(root->right,val);
    else return searchBST(root->left,val);
```

## Divide & Conquer
**110. Balenced Binary Tree**
* Method: Divide into left and right subTree
* Tip: 
    * `if(depth==-1)` return -1; not balenced;
    * back to last layer: depth+1;

**98. Validate Binary Search Tree**
* Method: 
    * init recurion: root, `min-of-left` & `max-of-right` are both `null`
    * when going to `root.left`, update the max as `root`
    * when going to `root.right`, update the min as `root`
```java
    public boolean checkValid(TreeNode root, TreeNode min, TreeNode max){
        if(root==null) return true;
        if(min!=null && root.val<=min.val || max!=null && root.val>=max.val) return false;
        return checkValid(root.left, min, root) && checkValid(root.right, root, max);
    }
```

## Graph
**133. Clone Graph**
* Method:
    1. Clone `points`: Try to traverse: BFS<=>Queue
    2. Clone `edges`
> Solution:
    1. new ArrayList(queue) && new HashMap<Key,Value>
    2. copy root: put root to ArrayList
    3. while(queue): add node to copy 

## LinkList
**83 Remove Duplicates from Sorted List**
* Method:
    * find duplicate   
    * delete node: `previos.next = current.next;`
* Edge case: 
	* head=null?  
    * next = null?

**82 Remove Duplicates from Sorted List II**
> Dummy Node 
* Method 1: `Dummy Node`
    * Head may be deleted, init a dummy node; dummy.next = head;
    * head = dummy; (put the point start at dummy)
    * compare head.next & head.next.next; if equal...
* Method 2: `two pointers`
    * previous = dummy; -- slow pointer;
    * current -- fast pointer;
    * while equal, move fast to the next;
    * if previos.next = current; (no duplicate): both step one to the next;
    * else previous.next = current.next;  current = previous.next;

**206 Reverse Linked List**
* Method 1: Iterator `use previous and temp`
    * init: previous = null;
    * for each node: (**swap**: temp = a; a=b;b=temp)
        * temp = curr.next; 
        * curr.next = previous; 
        * previous = curr; 
        * curr = temp;
* Method 2: Recurision

**92 Reverse Linked List II**
* Method: 
    * init `dummy node`
    * reserve m~n
        * record `preM`, `startM`, `endN` & `postN`;
        * preM.next firstly set as null;
    * modify `preM.next` & `endN.next`;

**86 Partition List**
* Method: `dummy_left & dummmy_right`
* **key point:** `  right.next = null;`
    * or it will cause a cycle (Class 6 - 56:44)

**19 Remove Nth Node From End of List**
* `dummy node`

> Two Pointers 

**148 Sort List**
* main function: `recurision`
    * findMiddle()
    * sortList `right`; mid.next = null;  sortList `left`
    * merge
* **key point:** `mid.next = null;`
    * ??????
    * or it will cause a cycle (Class 6 - 56:44)

**143 Reorder List**
* Method:
    1. find mid
    2. reverse second half
    3. merge two halves

**142 Linked List Cycle II**
* Method:
    * a = head --cycle_start
    * b = cycle_start -- meet
    * c = meet --back_to_cycle_start
    * `b + c = cycle`
* equation:
    * fast = 2*slow --> a+b+n(b+c) = 2(a+b)
    * --> a+b = n(b+c)
    * --> a = (n-1)(b+c) +c = (n-1)*cycle + back_to_cycle_start
* Solution: after meet, put `slow` back to `head`, fast `step 1` each time, they will `meet at the start point `of the cycle
  
## DFS
* Modle Example
    * 46 Permulations
    * 78 Subsets
    * 79 Word Search

**46 Permulations**
```cpp
DFS(...){
    egde condition;
    for(i=0;i<n;i++){
        add current[i];
        DFS;
        current.remove(current.length-1)
    }
}
```

**78 Subsets**

```cpp
DFS(...int position ...){
    egde condition;
    for(i=position;i<n;i++){
        add current[i];
        DFS;
        current.remove(current.length-1)
    }
}
```

**99 Recover Binary Search Tree**

* If one more exceptions are found, override the current node to the Second Mistaken Node. 
* Because `if a series of mistaken nodes are found`, the only possible way to correct them with one swap is to switch the `head` and `tail` node.

**93 Restore IP address**

* need not record index
* use `s.substring`

**79 Word Search**

> Classic DFS in 2D Matrix 
>
> 1. if (`end` ) return true;
>
> 2. if(`wrong`) return false;
>
> 3. right condition: **make a record** & go to next layer
>
>    * traverse 4 conditions : if `ture`<=> found an answer; **`return ture`** 
>
>    ------
>
>    ???
>
>    * **remove record** & return false;



**77 Combination**

> 1. the valid range for the 1st position is [1, n-k+1]
> 2. the valid range for the i-th position is [number we selected for previous position+1, n-k+1+i]

```java
for(int i=index;i<=n-k+1+current.size();i++){……}
```



**662 Maximum Width of Binary Tree**

* Tips:  int ans cannot be modified by function,  use `int[] ans`
* DFS Method:  record left most nodes at each level

**139 Word Break**

* DFS is not appropriate in this question
* use HashSet is more convinient

**200 Number of Islands**

**695 Max Area of Island**

## BFS

**127 Word Ladder**
* Method: BFS
* find next word:
    1. find in word list (diff==1) `795ms`
        * queue.size() will change when queue.offer
        * record queue.size() when traverse queue
    2. change letter 1-26

## Two Pointers ##

**15 3Sum**
* the first number: base, `left`=base+1, `right` =nums.length-1;
    * outter loop: while(base<len)
    * inner loop: while(left<right)
* pointer movement condition in inner loop:
    * tempSum<target: left++;
    * tempSum>target: right--;
* Watch out: `remove duplicate`


**16 3Sum Closest**

**18 4Sum**

**3 Longest Substring Without Repeating Characters** 

* 最开始的思路错在：右指针碰到重复时，左指针不应该直接移动到右指针位置，否则会漏掉很多可能。
* Correct：when the right pointer meet a duplicate, map[s.atchar(left)] = false & `left++`; 

## Dynamic Programming
* Modle Questions
  * 120 Triangle

**139  Word Break**

The intuition behind this approach is that the given problem (s) can be divided into subproblems s1 and s2. If these subproblems individually satisfy the required conditions, the complete problem, s also satisfies the same. 

Method1: DP

1. State: boolean[i]  substring of lenth i can be break
2. Init: [0]=true;
3. Function: [abcde] --- (abcd)(e) || (abc)(de)..
4. Result: [n+1]

Method2: Recursion with memoization



## Hash

**260 HashSet**

```java
 Object[] t = hash.toArray();
        for(..)
        ans[i]=(int)t[i++];
```

