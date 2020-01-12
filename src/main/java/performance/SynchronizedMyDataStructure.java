package performance;

import java.util.ArrayDeque;

public class SynchronizedMyDataStructure<T> {
    private int intialSize = 1000;
    private ArrayDeque<Object[]> column;
    private Object[] row;
    protected int last = 0;
    protected int first = 0;

    public SynchronizedMyDataStructure(int initialSize) {
        this.intialSize = initialSize;
        column = new ArrayDeque<>();
        addColunm();
    }

    private void addColunm() {
        column.addLast(new Object[intialSize]);
    }
    private void removeColunm() {
        column.removeFirst();
    }

    public synchronized void addLast(T e) {
        if (column.peekLast().length == last) {
            addColunm();
            last = 0;
        } else {
            last++;

        }
        (column.peekLast())[last] = e;

    }

    public synchronized T removeFirst() {
        if(column.peekFirst().length == first){
            removeFirst();
        }else{
            first++;
        }
        T element = (T) (column.peekFirst())[first];
        return null;
    }

    public synchronized int size() {

        return column.size() * row.length;
    }

}
