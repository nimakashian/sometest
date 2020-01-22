import javax.print.attribute.IntegerSyntax;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.*;

public class M2_1 {
    public static void main(String[] args) {

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        Vector<Integer> integers =new Vector<>();

        arrayDeque.addLast(1);
        arrayDeque.addLast(2);
        arrayDeque.addLast(3);
        arrayDeque.addLast(4);
        arrayDeque.addLast(5);
        arrayDeque.addLast(6);
        arrayDeque.addLast(7);
        arrayDeque.addLast(8);

        Iterator<Integer> arrIterator=arrayDeque.iterator();
        while(arrIterator.hasNext()){
            System.out.println(arrIterator.next());
        }
        arrayDeque.removeFirst();
        arrayDeque.removeFirst();
        Iterator<Integer> arrIterator2=arrayDeque.iterator();
        while(arrIterator2.hasNext()){
            System.out.println(arrIterator2.next());
        }




        integers.add(10);
        integers.add(20);
        integers.add(30);
        integers.add(40);
        integers.add(50);
        integers.add(60);
        integers.add(70);
        integers.add(80);

        Iterator<Integer> itr=integers.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        integers.remove(0);
        integers.remove(0);
        Iterator<Integer> itr1=integers.iterator();
        while(itr1.hasNext()){
            System.out.println(itr1.next());
        }

    }

    public static void s() throws InterruptedIOException, NegativeArraySizeException, SocketException, Exception {
        throw new IOException();
    }
}
