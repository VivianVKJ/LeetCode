/*
 * @lc app=leetcode id=189 lang=cpp
 *
 * [189] Rotate Array
 *
 * https://leetcode.com/problems/rotate-array/description/
 *
 * algorithms
 * Easy (29.65%)
 * Total Accepted:    285.6K
 * Total Submissions: 963.3K
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * Given an array, rotate the array to the right by k steps, whereÂ kÂ is
 * non-negative.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * 1,2,3,4,5,6,7
 * 
 * Example 2:
 * 
 * 
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation: 
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * 
 * 
 * Note:
 * 
 * 
 * Try to come up as many solutions as you can, there are at least 3 different
 * ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 * 
 */

/* my solution: copy the last k elements
 * remind two exeptional cases: 
 * nums.size() & (k<0 || k>n)
 * Runtime: 24 ms, faster than 38.87% of C++ online submissions 
*  Memory Usage: 9.5 MB, less than 69.21% of C++ online submissions
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        if(nums.size()==0 || k<0)  // wrong input
            return;
        else if(k>nums.size())
            k %= nums.size();
        vector<int> copynum(k); 
        for(int i=0;i<k;i++)
            copynum[i] = nums[nums.size() - k + i];
        for (int i = nums.size()-1; i >= k;i--)
            nums[i]=nums[i-k]; //bianjie
        for (int i = 0; i < k;i++)
            nums[i] = copynum[i];
    }
};
*/

/* reverse(first,last);
* Runtime: 16 ms, faster than 100.00% of C++ online submissions
* Memory Usage: 9.5 MB, less than 61.07% of C++ online submissions
* a funtion to reverse the content of the vector
* from location first to last
* eg: reverse(nums.begin()+k,nums.end());
class Solution{
public:
    void rotate(vector<int>& nums, int k) {
        k %= nums.size();
        reverse(nums.begin(),nums.end());
        reverse(nums.begin(), nums.begin()+k);
        reverse(nums.begin()+k, nums.end());
    }
};
*/

/* Solution 3: push_back() & earse();
* iterator erase( const_iterator pos );
* iterator erase( const_iterator first, const_iterator last );
* Runtime: 216 ms, faster than 19.78% of C++ online submissions 
* Memory Usage: 9.8 MB, less than 13.23% of C++ online submissions
*/
class Solution{
public:
    void rotate(vector<int>& nums, int k){
        k%=nums.size();
        for (int i = 0;i<n-k;i++){
            nums.push_back(nums[0]); 
            nums.erase(nums.begin());
        }
    }
};

