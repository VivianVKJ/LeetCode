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

***
