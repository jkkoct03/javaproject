import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cache {
    
    static int initalCap = 3;


     
    public static void main(String[] args) {
        Map<Integer, Integer> map = new LinkedHashMap<>(initalCap, 0.75f, true);
        
        map.put(2,30);
        map.put(4, 10);
        map.put(1, 5);

        System.out.println(" ---- "+ map);
        int val = get(map, 1); // 5
        
        System.out.println(val + "   -------   " +map);



    }
    

    static int get(Map<Integer, Integer>map, int key) {
        int getValue = map.get(key);
        removeKey(map, key);
        map.put(key, getValue);
        return map.get(key);
    }

    static void  removeKey(Map<Integer, Integer>map,int key) {
        if(map.size() <= 0) {
            return;
        }
        map.remove(key);
    }

    static void addKey(Map<Integer, Integer>map,int key, int value) {
        
        if(map.size() <= initalCap) {
            map.put(key, value);
        } else {
            removeKey(map, key);
            map.put(key, value);
        }

    }


}
