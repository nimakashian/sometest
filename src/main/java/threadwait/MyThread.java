package threadwait;

public class MyThread implements Runnable {
    boolean ok =true;
    int maxTry=0;

    public MyThread(String name){
        Thread t=new Thread(this, name);
        t.start();
    }
    @Override
    public void run() {
        while(ok){
            try {
                Thread.sleep(2000);
                if(++maxTry>=5)
                    ok=false;
                System.out.println("after wait "+maxTry);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
