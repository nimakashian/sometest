package statsdnetty;

import com.timgroup.statsd.NonBlockingStatsDClient;
import com.timgroup.statsd.StatsDClient;

import java.util.concurrent.atomic.AtomicInteger;




@SuppressWarnings({"unused", "WeakerAccess"})
public class Stats {

    public static final int STRONGEST = 0;
    public static final int STRONGER = 1;
    public static final int STRONG = 2;
    public static final int NORMAL = 3;
    public static final int FRAGILE=4;
    public static final int WEAK = 6;
    public static final int WEAKER = 7;
    public static final int WEAKEST = 8;

    protected static final int DEFAULT_LEVEL = NORMAL;

    private StatsDClient statsd;
    private int currentLevel;

    static AtomicInteger count = new AtomicInteger(0);

    public Stats(int level) {
        this.currentLevel = level;
    }

    public Stats(int level, String title, String server, int port, boolean enabled) {
        if (enabled) {
            // System.out.println("Stats: Current count: " + count.get());

            this.currentLevel = level;
            try {
                statsd = new NonBlockingStatsDClient(title, server, port);
                count.incrementAndGet();
            } catch (Throwable th) {
                th.printStackTrace();
                statsd = null;
            }
        }
    }

    public Stats(int level, String title, String server, int port) {
        this(level, title, server, port, true);
    }

    public void count(int level, String aspect) {
        if (statsd != null && level <= currentLevel) {
            statsd.incrementCounter(aspect);
        }
    }

    public void count(int level, String aspect, int val) {
        if (statsd != null && level <= currentLevel) {
            statsd.count(aspect, val);
        }
    }

    public void gauge(int level, String aspect, long val) {
        if (statsd != null && level <= currentLevel) {
            statsd.gauge(aspect, val);
        }
    }

    public void time(int level, String aspect, long val) {
        if (statsd != null && level <= currentLevel) {
            statsd.time(aspect, val);
        }
    }

    public void addToSet(int level, String aspect, String event) {
        if (statsd != null && level <= currentLevel) {
            statsd.recordSetEvent(aspect, event);
        }
    }

    public void count(String aspect) {
        count(DEFAULT_LEVEL, aspect);
    }

    public void count(String aspect, int val) {
        count(DEFAULT_LEVEL, aspect, val);
    }

    public void gauge(String aspect, long val) {
        gauge(DEFAULT_LEVEL, aspect, val);
    }

    public void time(String aspect, long val) {
        time(DEFAULT_LEVEL, aspect, val);
    }

    public void addToSet(String aspect, String event) {
        addToSet(DEFAULT_LEVEL, aspect, event);
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }




}
