package redissetupdate;

import org.redisson.Redisson;
import org.redisson.api.*;

import java.util.Date;

public class RedissonPerformance {

    public static void main(String[] args) {
        // connects to 127.0.0.1:6379 by default
        RedissonClient redisson = Redisson.create();

        LocalCachedMapOptions options = LocalCachedMapOptions.defaults();
        options.cacheSize(5000);
//        RLocalCachedMap<String, String> map = redisson.getLocalCachedMap("ledger", options );
        RQueue<String> map = redisson.getQueue("ledgertestper" );

        long _t1 = System.currentTimeMillis();
        for(int i = 0; i<3000; i++) {
            boolean newLedger = map.add((new Date()).toString()+(new Date()).toString()+(new Date()).toString());
        }
        System.out.println(System.currentTimeMillis() - _t1);

        String value ;
         _t1 = System.currentTimeMillis();
        for(int i = 0; i<3000; i++) {
            value = map. poll();
        }
        System.out.println(System.currentTimeMillis() - _t1);
        redisson.shutdown();
    }
}
