package performance;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

public class SynchronizedLinkedList<T> {

//    private LinkedList<T> linkedList = new LinkedList<>();
    private LinkedList<T> linkedList = new LinkedList<>();

    public synchronized void addLast(T e) {
//        if(linkedList.size()>0)linkedList.removeFirst();
        linkedList.addLast(e);

    }
    public synchronized boolean add(T e) {
//        if(linkedList.size()>0)linkedList.removeFirst();
        return linkedList.add(e);

    }

    public synchronized T removeFirst() {

            return linkedList.removeFirst();

    }
//
//    public synchronized T remove(int i) {
//        if (linkedList.size() > 0)
//            return linkedList.remove(i);
//        return null;
//    }


}
