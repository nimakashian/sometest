package throttling;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThrottlingController throttlingController=new ThrottlingController(Logger.getLogger("test"), "trttl", 1000 );
//        throttlingController.acquire();
        throttlingController.start();


//        Helper h=new Helper();
//        h.start();


        MyThread myThread=new MyThread();
        myThread.setThrottlingController(throttlingController);
        myThread.start();

//        Thread.sleep(100000);
    }

}
