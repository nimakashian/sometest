package statsdnetty;

import java.util.Hashtable;
import java.util.Map;

public class Counter<T> {
    private Map<T, Integer> map;

    public Counter() {
        this.map = new Hashtable<>();
    }

    public void add(T key) {
        Integer i = map.get(key);
        if (i == null) {
            i = 0;
        }
        map.put(key, i + 1);
    }

    public void remove(T key) {
        Integer i = map.get(key);
        if (i == null) {
            i = 0;
        }
        if (i <= 1 && map.containsKey(key))
            map.remove(key);
        else
            map.put(key, i - 1);
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
