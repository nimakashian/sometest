import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.api.StatefulRedisConnection;
import com.lambdaworks.redis.api.sync.RedisCommands;
import com.textgateway.mp.util.LettuceUtils;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import java.util.Random;
import java.util.Set;

public class LettucePerformanceTester {

    public static Logger setupLogger(Class<?> clazz, Level level) {
        ConsoleAppender console = new ConsoleAppender(); //create appender
        //configure the appender
        final String PATTERN = "%d [%p|%C{1}] %m%n";

        console.setLayout(new PatternLayout(PATTERN));
        console.activateOptions();
        Logger.getRootLogger().addAppender(console);

        Logger.getRootLogger().setLevel(level);

        Logger log = Logger.getLogger(clazz);
        log.setLevel(level);

        return log;
    }

    public static void main(String[] args) {
        Random r = new Random(System.currentTimeMillis());

        Logger log = setupLogger(LettuceUtils.class, Level.INFO);

        RedisClient redisClient = LettuceUtils.create(log, "", "10.10.101.31:6379", 5);
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> commands = connection.sync();
        commands.flushdb();
        long count = 150;
        int percentage = 100;


//        test_set_get(count, percentage, log, r, commands);
//        test_sadd_sismember(count, percentage, log, r, commands);
        test_sdiff(count, percentage, log, r, commands);

    }

    public static void test_set_get(long count, int percentage, Logger log, Random r, RedisCommands<String, String> commands) {
        log.info("set/get: Count=" + count + ", %=" + percentage);
        log.info("set/get: Populate redis...");
        long max = percentage * count / 100;
        for (long i = 0; i < count; i++) {
            long l = Math.abs(r.nextLong() % count);
            if (l <= max) {
                commands.set(String.valueOf(l), "1");
            }
        }
        log.info("set/get: Population done.");

        log.info("set/get: Start check...");
        long t1 = System.currentTimeMillis();

        long total = 0;
        for (long i = 0; i < count; i++) {
            String s = commands.get(String.valueOf(i));
            if (s != null) {
                total++;
            }
        }
        long t2 = System.currentTimeMillis();
        log.info("set/get: Check done: total=" + total);
        long t = t2 - t1;
        log.info("set/get: Took: " + t + " millisecs.");

        float f = 1.0f * t / count;
        log.info(String.format("set/get: Overhead: %.3g millisec per call", f));
        float g = 1000.0f / f;
        log.info(String.format("set/get: Speed of read: %.3f read per sec", g));
    }

    public static void test_sadd_sismember(long count, int percentage, Logger log, Random r, RedisCommands<String, String> commands) {

        log.info("sadd/sismember: Count=" + count + ", %=" + percentage);
        log.info("sadd/sismember: Populate redis...");
        long max = percentage * count / 100;

        String key = "blacklist";

        for (long i = 0; i < count; i++) {
            long l = Math.abs(r.nextLong() % count);
            if (l <= max) {
                commands.sadd(key, String.valueOf(i));
            }
        }
        log.info("sadd/sismember: Population done.");

        log.info("sadd/sismember: Start check...");
        long t1 = System.currentTimeMillis();

        long total = 0;
        for (long i = 0; i < count; i++) {
            if (commands.sismember(key, String.valueOf(i))) {
                total++;
            }
        }
        long t2 = System.currentTimeMillis();
        log.info("sadd/sismember: Check done: total=" + total);
        long t = t2 - t1;
        log.info("sadd/sismember: Took: " + t + " millisecs.");

        float f = 1.0f * t / count;
        log.info(String.format("sadd/sismember: Overhead: %.3g millisec per call", f));
        float g = 1000.0f / f;
        log.info(String.format("sadd/sismember: Speed of read: %.3f read per sec", g));


    }

    public static void test_sdiff(long count, int percentage, Logger log, Random r, RedisCommands<String, String> commands) {
        log.info("sdiff/sismember: Count=" + count + ", %=" + percentage);
        log.info("sdiff/sismember: Populate redis...");
        long max = percentage * count / 100;

        String key1 = "blacklist1";
        String key2 = "blacklist2";

        for (long i = 0; i < count; i++) {
            long l = Math.abs(r.nextLong() % count);

            commands.sadd(key1, String.valueOf(i));
            commands.sadd(key2, String.valueOf(i + 100));

        }
        log.info("sadd/sismember: Population done.");

        log.info("sadd/sismember: Start check...");
        long t1 = System.currentTimeMillis();
        Set<String> diff = commands.sdiff(key1, key2);
        log.info(diff.size());

        long t2 = System.currentTimeMillis();
        long t = t2 - t1;
        log.info("sdiff/sismember: Took: " + t + " millisecs.");

    }
}
