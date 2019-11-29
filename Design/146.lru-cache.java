/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {
    Map<Integer,Integer> map = new LinkedHashMap<>();
    int cap = 0;
    
    public LRUCache(int capacity) {
        cap = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            int value = map.get(key);
            map.remove(key);
            map.put(key,value);
            return value;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key);
            map.remove(key);
            map.put(key,value);
        }
        else { //not contain
            if(map.size()==cap)
                map.remove(map.keySet().iterator().next());
            map.put(key,value);  
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

