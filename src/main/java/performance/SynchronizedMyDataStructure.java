package performance;

//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class SynchronizedMyDataStructure<T> {
    private int rowSize = 1000;
    private int columnSize = 100;
    private ArrayDeque<Object[]> column;
    private Object[] row;
    private long size = 0;
    protected int last = 0;
    protected int first = 0;

    public SynchronizedMyDataStructure(int rowSize , int columnSize) {
        this.rowSize = rowSize;
        this.columnSize = columnSize;
        column = new ArrayDeque<>(columnSize);
        addColunm();

    }


    public SynchronizedMyDataStructure() {

    }

    private void addColunm() {
        column.addLast(new Object[rowSize]);
    }

    private void removeColunm() {
        column.removeFirst();
    }

    public synchronized void addLast(T e) {
        if (rowSize == last) {
            addColunm();
            last = 0;
        }
        (column. peekLast())[last++] = e;
        size++;

    }

    public synchronized T removeFirst() {
        if (size == 0)
            throw new NoSuchElementException("zero size");

        T element = (T) (column.peekFirst())[first];
        (column.peekFirst())[first++] = null;
        if (rowSize == first) {
            removeColunm();
            first = 0;
        }
        size--;
        return element;
    }

    public synchronized long size() {

        return size;
    }

    public static void main(String[] args) {
        SynchronizedMyDataStructure<Integer> dataStructure = new SynchronizedMyDataStructure<>();
        dataStructure.addLast(new Integer(5));
        System.out.println(dataStructure.size());
        dataStructure.addLast(new Integer(6));
        dataStructure.addLast(new Integer(7));
        dataStructure.addLast(new Integer(8));
        System.out.println(dataStructure);
        System.out.println(dataStructure.size());
        dataStructure.removeFirst();
        System.out.println(dataStructure);
        System.out.println(dataStructure.size());
        dataStructure.addLast(new Integer(9));
        dataStructure.addLast(new Integer(10));
        System.out.println(dataStructure.size());
        System.out.println(dataStructure);
        dataStructure.removeFirst();
        dataStructure.removeFirst();
        dataStructure.removeFirst();
        dataStructure.removeFirst();
        dataStructure.removeFirst();
        dataStructure.removeFirst();
        dataStructure.removeFirst();
        dataStructure.removeFirst();
        dataStructure.removeFirst();
        System.out.println(dataStructure.size());
        System.out.println(dataStructure);


    }

}
