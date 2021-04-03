import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class MessageUpdateEventHandler implements Callable<String> {
    private final String mue;

    public MessageUpdateEventHandler(String event) {
        this.mue = event;
    }

    public String call() {
        try {
            handleUpdateMessageState(this.mue);

            String threadName = Thread.currentThread().getName();


            System.out.println("eventRouter.asyncUpdates." + threadName);
        } catch (Throwable e) {
            System.out.println("Error occured during handling updateEvent:" + e.getMessage());
        }
        return this.mue;
    }

    public void handleUpdateMessageState(String mue) {
        long t1 = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long t2 = System.currentTimeMillis();


    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor eventHandlingThreadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(4, new EventHandlerThreadFactory("EV"));
        Map<String, Integer> handlerCounts = new HashMap<>();
        for (int i = 0; i < 1000_000; i++) {
            String mue = new String("mue" + i);
//            try {

//
            MessageUpdateEventHandler messageUpdateEventHandler = new MessageUpdateEventHandler(mue);
            eventHandlingThreadPool.purge();
//            eventHandlingThreadPool.shutdown();
//            eventHandlingThreadPool.shutdownNow();
            Future<String> f = eventHandlingThreadPool.submit(messageUpdateEventHandler);
            System.out.println("hi");
            System.out.println(f.get());

//            } catch (Throwable e) {
//                System.out.println("Error occurred during handling updateEvent");
//            }
        }
    }

    static class EventHandlerThreadFactory implements ThreadFactory {
        private final String prefix;

        public EventHandlerThreadFactory(String prefix) {
            this.prefix = prefix;
        }

        private final AtomicInteger last = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            Thread thr = new Thread(r);
            thr.setName(String.format("%s-%02d", prefix, last.getAndIncrement()));
            return thr;
        }
    }
}
