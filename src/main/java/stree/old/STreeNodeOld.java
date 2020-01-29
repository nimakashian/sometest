package stree.old;

import java.util.Vector;

public class STreeNodeOld {
    private Object key;
    private int pointer = 0;

    Object getKey() {
        return key;
    }

    STreeNodeOld(Object key) {
        this.key = key;
    }

    private int size;
    private Vector objects = new Vector();

    void append(Object obj) {
        objects.add(obj);
        size++;
    }

    int getSize() {
        return size;
    }

    Object get(int index) {
        return objects.get(index);
    }

    boolean remove(int index) {
        objects.remove(index);
        size--;
        if (index < pointer)
            pointer--;
        return (size == 0);
    }

    void merge(STreeNodeOld mergeIn) {
        objects.addAll(pointer, mergeIn.objects);
        //objects.addAll(mergeIn.objects);
        pointer += mergeIn.pointer;
        size += mergeIn.size;
    }

    int nextIndex() {
        if (pointer >= size)
            return -1;
        else
            return pointer++;
    }

    public void resetIndex() {
        pointer = 0;
    }

    public static void main(String[] args) {
        for (int j = 0; j < 10; j++) {
            STreeNodeOld node = new STreeNodeOld("mori");

            long max = 0, min = Integer.MAX_VALUE, sum = 0;
            int i;
            for (i = 0; i < 1000000; i++) {
                long t1 = System.currentTimeMillis();
                node.append("hi0" + i);
                long t2 = System.currentTimeMillis();
                long dur = t2 - t1;
                if (dur > max) max = dur;
                if (dur < min) min = dur;
                sum = sum + dur;

            }
            System.out.print(j+"\t");
            System.out.print(min + "\t" + sum + "\t" + max+"\t");
//        System.out.println(i);
//        System.out.println(node.size);

            for (i = 0; i < 1000000; i++) {
                long t1 = System.currentTimeMillis();
                node.remove(0);
                long t2 = System.currentTimeMillis();
                long dur = t2 - t1;
                if (dur > max) max = dur;
                if (dur < min) min = dur;
                sum = sum + dur;

            }
            System.out.println(min + "\t" + sum + "\t" + max);
//        System.out.println(i);
//        System.out.println(node.size);


        }

    }
}