class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList();        
        if(matrix.length==0) return res;
        int m = matrix.length, n = matrix[0].length;
        
        int x_begin = 0, y_begin = 0, x_end = m-1, y_end = n-1;
        int x = x_begin, y = y_begin;
        while(res.size()<n*m){
            for(y=y_begin; y<=y_end; y++) 
                res.add(matrix[x_begin][y]);
            x_begin++;
            if(res.size()>=m*n) break;
            
            for(x=x_begin; x<=x_end; x++) 
                res.add(matrix[x][y_end]);
            y_end--;
            if(res.size()>=m*n) break;
            
            for(y=y_end; y>=y_begin; y--) 
                res.add(matrix[x_end][y]);
            x_end--;
            if(res.size()>=m*n) break;
          
            for(x=x_end;x>=x_begin;x--) res.add(matrix[x][y_begin]);
            y_begin++;
            
            
//             System.out.printf("res.size = %d ", res.size());
            
        }
        return res;
    }
}
// @lc code=end

