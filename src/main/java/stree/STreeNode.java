package stree;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class STreeNode {
    private final int LIMIT = 5;
    private Object key;
    private int pointer = 0;
    private int size;
    private List<Vector> objectsArray = new ArrayList<>();

    STreeNode(Object key) {
        this.key = key;
        objectsArray.add(new Vector());
    }

    private Vector addObjects() {
        Vector lastObject = null;
        if (size != 0 && size % LIMIT == 0) {
            lastObject = new Vector();
            objectsArray.add(lastObject);
            return lastObject;
        } else {
            lastObject = objectsArray.get(size / LIMIT);
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
        int objectsIndex=index / LIMIT;
        int newIndex= index % LIMIT;
        return objectsArray.get(objectsIndex).get(newIndex);
    }

    boolean remove(int index) {
        int objectsIndex=index / LIMIT;
        int newIndex= index % LIMIT;

        objectsArray.get(objectsIndex).remove(newIndex);
        size--;
        if (index < pointer)
            pointer--;
        return (size == 0);
    }
    /*
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
*/

    Object getKey() {
        return key;
    }

    int getSize() {
        return size;
    }

    public static void main(String[] args) {
        STreeNode node = new STreeNode("mori");

        for (int i = 0; i<13 ;i++         ) {
            node.append("hi0"+i);

        }

        for (int i = 0; i<node.size ;i++         ) {
            System.out.println(node.get(i));

        }

        node.remove(1);
        node.remove(7);





    }
}