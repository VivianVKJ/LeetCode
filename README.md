***
# Array

`A[i][j]` on the same diagonal have same value of ``i - j`

# [Binary Search](https://www.cnblogs.com/grandyang/p/6854825.html)

## **1. nums[i]==target**

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
## 1st nums[i]>=target 

OR:last nums[i]<target

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

## 1st nums[i]>target 

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
## Use subFuction as condition

## Function changes with index

## Problems

### 275.  attention to what gonna be return

***
# Stack #
##  Basic Usage
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
# Queue #
## Basic Usage
```cpp
queue<int> q;
q.empty(), q.frount(), q.back();
q.pop(),   q.push(x),  q.size();
```
***
# Tree #
##Binary Tree
* **Type**: 
    
    * `Preorder` root-left-right [144]
    * `Inorder`  left-root-right [94]
    * `Postorder` left-right-root [145]
    *  Level Order Traversal： `Queue` [102]
* **Traversal** **Method**:
    
    * Recursion 
    * Non-Recursion: Stack
    * Divide and Conquer (has return value)
* **Level Order Traversal <=> `BFS`**
    
    ```cpp
    while(!Queue.empty()) 
        for(this_level) 
    ```
* [Exercise](https://www.jiuzhang.com/qa/983/)
* [Homework](https://www.cnblogs.com/zcy-backend/p/6675158.html)
##Binary Search Tree
* **Definition**: 
    * The left subtree of a node contains only nodes with keys lesser than the node’s key.
    * The right subtree of a node contains only nodes with keys greater than the node’s key.
    * The left and right subtree each must also be a binary search tree. There must be no duplicate nodes.
* **Feature:**
    * Inorder Traversal of Binary Search Tree: `an increasing sequence of numbers`
***
# Divide & Conquer #
**Merge Sort**    `Stable`

####**Quick Sort**
* `Average：O(nlogn)` [Worst: O(n²)]

# Hashmap #
### Operations 

* Insert - O(1)
* Delete - O(1) 
* Find - O(1)

### Basic Use

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
public V get(Object key)
/* Returns the value to which the specified key is mapped,   * or null if this map contains no mapping for the key.
 */
public Set getOrDefault(Object key,Object defaultValue)
/* Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key. */
```

# DFS #
DFS <=> All Solutions

# BFS #
BFS <=> Start from one node

# Sorting #
    Collection.sort(nums)

* sorting an 2-dimension array by its element:

```java
Arrays.sort(nums,((x,y)->x[0]-y[0]));
```

* sort an 2-dimension array by dis

```java
Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
```

* sort an 2-dimiension arraylist by both start & end 

```java
 Collections.sort(events, (a, b) -> a[0] != b[0] ? a[0]-b[0] : a[1]-b[1]);
```

# Topological

* **Dependency  a—>b**
  * a happened before b
  * b depends on a
  * a.Indegree = 0, b.indegree=1;
* Method: HashMap+BFS;
* Example: Course Schedule, lc 207,210

# Two Pointers #



# String

- Basic Usage
  - public String substring(int beginIndex,int endIndex)

# Dynamic Programming

* Longest Comman *Sequence*
* Longest Comman *Substring* <should be continuous>



# Input & Output

* List<int[] > to int\[][]:  `result.toArray(new int\[0][0]);`
* Integer.MAX_VALUE = 2147483647
* Integer.MIN_VALUE = -2147483648
* String
  * Remove Space:  `str.replaceAll(" ","");`
  * Split with comma: `str.split(",");`
  * Split with **space**: `str.split("\\s+");`
  * Get with words: `word.replaceAll("[^a-z^A-Z]","");`

# Heap

* Implement: PriorityQueue

  * 1)  for HashMap

  ```java
  PriorityQueue<Integer> heap = new PriorityQueue<Integer>( 
  	(x,y) -> hash.get(x)- hash.get(y));
  ```

  ```java
  PriorityQueue<Integer> que = new PriorityQueue( new Comparator<Integer>() {
              public int compare(Character e1,Character e2) {
                  return e2 - e1;//Max-Heap
              } });
  PriorityQueue<Integer>que = new PriorityQueue<Integer>((x,y)->(y-x));
  ```
  



# Union Find

