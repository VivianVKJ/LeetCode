
/*
 * @lc app=leetcode id=46 lang=java
 * DFS:
 * Recurision: choose one num and add to currentlist
 * back to last layer: move this num from currentlist and record
 * Quit condition: list.size()==nums.size()
 * [46] Permutations
 */
class Solution {
    
    public List<List<Integer>> permute(int[] nums) {
        if(nums==null) return null;
        List currentlist = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        boolean[] record = new boolean[nums.length];
        //Boolean!=boolean (like Integer & int)
        //if use Boolean, need initialize
        //for(int i=0;i<record.length;i++) record[i]=false;
        DFS(nums,currentlist,record,res);
        return res;
    }
    public void DFS (int[] nums,List currentlist,
                    boolean[] record,List<List<Integer>> res){
        if(nums.length==currentlist.size()) {
            res.add(new ArrayList<>(currentlist));
            return;   //end condition
        }
        else{
            for (int i=0;i<nums.length;i++){

                if(record[i]==false){
                    currentlist.add(nums[i]);
                    record[i]=true;
                    DFS(nums,currentlist,record,res);
                    record[i]=false;
                    currentlist.remove(currentlist.size()-1);
                }
            }
        }
    }
}

