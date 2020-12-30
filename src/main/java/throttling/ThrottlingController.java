package throttling;



import org.slf4j.Logger;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;

public class ThrottlingController extends TimerTask {

    private Semaphore s;
    private int rate;
    private Timer timer;
    private Logger log;
    private long counter;
    private boolean logging;
    private String name;

    private static int THROTTLE_THRESHOLD = System.getProperty("mp.throttle_threshold") != null ? Integer.parseInt(System.getProperty("mp.throttle_threshold")) : 200;
    private static int THROTTLE_FACTOR = System.getProperty("mp.throttle_factor") != null ? Integer.parseInt(System.getProperty("mp.throttle_factor")) : 10;

    public int getAvailablePermits(){
        return s.availablePermits();
    }
    public ThrottlingController(Logger log, String name, int rate) {
        this.rate = rate / THROTTLE_FACTOR;
        this.name = name;
        this.log = log;
        timer = new Timer(true);
        s = new Semaphore(this.rate);
        this.logging = true;
    }

    public void start() {
        timer.schedule(this, 0, 600 * 1000 / THROTTLE_FACTOR);
    }

    public void setLogging(boolean logging) {
        this.logging = logging;
    }



    public void acquire() {
        try {
            log.info("before s acq");
            s.acquire();
            log.info("after s acq");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        log.info("run");
        clear();
        int count = rate - s.availablePermits();
        if (count >= THROTTLE_THRESHOLD)
            log.info("Throttler[" + name + "]=" + count);
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
            log.info("throttler[" + this.name + "]: msgs sent: " + count);
        }
    }

}
