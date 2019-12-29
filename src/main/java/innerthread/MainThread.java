package innerthread;

import java.util.HashMap;

public class MainThread implements Runnable {
    Thread thread;
    boolean flag = true;
    ThreadGroup threadGroup;

    public void start() {
        thread = new Thread(threadGroup, this, "Provider-" + "name");
        thread.start();
        System.out.println("main started");
    }

    @Override
    public void run() {
        InnerThread innerThread = new InnerThread();
        thread = new Thread(threadGroup, innerThread, "Retry-" + "name");
        thread.start();
        while (true) {
            System.out.println("run main-tread");
            try {
                Thread.sleep(1500);
                if (flag) {
                    System.out.println("add");
                    Thread.sleep(1500);
                    innerThread.add(1, 1);
                    innerThread.add(2, 2);
                    innerThread.add(3, 3);
                    innerThread.add(4, 4);
                    System.out.println("add 2");
                    flag = false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    class InnerThread implements Runnable {
        private HashMap<Integer, Integer> rejectedMesages = new HashMap<>();

        @Override
        public void run() {
            System.out.println("run inner thread");
            int i = 1;
            while (true) {
                synchronized (rejectedMesages) {

                    System.out.println("run inner thread before wait");
                    if (rejectedMesages.size() <= 0) {
                        try {
                            rejectedMesages.wait();
                        } catch (InterruptedException e) {
//                                //TODO @morteza nothing to do
                            System.out.println("The Retry-" + "name" + "-thread can not wait.");
                        }
                    } else {
                        try {
                            System.out.println("consume: " + rejectedMesages.remove(i++));
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("run inner thread after wait");


                }
            }

        }

        public void add(Integer i, Integer j) {
            synchronized (rejectedMesages) {
                rejectedMesages.put(i, j);
                rejectedMesages.notify();
            }
        }
    }
}
