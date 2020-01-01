package performance;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class SynchronizedPriorityQue<T> {
    //    private LinkedList<T> linkedList = new LinkedList<>();
    private PriorityQueue<T> linkedList = new PriorityQueue<>();


    public synchronized boolean add(T e) {
//        if(linkedList.size()>0)linkedList.removeFirst();
        return linkedList.add(e);

    }

    public synchronized boolean remove(int i) {

        return linkedList.remove(i);

    }
//
//    public synchronized T remove(int i) {
//        if (linkedList.size() > 0)
//            return linkedList.remove(i);
//        return null;
//    }


}
