package performance;


import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.*;
import java.util.concurrent.TimeUnit;

    @State(Scope.Thread)
    public class CollectionBenchmark {
        private static final int SET_SIZE = 100000;
        ArrayList<Integer> arrayList = new ArrayList<>();
        Vector<Integer> vector=new Vector<>();
        SynchronizedLinkedList<Integer> linkedList=new SynchronizedLinkedList<>();



        @Setup
        public void setupCollections() {
//            for(int k=0;k<1000000;k++){
//                arrayList.add(k);
//                vector.add(k);
//                linkedList.addLast(k);
//            }

        }
//        @Benchmark
//        @BenchmarkMode(Mode.AverageTime)
//        @OutputTimeUnit(TimeUnit.NANOSECONDS)
        public void testAddArrayList(Blackhole blackhole) {
//            System.out.println(i);
            blackhole.consume(arrayList.add(0 ));
        }
        @Benchmark
        @BenchmarkMode(Mode.AverageTime)
        @OutputTimeUnit(TimeUnit.MILLISECONDS)
        public void testAddVector(Blackhole blackhole) {
            vector=new Vector<>();
            for(int k=0;k<1000000;k++){
//                arrayList.add(k);
                vector.add(k);
//                linkedList.addLast(k);
            }
            blackhole.consume(vector.add(0));
        }
        @Benchmark
        @BenchmarkMode(Mode.AverageTime)
        @OutputTimeUnit(TimeUnit.MILLISECONDS)
        public void testAddLinkedList(Blackhole blackhole) {
            linkedList=new SynchronizedLinkedList<>();
            for(int k=0;k<1000000;k++){
//                arrayList.add(k);
//                vector.add(k);
                linkedList.addLast(k);
            }
            blackhole.consume(true);
        }
    }
