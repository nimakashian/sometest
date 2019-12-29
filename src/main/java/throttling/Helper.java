package throttling;

import java.util.Timer;
import java.util.TimerTask;

class Helper extends TimerTask
{
    public static int i = 0;
    private Timer timer;

    public void run()
    {
        System.out.println("Timer ran " + ++i);
    }

    public void start() {
        timer= new Timer(true);
        timer.schedule(this, 0, 1000);
    }
}