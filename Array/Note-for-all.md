**Binary Search**

1. target == nums[i]    
> Solution 1 : [left,right) --> [left,mid), mid, [mid+1,right)
```cpp
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
2. target >= nums[i]