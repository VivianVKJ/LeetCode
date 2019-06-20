/*
 * @lc app=leetcode id=74 lang=cpp
 * [74] Search a 2D Matrix
 */
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        //Error3: special case [[]] 
        if(matrix.empty() || matrix[0].empty()) return false;
        int row = matrix.size(); //hang
        int column = matrix[0].size();  //lie

        //Error1: l & r are both index!
        //int l = matrix[0][0], r=matrix[row-1][0]; //[l,r]
        int l = 0, r = row-1;
        while(l<=r){ 
            int mid = (l+r)/2;
            //Tip: [l,r] -> [l,mid-1];[mid+1,r];
            if(matrix[mid][0]==target) return true;
            else if(matrix[mid][0]<target) l=mid+1;
            else r=mid-1;
        }
        //Error4: check if r<0
        if(r<0) return false;
        //Error2:return right not right -1
        int rowIndex = r;
        
        l = 0;
        r = column-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(matrix[rowIndex][mid]==target) return true;
            else if(matrix[rowIndex][mid]<target) l=mid+1;
            else r=mid-1;
        }
        return false;
    }
};