package redissetupdate;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

import java.util.List;

public class RedisQueuesLen {
    public static void main(String[] args) {
        RedisClient redisClient = RedisClient.create();
        StatefulRedisConnection<String, String> connection = redisClient
                .connect(RedisURI.create("redis://10.10.150.54:6379/2"));
        RedisCommands<String, String> syncCommands = connection.sync();
        List<String> list = syncCommands.keys("events:*");

        Long sum = 0L;
        for (String s : list){

            Long len = syncCommands.llen(s);
            System.out.println(s + "-->" + len);
            sum = sum + len;
            System.out.println(sum);
        }
        System.out.println("hi");

        connection.close();
        redisClient.shutdown();
    }
}
