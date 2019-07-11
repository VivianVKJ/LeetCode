***
## [Binary Search](https://www.cnblogs.com/grandyang/p/6854825.html)

**1. nums[i]==target**
```cpp
// Solution : [left,right) --> [left,mid), mid, [mid+1,right)
int find(vector<int>& nums, int target) {
    int left = 0, right = nums.size(); //[left,right)
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;  //[mid]
        else if (nums[mid] < target) left = mid + 1; //(mid,right)
        else right = mid; //[left,mid)
    }
    return -1;
}
```
**2. 1st nums[i]>=target** (OR:last nums[i]<target)
```cpp
//Solution: [left,right) -> [left,mid), [mid+1,right)
//[2,4,5,6,9],target=3; i=1 ; [0,1,1,1,1],target=1; i=1;
int find(vector<int>& nums, int target){
    int left=0, right=nums.size();
    while(left<right){
        int mid = left + (right-left) / 2;
        if(nums[mid]<target) left=mid+1;
        else right=mid; //[left,mid)
    }
    return right; 
}
//Find last nums[i]<target: return right-1;
```

**3. 1st nums[i]>target** 
```cpp
//Solution: [left,right) -> [left,mid), [mid+1,right)
int find(vector<int>& nums, int target){
    int left=0, right=nums.size();
    while(left<right){
        int mid = left + (right-left) / 2;
        if(nums[mid]<=target) left=mid+1;
        else right=mid; //[left,mid)
    }
    return right; 
}
//Find last nums[i]<=target: return right-1;
```
**4. use subFuction as condition**

**5. function changes with index?**
> #275 attention to what gonna be return 

***
## Stack ##
#####  Basic Usage
```cpp
stack<int> example;
    int input = 1;
    int output = 0;
    example.push(input);
    output = example.top();example.pop();
    example.empty();
```
##### Monotone Stack
* Usage1: find the last element 'x' which smaller than num[i] `on the left`

    |num|2|1|4|6|5|
    |:--:|:---:|:---:|:---:|:---:|:---:|
    |stack|[2,| [1,| [1,4 | [1,4,6 |[1,4,5|
    |last <|-|-|1|4|4|
***
## Queue ##
##### Basic Usage
```cpp
queue<int> q;
q.empty(), q.frount(), q.back();
q.pop(),   q.push(x),  q.size();
```
***
## Tree ##
####Binary Tree
* Type: 
    * `Preorder` root-left-right [144]
    * `Inorder`  left-root-right [94]
    * `Postorder` left-right-root [145]
    *  Level Order Traversal： `Queue` [102]
* Traversal Method:
    * Recursion 
    * Non-Recursion: Stack
    * Divide and Conquer (has return value)
* Level Order Traversal <=> `BFS`
    ```cpp
    while(!Queue.empty()) 
        for(this_level) 
    ```
* [Exercise](https://www.jiuzhang.com/qa/983/)
* [Homework](https://www.cnblogs.com/zcy-backend/p/6675158.html)
####Binary Search Tree
* Definition: 
    * The left subtree of a node contains only nodes with keys lesser than the node’s key.
    * The right subtree of a node contains only nodes with keys greater than the node’s key.
    * The left and right subtree each must also be a binary search tree. There must be no duplicate nodes.
* Feature:
    * Inorder Traversal of Binary Search Tree: `an increasing sequence of numbers`
***
## Divide & Conquer ##
####Merge Sort    `Stable`
####Quick Sort
* `Average：O(nlogn)` [Worst: O(n²)]

## Hashmap ##
* Basic Use
    ```java
    V put(K key,V value)
    /* Associates the specified value with the specified key in this map. 
     * If the map previously contained a mapping for the key, the old value is **replaced**.
     */
    V putIfAbsent(K key, V value)
    /* If the specified key is not already associated with a value 
     * (or is mapped to null) associates it with the given value and returns **null**
     * else returns the current **value**. 
     */
    boolean remove(Object key,Object value)
    /* Removes the mapping for the specified key from this map if present.
     */
    V get(Object key)
    /* Returns the value to which the specified key is mapped
     * or null if this map contains no mapping for the key.
     */
    ```