import performance.*;

import java.util.*;

public class M2 {
    public static void main(String[] args) {
        ArrayList<Long> addVector = new ArrayList<>();
        ArrayList<Long> remVector = new ArrayList<>();
        ArrayList<Long> addLinked = new ArrayList<>();
        ArrayList<Long> remLinked = new ArrayList<>();
        ArrayList<Long> addDeque = new ArrayList<>();
        ArrayList<Long> remDeque = new ArrayList<>();
        ArrayList<Long> addQeque = new ArrayList<>();
        ArrayList<Long> remQeque = new ArrayList<>();
        ArrayList<Long> addPrioQue = new ArrayList<>();
        ArrayList<Long> remPrioQue = new ArrayList<>();
        ArrayList<Long> addTreeSet = new ArrayList<>();
        ArrayList<Long> remTreeSet = new ArrayList<>();
        ArrayList<Long> addMyDeque = new ArrayList<>();
        ArrayList<Long> remMyDeque = new ArrayList<>();
        ArrayList<Long> addMyLink = new ArrayList<>();
        ArrayList<Long> remMyLink = new ArrayList<>();


        for (int SIZE = 0; SIZE <= 2000000; SIZE = SIZE + 1500) {

            Vector<Integer> vector = new Vector<>();
            SynchronizedLinkedList<Integer> linkedList = new SynchronizedLinkedList<>();
            SynchronizedArrayDequeu<Integer> arrayDeque = new SynchronizedArrayDequeu<>();
            SynchronizedPriorityQue<Integer> priorityQueue = new SynchronizedPriorityQue<>();
            SynchronizedTreeSet<Integer> treeSet = new SynchronizedTreeSet<>();
            SynchronizedMyDeque<Integer> myDeque = new SynchronizedMyDeque<>();
            SynchronizedMyLinkedList<Integer> myLinkedList = new SynchronizedMyLinkedList<>();


            long startTime=0;
            long endTime=0;
            long duration=0;

// MyQue add
            startTime = System.nanoTime();
            for (int i = 0; i < SIZE; i++) {
                myDeque.addLast(i);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000;
            addMyDeque.add(duration);

//            System.out.println("MyDeque add: " + duration);
// MyDeque remove
            startTime = System.nanoTime();
            for (int i = SIZE - 1; i >= 0; i--) {
                myDeque.removeFirst();
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000;
            remMyDeque.add(duration);
//            System.out.println("MyDeque remove:  " + duration);
            myDeque=null;
            Runtime.getRuntime().gc();



// Vector add
            startTime = System.nanoTime();
            for (int i = 0; i < SIZE; i++) {
                vector.add(i);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000;
            addVector.add(duration);
//            System.out.println("Vector add:  " + duration);
// Vector remove
            startTime = System.nanoTime();
            for (int i = SIZE - 1; i >= 0; i--) {
                vector.remove(0);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000;
            remVector.add(duration);
//            System.out.println("Vector remove:  " + duration);
            vector=null;
            Runtime.getRuntime().gc();

//// LinkedList add
//            startTime = System.nanoTime();
//            for (int i = 0; i < SIZE; i++) {
//                linkedList.addLast(i);
//            }
//            endTime = System.nanoTime();
//            duration = (endTime - startTime) / 1000;
//            addLinked.add(duration);
////            System.out.println("LinkedList add: " + duration);
//// LinkedList remove
//            startTime = System.nanoTime();
//            for (int i = SIZE - 1; i >= 0; i--) {
//                linkedList.removeFirst();
//            }
//            endTime = System.nanoTime();
//            duration = (endTime - startTime) / 1000;
//            remLinked.add(duration);
////            System.out.println("LinkedList remove:  " + duration);
//            linkedList=null;
//            Runtime.getRuntime().gc();

// ArrayDeque add
            startTime = System.nanoTime();
            for (int i = 0; i < SIZE; i++) {
                arrayDeque.addLast(i);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000;
            addDeque.add(duration);
//            System.out.println("ArrayDequeue add: " + duration);
// ArrayDeque remove
            startTime = System.nanoTime();
            for (int i = SIZE - 1; i >= 0; i--) {
                arrayDeque.removeFirst();
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000;
            remDeque.add(duration);
//            System.out.println("ArrayDeque remove:  " + duration);
            arrayDeque=null;
            Runtime.getRuntime().gc();

//// myLink add
//            startTime = System.nanoTime();
//            for (int i = 0; i < SIZE; i++) {
//                myLinkedList.addLast(i);
//            }
//            endTime = System.nanoTime();
//            duration = (endTime - startTime) / 1000;
//            addMyLink.add(duration);
////            System.out.println("ArrayDequeue add: " + duration);
//// myLink remove
//            startTime = System.nanoTime();
//            for (int i = SIZE - 1; i >= 0; i--) {
//                myLinkedList.removeFirst();
//            }
//            endTime = System.nanoTime();
//            duration = (endTime - startTime) / 1000;
//            remMyLink.add(duration);
////            System.out.println("ArrayDeque remove:  " + duration);
//            myLinkedList=null;
//            Runtime.getRuntime().gc();

            System.out.println(SIZE + " ---------------------------");
            if (SIZE % 180000 == 0) {
                System.out.println("addVector    "+addVector);
                System.out.println("addLinkedList"+addLinked);
                System.out.println("addArrayDeque"+addDeque);
                System.out.println("addMyDeque   "+addMyDeque);
                System.out.println("addMyLink   "+addMyLink);

                System.out.println();
                System.out.println("remVector    "+remVector);
                System.out.println("remLinkedList"+remLinked);
                System.out.println("remArrayDeque"+remDeque);
                System.out.println("remMyDeque   "+remMyDeque);
                System.out.println("remMyLink   "+remMyLink);
                System.out.println(" ---------------------------");
            }
        }
        System.out.println("addVector    "+addVector);
        System.out.println("addLinkedList"+addLinked);
        System.out.println("addArrayDeque"+addDeque);
        System.out.println("addMyDeque   "+addMyDeque);
        System.out.println("addMyLink   "+addMyLink);

        System.out.println();
        System.out.println("remVector    "+remVector);
        System.out.println("remLinkedList"+remLinked);
        System.out.println("remArrayDeque"+remDeque);
        System.out.println("remMyDeque   "+remMyDeque);
        System.out.println("remMyLink   "+remMyLink);
        System.out.println(" ---------------------------");

    }

}
