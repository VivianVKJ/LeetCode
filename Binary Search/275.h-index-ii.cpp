/*
 * @lc app=leetcode id=275 lang=cpp
 * the citations is already sorted
 * citations[i]:0,1,3,5,6
 *     index i :4,3,2,1,0
 *    index mid:0,1,2,3,4
 * index i'+i=citations.size()+1;
 * case [0],[100],[]
 * [275] H-Index II
 */
class Solution {
public:
    int hIndex(vector<int>& citations) {
        int l=0,i,r=citations.size(); //[l,r)
        //solution: [l,mid),[mid+1,r);
        
        while(l<r){
            int mid=(l+r)/2;
            i=citations.size()-mid;
            if(citations[mid]>=i){
                r=mid; // [l,mid)
            }
            else l=mid+1;  // [mid+1,r)   
        }
        return citations.size()-l;
    }
};

