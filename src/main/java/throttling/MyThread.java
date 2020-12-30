package throttling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import org.slf4j.Logger;

public class MyThread implements Runnable {
    ThrottlingController throttlingController;
    Thread thread;
    long t;
    Logger log;

    public MyThread(ThrottlingController throttlingController, Logger log) {
        this.throttlingController = throttlingController;
        this.log = log;
        thread = new Thread(this, "mythread");
    }

    @Override
    public void run() {
        int i = 0;
//        RateLimiter r = RateLimiter.create(1);


        float delay = 0;

        while (true) {

            throttlingController.acquire();


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


            log.info(throttlingController.getAvailablePermits() + "---," + System.currentTimeMillis());
        }

    }

    public MyThread() {

        thread = new Thread(this, "mythread");

    }


    public void start() {
        thread.start();
    }


}
