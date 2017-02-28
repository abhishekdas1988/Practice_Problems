import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private Map<Integer,Integer> cache;
    private int max;
    
    public LRUCache(int capacity) {
        cache = new LinkedHashMap<Integer,Integer>();
        this.max = capacity;
    }
    
    public int get(int key) {
        if(this.cache.containsKey(key)){
            return this.cache.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(this.cache.size()==max){
            for(Integer i: this.cache.keySet()){
                this.cache.remove(i);
                break;
            }
            this.cache.put(key,value);
            
        }
        else{
            this.cache.put(key,value);
        }
        
    }
}