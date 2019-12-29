package throttling;


import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;
import java.util.logging.Logger;

public class ThrottlingController extends TimerTask {

    public Semaphore s;
    private int rate;
    private Timer timer;
    private Logger log;
    private long counter;
    private boolean logging;
    private String name;
    long t, i;

    private static int THROTTLE_THRESHOLD = System.getProperty("mp.throttle_threshold") != null ?
            Integer.parseInt(System.getProperty("mp.throttle_threshold")) : 200;

    public ThrottlingController(Logger log, String name, int rate) {
        this.rate = 1000;
        this.name = name;
        this.log = log;
        timer = new Timer(/*true*/);
        s = new Semaphore(this.rate);
        this.logging = false;
    }

    public void start() {

//        timer.schedule(this, 0, 1000);
        timer.scheduleAtFixedRate(this, 0, 1000);
    }

    public void setLogging(boolean logging) {
        this.logging = logging;
    }



    public int getRate() {
        return rate;
    }

    public boolean tryAcquire() {
        return s.tryAcquire();
    }

    public void acquire() {
        try {

            s.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        clear();
        int count = rate - s.availablePermits();
//        System.out.println("timer:" + s.availablePermits());


//        if (count >= THROTTLE_THRESHOLD)
//            System.out.println("Throttler[" + name + "]=" + count);
    }

    public void clear() {
        int count = rate - s.availablePermits();
		/*
        if (count < 0) {
            System.out.println("Rate=" + rate + ", available=" + s.availablePermits());
        }
		*/

        if (count >= 0) {
            s.release(count);
        }

        if (logging) {
            System.out.println("throttler[" + this.name + "]: msgs sent: " + count);
        }
    }



}
