package dispatcherclient;

public class Main {
    public static final int THREADS = 3;
    public static final int LOOP = 1000;

    public static void main(String[] args) throws InterruptedException {

        for (int j = 0; j < LOOP; j++) {
            for (int i = 0; i < THREADS; i++) {
                SendBulkMessage s = new SendBulkMessage("thread" + i);
                s.start();

            }
            System.out.println(j + "--> sent");
            Thread.sleep(1500);
        }
        Thread.sleep(10000);

    }

}
