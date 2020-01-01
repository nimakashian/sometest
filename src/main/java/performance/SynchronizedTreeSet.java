package performance;

import java.util.LinkedList;
import java.util.TreeSet;

public class SynchronizedTreeSet<T> {
    //    private LinkedList<T> linkedList = new LinkedList<>();
    private TreeSet<T> linkedList = new TreeSet<>();



    public synchronized boolean add(T e) {
//        if(linkedList.size()>0)linkedList.removeFirst();
        return linkedList.add(e);

    }



    public synchronized boolean remove(int i) {

            return linkedList.remove(i);

    }


}
