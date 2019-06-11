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
  * input [];  h=0;
  * input [100]; h=1;
> Solution:  	
sort(citations.begin(), citations.end(),greater<int>());  //sort from big to small

```cpp
/*
 * h papers at least h citations
 * citations[i]:6,5,3,1,0
 *     index i :0,1,2,3,4
 */
class Solution {
public:
    int hIndex(vector<int>& citations) {
        sort(citations.begin(), citations.end(),greater<int>());
		for (int i = 0; i < citations.size(); i++) 
			if (i >= citations[i])
				return i;
		return citations.size();
      }
};
```


