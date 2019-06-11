/*
 * @lc app=leetcode id=275 lang=cpp
 * the citations is already sorted
 * citations[i]:6,5,3,1,0
 *     index i :0,1,2,3,4
 * index i>=citations[i]
 * case [0],[100],[]
 * [275] H-Index II
 */
class Solution {
public:
    int hIndex(vector<int>& citations) {
        int l=0,mid=0,r=citations.size()-1; //[l,r]
        while(l<r){
            mid=(l+r)/2;
            if(mid<citations[mid]){
                l=mid+1; // (mid,r]
            }
            else {
                r=mid; //[l,mid]
            }           
        }
        return mid;
    }
};

