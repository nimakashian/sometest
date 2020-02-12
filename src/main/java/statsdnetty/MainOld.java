package statsdnetty;

import java.util.Random;

public class MainOld {
    public static void main(String[] args) throws InterruptedException {
        Random r = new Random();
        Stats stats =new Stats(8,"m_kashian_test","10.10.66.30",9125,true );
        while (true) {
            int loop = r.nextInt(5000);
            stats.gauge("gvisitors",1111);
//            stats.gauge("gvisitors2",loop);
//            stats.count("cvisitors");
            Thread.sleep(1);
        }


    }
}
