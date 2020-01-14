package performance;

import org.eclipse.jetty.util.ArrayQueue;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class SynchronizedArrayDequeu<T> {

    private int size;

    public SynchronizedArrayDequeu(int size) {
        this.size = size;
        linkedList = new ArrayDeque<T>(size);
    }

    //    private LinkedList<T> linkedList = new LinkedList<>();
    private ArrayDeque<T> linkedList = new ArrayDeque<T>();

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
