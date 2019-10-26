import java.util.*;
class LRUCache {

 
    
    int cap;
    float load=(float)0.75;
    
    public LRUCache(int capacity) {
        cap=capacity;
    }
    
    Map<Integer,Integer> map=new LinkedHashMap<Integer,Integer>(cap,load,true){
        protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest)
        {
            return size()>cap;
        }
    };
    
    public int get(int key) {
        
        if(map.containsKey(key))
        {
            return map.get(key);
        }
        else
        {
            return -1;
        }
        
    }
    
    public void put(int key, int value) {
                 
        map.put(key,value);
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */