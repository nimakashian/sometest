package getnextidredis;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    long store = 10;
    AtomicLong remained = new AtomicLong(store);
    long lastId = store;


    public synchronized long getNextId() {

        long r = remained.decrementAndGet();
        try {
            return lastId - r;
        } finally {
            if (r <= 0) {
                topUp();
            }
        }
    }

    private synchronized void topUp() {

        try{
            Thread.sleep(10000);
        }catch (Exception e){

        }
        store+=10;
        remained = new AtomicLong(10);
        lastId = store;
    }
}
