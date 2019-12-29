public class M1 {
    public static void main(String[] args) {
        boolean ok=true;
        int maxReconnectionTry=0;
        while (ok) {
            if (true) {
                if (maxReconnectionTry++ < 10) {//TODO morteza get the maxReconnectionTry from config file
                    try {
                        Thread.sleep(1000);//TODO morteza: get sleep time from config file
                    } catch (InterruptedException ie) {
                        //TODO morteza: log the exception
                    }
                    System.out.println("turn:" + maxReconnectionTry);
                    continue;
                }
                ok = false;
                continue;

            }
        }
    }
}
