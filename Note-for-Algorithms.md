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

##### Monotone Stack
* Usage1: find the last element 'x' which smaller than num[i] `on the left`

    |num|2|1|4|6|5|
    |:--:|:---:|:---:|:---:|:---:|:---:|
    |stack|[2,| [1,| [1,4 | [1,4,6 |[1,4,5|
    |last <|-|-|1|4|4|