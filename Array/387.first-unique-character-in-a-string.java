/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */
class Solution {
    public int firstUniqChar_Array(String s) {
        int[] map = new int[256];
        int ans = 0;
        if(s.length()<=0) return -1;
        for(int i = 0;i<s.length();i++){
            map[s.charAt(i)]++;
        }
        for(int i = 0;i<s.length();i++){
            if(map[s.charAt(i)]==1)
                return i;
        }
        return -1;
    }

    /* This implementation differs from HashMap:
     * it maintains a doubly-linked list running through all of its entries. 
     * This linked list defines the iteration ordering, 
     * in which keys were inserted into the map (insertion-order).
    */
    public int firstUniqChar(String s) {
        int n =s.length();
        if(n<=1) return n-1;
        Map<Character,Integer> map = new LinkedHashMap<>(); //duplicate then delete
        Set<Character> set = new HashSet<>(); //mantain all that met
        for(int i=0;i<n;i++){
            char curr = s.charAt(i);
            if(set.contains(curr)){
                if(map.get(curr)!=null)
                    map.remove(curr);
            }
            else{
                map.put(curr,i);
                set.add(curr);
            }
        }
        return map.entrySet().iterator().next().getValue();
    }
    public int firstUniqChar_Nov26Hash(String s) {
        int n =s.length();
        if(n<=1) return n-1;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            char curr = s.charAt(i);
            map.put(curr,map.getOrDefault(curr,0)+1);
        }
        for(int i=0;i<n;i++){
            if(map.get(s.charAt(i))==1)
                return i;
        }
    return -1; 
    }
}

