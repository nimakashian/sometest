import performance.SynchronizedArrayDequeu;

import java.util.ArrayList;
import java.util.Vector;

public class M7 {
    public static void main(String[] args) {

        long startTime = 0;
        long endTime = 0;
        long duration = 0;

        ArrayList<Long> remMyDS = new ArrayList<>();


            for (int k = 0; k <= 250; k = k + 1) {
                ArrayList<Long> addVector = new ArrayList<>();
                for (int SIZE = 0; SIZE <= 800000; SIZE = SIZE + 1000) {
                    Vector<Integer> vector = new Vector<>(k);
// Vector add
                    startTime = System.nanoTime();
                    for (int i = 0; i < SIZE; i++) {
                        vector.add(i);
                    }
                    endTime = System.nanoTime();
                    duration = (endTime - startTime) / 1000;
                    addVector.add(duration);

                    vector = null;
                    Runtime.getRuntime().gc();



//                    System.out.println("addvector   " +l+ ":" + k + ":" + addVector);

                }
                System.out.println("addvector   " +":" + k + ":" + addVector);
            }

    }

}

