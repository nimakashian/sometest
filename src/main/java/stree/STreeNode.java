package stree;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class STreeNode {
    private int LIMIT = 1000;
    private Object key;
    private int pointer = 0;
    private int size;
    private List<Vector> objectsArray = new ArrayList<>();

    STreeNode(Object key) {
        this.key = key;
        objectsArray.add(new Vector());
    }

    private Vector addObjects() {
        int lastObjectIndex = objectsArray.size() - 1;
        Vector lastObject = objectsArray.get(lastObjectIndex);
        ;
        if (lastObject.size() == LIMIT) {
            lastObject = new Vector();
            objectsArray.add(lastObject);
            return lastObject;
        }
        return lastObject;
    }


    private void removeObjects() {
    }


    void append(Object obj) {
        Vector lastObject = addObjects();
        lastObject.add(obj);
        size++;
    }


    Object get(int index) {
        int objectsIndex = 0;
        int newIndex = 0;
        int curIndex = index;
        for (; objectsIndex < objectsArray.size(); objectsIndex++) {
            newIndex = curIndex;
            curIndex = curIndex - objectsArray.get(objectsIndex).size();
            if (curIndex < 0)
                break;
        }
        return objectsArray.get(objectsIndex).get(newIndex);
    }

    boolean remove(int index) {
        int objectsIndex = 0;
        int newIndex = 0;
        int curIndex = index;
        for (; objectsIndex < objectsArray.size(); objectsIndex++) {
            newIndex = curIndex;
            curIndex = curIndex - objectsArray.get(objectsIndex).size();
            if (curIndex < 0)
                break;
        }

        objectsArray.get(objectsIndex).remove(newIndex);
        if (objectsArray.get(objectsIndex).size() == 0)
            objectsArray.remove(objectsIndex);
        size--;
        if (index < pointer)
            pointer--;
        return (size == 0);
    }

    void merge(STreeNode mergeIn) {
        objectsArray.addAll(pointer, mergeIn.objectsArray);
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


    Object getKey() {
        return key;
    }

    int getSize() {
        return size;
    }

    public static void main(String[] args) {
        for (int j = 1000; j < 50000; j = j + 1000) {
            STreeNode node = new STreeNode("mori");
            node.LIMIT = j;

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
            System.out.print(node.LIMIT+"\t");
            System.out.print(min + "\t" + sum + "\t" + max+"\t");
//        System.out.println(i);
//        System.out.println(node.size);

            for (i = 0; i < 1000000; i++) {
                long t1 = System.currentTimeMillis();
                node.remove((node.objectsArray.size() - 1) * node.LIMIT);
                long t2 = System.currentTimeMillis();
                long dur = t2 - t1;
                if (dur > max) max = dur;
                if (dur < min) min = dur;
                sum = sum + dur;
//                System.out.println(min + "\t" + sum + "\t" + max);
            }
            System.out.println(min + "\t" + sum + "\t" + max);
//        System.out.println(i);
//        System.out.println(node.size);
        }

    }
}