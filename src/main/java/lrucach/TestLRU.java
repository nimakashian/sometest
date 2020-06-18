package lrucach;

import org.apache.tomcat.util.collections.LRUCache;

public class TestLRU {
    static LRUCache updateEvents = new LRUCache(5);
    public static void main(String[] args) {
        updateEvents.put("1","hi");
        updateEvents.put("2","hi");
        updateEvents.put("3","hi");
        updateEvents.put("4","hi");
        updateEvents.put("5","hi");
        updateEvents.put("6","hi");
        updateEvents.put("7","hi");

        System.out.println("end");

    }
}
