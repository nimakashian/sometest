import performance.SynchronizedLinkedList;

import java.util.*;

public class M4 {
    public static void main(String[] args) {
        final int SIZE=1000000;
        final int ITER=50000;
        Random r = new Random();

        {
            Vector<String> v = new Vector<>();
            String str = "1";
            for (int i = 0; i < SIZE; i++) {
                v.add(new String(str + i));
            }
            System.out.println("initialized");
            float meant = 0;
            long t1 = 0;
            for (int i = 0; i < ITER; i++) {
                long t0 = System.currentTimeMillis();
                v.remove(0);
                t0 = System.currentTimeMillis() - t0;
                t1 = t1 + t0;
                meant = (float) t1 / (i + 1);

                v.add(new String(str));

            }
            System.out.println("meantR:" + 1000 * meant);
            for (int i = 0; i < ITER; i++) {
                long t0 = System.currentTimeMillis();
                v.add(new String(str));
                t0 = System.currentTimeMillis() - t0;
                t1 = t1 + t0;
                meant = (float) t1 / (i + 1);

            }
            System.out.println("meantA:" + 1000 * meant);
            for (int i = 0; i < ITER; i++) {
                long t0 = System.currentTimeMillis();
                v.get(r.nextInt(SIZE));
                t0 = System.currentTimeMillis() - t0;
                t1 = t1 + t0;
                meant = (float) t1 / (i + 1);

            }
            System.out.println("meantRead:" + 1000 * meant);
        }
        System.out.println("--------" );//RandomUtils.nextInt(1, 52 + 1)
        {
            SynchronizedLinkedList<String> v = new SynchronizedLinkedList<>() ;
            String str = "1";
            for (int i = 0; i < SIZE; i++) {

                    v.addLast(new String(str + i));

            }
            System.out.println("initialized");
            float meant = 0;
            long t1 = 0;
            for (int i = 0; i < ITER; i++) {
                long t0 = System.currentTimeMillis();

                    v.removeFirst();

                t0 = System.currentTimeMillis() - t0;
                t1 = t1 + t0;
                meant = (float) t1 / (i + 1);

                    v.addLast(new String(str));


            }
            System.out.println("meantR:" + 1000*meant);
            for (int i = 0; i < ITER; i++) {
                long t0 = System.currentTimeMillis();

                    v.addLast(new String(str));

                t0 = System.currentTimeMillis() - t0;
                t1 = t1 + t0;
                meant = (float) t1 / (i + 1);

            }
            System.out.println("meantA:" + 1000*meant);
            for (int i = 0; i < ITER; i++) {
                long t0 = System.currentTimeMillis();

                    //v.get(r.nextInt(SIZE));

                t0 = System.currentTimeMillis() - t0;
                t1 = t1 + t0;
                meant = (float) t1 / (i + 1);

            }
            System.out.println("meantRead:" + 1000*meant);
        }
    }
}
