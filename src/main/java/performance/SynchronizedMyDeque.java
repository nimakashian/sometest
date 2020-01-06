package performance;

import java.util.PriorityQueue;

public class SynchronizedMyDeque<T> {
    //    private LinkedList<T> linkedList = new LinkedList<>();
    private MyArrayDequeu<T> linkedList = new MyArrayDequeu<>();


    public synchronized void addLast(T e) {
//        if(linkedList.size()>0)linkedList.removeFirst();
        linkedList.addLast(e);

    }

    public synchronized T removeFirst() {

        return linkedList.removeFirst();

    }

    public synchronized int size(){
        return linkedList.size();
    }


}
