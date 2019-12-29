package performance;


import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.*;
import java.util.concurrent.TimeUnit;

    @State(Scope.Thread)
    public class CollectionBenchmark {
        private static final int SET_SIZE = 100000;
        ArrayList arrayList = new ArrayList();
        Vector vector=new Vector();
        Integer i=new Integer(0);
        Integer j=new Integer(0);


        @Setup
        public void setupCollections() {
            for(int k=0;k<1000000;k++){
                arrayList.add(i++);
                vector.add(j++);
            }

        }
        @Benchmark
        @BenchmarkMode(Mode.AverageTime)
        @OutputTimeUnit(TimeUnit.NANOSECONDS)
        public void testAddArrayList(Blackhole blackhole) {
//            System.out.println(i);
            blackhole.consume(arrayList.remove(0 ));
        }
        @Benchmark
        @BenchmarkMode(Mode.AverageTime)
        @OutputTimeUnit(TimeUnit.NANOSECONDS)
        public void testAddVector(Blackhole blackhole) {
//            System.out.println(j);
            blackhole.consume(vector.remove(0));
        }
    }
