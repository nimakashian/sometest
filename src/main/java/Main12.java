import javafx.scene.chart.Axis;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Main12 {

    public static void main(String[] args) {
        TimerTask task = null;

        try {
            task = new TimerTask() {
                boolean runningFlag = false;
                DateFormat dateFormatDay = new SimpleDateFormat("yyyy-MM-dd");
                DateFormat dateFormatFull = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String startString = "10:14:00";
                long startAt;
                long h = 0;
                long m = 2;
                long s = 0;
                long duration = 1000 * (h * 60 * 60 + m * 60 + s);
                long now;
                public void run() {
                    try {
                        long now = System.currentTimeMillis();
                        startAt = dateFormatFull.parse(dateFormatDay.format(new Date()) + " " + startString).getTime();
                        System.out.println("timer is running:" + duration + ":" + (now - startAt) + " Thread's name: " + Thread.currentThread().getName());

                        if (now - startAt >= 0 && now - startAt <= duration && !runningFlag) {
                            System.out.println("Task on plugin: " + (new Date()) + "Thread's name: " + Thread.currentThread().getName());
                            //start();
                            runningFlag = true;
                        } else if((now - startAt < 0 || now - startAt > duration) && runningFlag) {
                            System.out.println("Task off plugin: " + (new Date()) + "Thread's name: " + Thread.currentThread().getName());
                            //stop();
                            runningFlag = false;
                        }

                    } catch (Exception e){
                        System.out.println("can not run scheduler");
                    }
                }
            };
        } catch (Exception e) {
            e.printStackTrace();
        }
        Timer timer = new Timer("Timer");

        long delay = 2000L;
        timer.schedule(task, 0, delay);
    }
}
