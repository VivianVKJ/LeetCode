/*
 * @lc app=leetcode id=69 lang=cpp
 * [69] Sqrt(x)
 * case: 2147395599 integer overflow
 * change * to / or use long int
 */
class Solution {
public:
    int mySqrt(int x) {
        if(x<=1) return x;
        else {
            long int l= 1, r=x;
            while(l<r){  //[l,r)
                long int mid = (l+r)/2;
                if(x/mid==mid) return mid;
                else if(x/mid>mid) l=mid+1;
                else r=mid;
            }
            return r-1; 
        }
    }
};

