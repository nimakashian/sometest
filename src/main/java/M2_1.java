import performance.*;

import java.util.Vector;

public class M2_1 {
    public static void main(String[] args) {
        Vector<Integer> v=new Vector<>();
        MyArrayDequeu<Integer> sd=new MyArrayDequeu<>();

//        System.out.println(v.size());
//        v.remove(0);

        sd.removeFirst();
        System.out.println(sd.size());
    }
}
