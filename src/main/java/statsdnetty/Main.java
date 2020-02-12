package statsdnetty;

import com.flozano.statsd.metrics.Metrics;
import com.flozano.statsd.metrics.MetricsBuilder;
import com.flozano.statsd.metrics.Timer;

import java.time.Clock;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        Random r = new Random();
        try (Metrics metrics = MetricsBuilder.create()
                .withClient((clientBuilder) -> //
                        clientBuilder
                                .withHost("10.10.66.30") //
                                .withPort(9125) //
//                                .withSampleRate(0.5) // send 50% of metrics only
                ).withPrefix("m_kashian_test").withClock(Clock.systemUTC()).build()) {

//            // Send a counter metric immediately
//            while (true) {
//                int loop = r.nextInt(5000);
//                metrics.gauge("gvisitors").value((loop));
//                metrics.counter("cvisitors").hit();
//                Thread.sleep(1);
//            }
            while (true) {
                int loop = r.nextInt(5000);
                try (Metrics batch = metrics.batch()) {
                    batch.gauge("gvisitors").value((loop));
//                    batch.counter("cvisitors").hit();
                }
                Thread.sleep(1);
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Object getWaitingForConnection() {
        return new Object();
    }

    private static long getConnectionsFromPool() {
        return 10000L;
    }

    private static void saveData() {
        System.out.println("data was saved");
    }


}
