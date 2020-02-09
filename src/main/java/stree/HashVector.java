package stree;

import java.util.Hashtable;

public class HashVector {
    static Hashtable<Integer, String> integerStringHashtable;


    public static void main(String[] args) {
        testHash();
    }
    static void testHash() {
        Hashtable<Integer, String> integerStringHashtable = new Hashtable<>();
        long max = 0, min = Integer.MAX_VALUE, sum = 0;
        int i;
        for (i = 0; i < 1000000; i++) {
            long t1 = System.currentTimeMillis();
            integerStringHashtable.put(i,"hi"+i);
            long t2 = System.currentTimeMillis();
            long dur = t2 - t1;
            if (dur > max) max = dur;
            if (dur < min) min = dur;
            sum = sum + dur;


        }
        System.out.print(min + "\t" + sum + "\t" + max+"\t");
        System.out.println();

        max = 0; min = Integer.MAX_VALUE; sum = 0;
        for (i = 0; i < 1000000; i++) {
            long t1 = System.currentTimeMillis();
            integerStringHashtable.remove(i);
            long t2 = System.currentTimeMillis();
            long dur = t2 - t1;
            if (dur > max) max = dur;
            if (dur < min) min = dur;
            sum = sum + dur;


        }
        System.out.print(min + "\t" + sum + "\t" + max+"\t");
        System.out.println();

    }
}
