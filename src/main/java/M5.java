import performance.SynchronizedMyDataStructure;

import java.util.ArrayList;

public class M5 {
    public static void main(String[] args) {

        long startTime = 0;
        long endTime = 0;
        long duration = 0;

        ArrayList<Long> remMyDS = new ArrayList<>();


        for (int l = 1; l <= 5000; l=l+100){
            for (int k = 1; k <= 300; k=k+50) {
                ArrayList<Long> addMyDS = new ArrayList<>();
                for (int SIZE = 0; SIZE <= 800000; SIZE = SIZE + 1000) {
                    SynchronizedMyDataStructure myDataStructure = new SynchronizedMyDataStructure(l, k);
                    // My Data Structure add
                    startTime = System.nanoTime();
                    for (int i = 0; i < SIZE; i++) {
                        myDataStructure.addLast(i);
                    }
                    endTime = System.nanoTime();
                    duration = (endTime - startTime) / 1000;
                    addMyDS.add(duration);
//            System.out.println("ArrayDequeue add: " + duration);
//// My Data Structure remove
//                    startTime = System.nanoTime();
//                    for (int i = SIZE - 1; i >= 0; i--) {
//                        myDataStructure.removeFirst();
//                    }
//                    endTime = System.nanoTime();
//                    duration = (endTime - startTime) / 1000;
//                    remMyDS.add(duration);
////            System.out.println("ArrayDeque remove:  " + duration);
                    myDataStructure = null;
                    Runtime.getRuntime().gc();

//                    System.out.println(SIZE + " ---------------------------");


//                    System.out.println("addMyDS   " + remMyDS);
//                    System.out.println(" ---------------------------");


                }
                System.out.println("addMyDS   " + l + ":" + k + ":" + addMyDS);
            }

    }
    }
}
