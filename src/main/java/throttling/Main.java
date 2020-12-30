package throttling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;
import java.util.TimerTask;



public class Main {
    public static void main(String[] args) throws InterruptedException {
        Logger log = LoggerFactory.getLogger("test");
        ThrottlingController throttlingController=new ThrottlingController(log, "trttl", 100 );
//        throttlingController.acquire();
        throttlingController.start();


//        Helper h=new Helper();
//        h.start();


        MyThread myThread=new MyThread(throttlingController, log);
        myThread.start();

//        Thread.sleep(100000);
    }

}
