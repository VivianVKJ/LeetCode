/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 */

// @lc code=start
class Solution {
    public static Integer[] cache = new Integer[31]; //reference type defalt null
    public int fib(int N){
        if(N<=1) return N;
        cache[0] = 0;
        cache[1] = 1;
        return fibb(N);    
    }
    public static int fibb(int n){
        if(cache[n]!=null) return cache[n];
        cache[n] = fibb(n-2)+fibb(n-1);
        return cache[n];
    }

    public int fib_approach(int N){
        if(N<=1) return N;
        int pre_two = 0, pre_one = 1;
        int res = 0;
        for(int i=2;i<=N;i++){
            res = pre_one + pre_two; 
            pre_two = pre_one;
            pre_one = res;
        }
        return res;
    }
    public int fib_bottom_Up(int N){
        if(N<=1) return N;
        int[] mem = new int[N+1];
        mem[0]=0; mem[1]=1;
        for(int i=2;i<=N;i++){
            mem[i] = mem[i-1]+mem[i-2];
        }
        return mem[N];
    }
    public  int fib_recursion(int N) {
        if(N==0 || N ==1) return N;
        return fib_recursion(N-1)+fib_recursion(N-2);
        //2^n the slowest method
    }
}
// @lc code=end

