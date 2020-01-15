package genericstatic;

import java.util.ArrayDeque;
import java.util.Vector;

public class M {
    public static void main(String[] args) {

        Vector<Integer> v = getVector();
        v.add(1);
        v.add(2);
        v.add(3);
        v.add(4);
        v.add(5);
        System.out.println("erwe");
        Integer i = v.get(0);

        ArrayDeque<Integer> arrayDeque =new ArrayDeque<>();
//        arrayDeque.
    }

    public static <E> Vector<E> getVector(){
        return new Vector<>();
    }
}
