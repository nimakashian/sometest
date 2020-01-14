import performance.SynchronizedArrayDequeu;
import performance.SynchronizedMyDataStructure;

import java.util.ArrayList;

public class M6 {
    public static void main(String[] args) {

        long startTime = 0;
        long endTime = 0;
        long duration = 0;

        ArrayList<Long> remMyDS = new ArrayList<>();


        for (int k = 1; k <= 50000; k=k+500) {
            ArrayList<Long> addDeque = new ArrayList<>();
            for (int SIZE = 0; SIZE <= 800000; SIZE = SIZE + 1000) {
                SynchronizedArrayDequeu<Integer> arrayDeque = new SynchronizedArrayDequeu<>(k);
// ArrayDeque add
                startTime = System.nanoTime();
                for (int i = 0; i < SIZE; i++) {
                    arrayDeque.addLast(i);
                }
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000;
                addDeque.add(duration);
//            System.out.println("ArrayDequeue add: " + duration);
//// ArrayDeque remove
//                    startTime = System.nanoTime();
//                    for (int i = SIZE - 1; i >= 0; i--) {
//                        arrayDeque.removeFirst();
//                    }
//                    endTime = System.nanoTime();
//                    duration = (endTime - startTime) / 1000;
//                    remDeque.add(duration);
////            System.out.println("ArrayDeque remove:  " + duration);
                arrayDeque = null;
                Runtime.getRuntime().gc();


//                    System.out.println(SIZE + " ---------------------------");


//                    System.out.println("addMyDS   " + remMyDS);
//                    System.out.println(" ---------------------------");


            }
            System.out.println("addDeque   " + ":" + k + ":" + addDeque);
        }

    }

}
