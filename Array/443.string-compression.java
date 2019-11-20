/*
 * @lc app=leetcode id=443 lang=java
 *
 * [443] String Compression
 */

// @lc code=start
class Solution {

    public int compress(char[] chars) {
        int n = chars.length,i=0;
        int res_index=0;
    
        while(i<n){
            char temp = chars[i];
            int start = i;
            while(i<n && chars[i]==temp)
                i++;
            if(i-start>1){ //count > 1
                int count = i-start, digit = 0;
                int[] inverse = new int[4];
                
                while(count!=0){
                    inverse[digit++]=count%10;
                    count/=10;
                }
                for(int d=0;d<digit;d++){
                    chars[res_index+d+1] =(char) (inverse[digit-d-1]+(int)'0');             
                }
                res_index+=digit;
                
            }
            if(i<n){
                res_index+=1;
                chars[res_index] = chars[i]; //no need to check if res_index==i
            }
        }
        return res_index+1;
    }

    public int compress_solution(char[] chars) {
        int indexAns = 0, index = 0;
        while(index < chars.length){
            char currentChar = chars[index];
            int count = 0;
            while(index < chars.length && chars[index] == currentChar){
                index++;
                count++;
            }
            chars[indexAns++] = currentChar;
            if(count != 1)
                for(char c : Integer.toString(count).toCharArray()) 
                    chars[indexAns++] = c;
        }
        return indexAns;
    }
}
// @lc code=end

