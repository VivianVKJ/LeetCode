/*
 * @lc app=leetcode id=240 lang=cpp
 * efficient algorithm: binary search
 * [240] Search a 2D Matrix II
 * [[-1,3]] target=3;
 */
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if(matrix.empty()||matrix[0].empty()) return false;
        if(matrix[0][0]>target) return false;

        int row=matrix.size(), column = matrix[0].size();
        
        int l = 0, r = row-1;
        while(l<=r){ 
            int mid = (l+r)/2;
            //Tip: [l,r] -> [l,mid-1];[mid+1,r];
            if(matrix[mid][0]==target) return true;
            else if(matrix[mid][0]<target) l=mid+1;
            else r=mid-1;
        }
        if(r<0) return false;
        int rowIndex = r;

        for(int i = 0; i<=rowIndex;i++){
            if(matrix[i][column-1]>=target){
                l=0; r=column-1;
                while(l<=r){
                    int mid = (l+r)/2;
                    if(matrix[i][mid]==target) return true;
                    else if(matrix[i][mid]<target) l=mid+1;
                    else r=mid-1;
                }
            }
        }
        return false;
    }
};

