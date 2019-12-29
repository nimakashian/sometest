package performance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();
        Vector vector=new Vector();
// ArrayList add
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("ArrayList add:  " + duration);
// LinkedList add
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList add: " + duration);
// vector add
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            vector.add(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("vector add: " + duration);

// ArrayList get
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.get(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("ArrayList get:  " + duration);
// LinkedList get
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedList.get(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList get: " + duration);
// vector get
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            vector.get(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("vector get: " + duration);
// ArrayList remove
        startTime = System.nanoTime();
        for (int i = 9999; i >=0; i--) {
            arrayList.remove(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("ArrayList remove:  " + duration);
// LinkedList remove
        startTime = System.nanoTime();
        for (int i = 9999; i >=0; i--) {
            linkedList.remove(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList remove: " + duration);

// vector remove
        startTime = System.nanoTime();
        for (int i = 9999; i >=0; i--) {
            vector.remove(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("vector remove: " + duration);
    }



}
