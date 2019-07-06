/*
 * @lc app=leetcode id=278 lang=cpp
 * testcase: '2147483647\n2147483647'
 * tip: use l+(r-l)/2 rather than (l+r)/2
 * [278] First Bad Version
 */
// Forward declaration of isBadVersion API.
bool isBadVersion(int version);

class Solution {
public:
    int firstBadVersion(int n) {
        int l=1,r=n; //[l,r+1) -- [l,mid) [mid+1,r]
        while(l<r){
            int mid = l+(r-l)/2;
            if(!isBadVersion(mid))  l=mid+1;
            else r = mid;
        }
        if(r>2147483647) return 2147483647-r;
        else return r;
    }
};
