package redissetupdate;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

import java.util.Date;

public class LettucePerformance {
    public static void main(String[] args) {
        RedisClient redisClient = RedisClient.create();
        StatefulRedisConnection<String, String> connection = redisClient
                .connect(RedisURI.create("redis://localhost:6379/0"));
        RedisCommands<String, String> syncCommands = connection.sync();

        long _t1 = System.currentTimeMillis();
        for(int i = 0; i<1000000; i++) {
            Long n = syncCommands.lpush("testredisper", (new Date()).toString());
            try{
                Thread.sleep(1500);
                System.out.println("hi " + n + " :" + i);
            }catch (Exception e){

            }
        }

        System.out.println(System.currentTimeMillis() - _t1);

        String value ;
        _t1 = System.currentTimeMillis();
        for(int i = 0; i<3000; i++) {
            value = syncCommands.lpop("testredisper");
        }
        System.out.println(System.currentTimeMillis() - _t1);


        connection.close();
        redisClient.shutdown();
    }
}
