package stree;

import java.util.Vector;

public class STreeNode {
    private Object key;
    private int pointer = 0;

    Object getKey() {
        return key;
    }

    STreeNode(Object key) {
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

    void merge(STreeNode mergeIn) {
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
}