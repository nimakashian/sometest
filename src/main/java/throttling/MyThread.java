package throttling;

import com.google.common.util.concurrent.RateLimiter;

import java.io.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class MyThread implements Runnable {
    ThrottlingController throttlingController;
    Thread thread;
    long t;


    @Override
    public void run() {
        int i = 0;
//        RateLimiter r = RateLimiter.create(1);


        float delay = 0;

        while (true) {

            throttlingController.acquire();

            long t1 = System.currentTimeMillis();

            i++;
            File file = new File("out.com");
//            File file2=new File("out.com");
//            File file3=new File("out.com");
            try {
                PrintWriter printWriter = new PrintWriter(file);
//                PrintWriter printWriter2=new PrintWriter(file2);
//                PrintWriter printWriter3=new PrintWriter(file3);
//                printWriter.println("sdfjshgdafgkuahfuwyft ewoeiufdfkguhasugyerugyeuaergo;uire");
//                printWriter2.println("sdfjshgdafgkuahfuwyft ewoeiufdfkguhasugyerugyeuaergo;uire");
//                printWriter3.println("sdfjshgdafgkuahfuwyft ewoeiufdfkguhasugyerugyeuaergo;uire");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                if (i % 10 == 0) {
//                    int delay2 = 1000000000;
//                    if (i % 500 == 0) {
//
//                    }
                    Thread.sleep(6,860000);
                }

            } catch (Exception e) {

            }
            long t2 = System.currentTimeMillis();
            t += t2 - t1;


            delay = (float) ((1000 - t) / (float) 1000) ;
            System.out.println(t + "--," + i + "---," + (1000 * i / (float) (t)) + "--," +
                    delay + " ----,"
                    + throttlingController.s.availablePermits() + "---," + System.currentTimeMillis()
            );

            if (i == 1010) break;


        }

    }

    public MyThread() {

        thread = new Thread(this, "mythread");

    }

    public void setThrottlingController(ThrottlingController t) {
        this.throttlingController = t;
    }

    public void start() {
        thread.start();
    }

}
