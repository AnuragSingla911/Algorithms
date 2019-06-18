package algo;

import java.util.HashMap;
import java.util.LinkedList;

public class lru {
	
	public static void main(String[] args) {
		Cache c = new Cache(1);
		c.set(2,1);
		c.set(2, 2);
		System.out.println(c.get(2));
		c.set(1, 1);
		c.set(4, 1);
		System.out.println(c.get(2));
	}

}

class Cache {
    LinkedList<Integer> list = null;
    HashMap<Integer,Integer> cache = null;
    int cap;
    public Cache(int capacity) {
        cache = new HashMap<Integer,Integer>(capacity);
        list = new LinkedList<Integer>();
        cap = capacity;
    }
    
    public int get(int key) {
        
        if(cache.get(key) != null){
             list.remove((Integer)key);
             list.addFirst((Integer)key);
            return cache.get(key);
        }
        
        return -1;
        
    }
    
    public void set(int key, int value) {
        if(cache.get(key) != null){
            cache.put(key,value);
            list.remove((Integer)key);
            list.addFirst((Integer)key);
        }else{
            
        		if(list.size() == cap) {
        			Integer e = list.removeLast();
        			cache.remove(e);
        		}
            cache.put(key,value);
            list.addFirst((Integer)key);
            
        }
    }
}