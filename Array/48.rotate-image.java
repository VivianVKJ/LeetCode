/*
 * @lc app=leetcode id=48 lang=java
 * [[1,2,3],[4,5,6],[7,8,9]]
 * [[ 5, 1, 9,11],[ 2, 4, 8,10],[13, 3, 6, 7],[15,14,12,16]]
 * [48] Rotate Image
 */

class Solution {
    public void rotate(int[][] matrix){
        int n = matrix[0].length;
        //first reverse up to down
        for(int row=0;row<n/2;row++){
            for(int i=0;i<n;i++){
                int temp = matrix[row][i];
                matrix[row][i] = matrix[n-row-1][i];
                 matrix[n-row-1][i] = temp;
            }
        }
        //then swap the symmetry   
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }     
    }

    public void rotate_by_element(int[][] matrix) {
        int n = matrix[0].length;
        for(int turn=0;turn<n/2;turn++){
            //System.out.printf("[turn=%d]",turn);
            for(int i=turn;i<n-turn-1;i++){
                int temp = matrix[turn][i];
                matrix[turn][i] = matrix[n-i-1][turn];
                matrix[n-i-1][turn] = matrix[n-turn-1][n-i-1];
                matrix[n-turn-1][n-i-1] = matrix[i][n-turn-1];
                matrix[i][n-turn-1] = temp;
            }
        }
    }

}


