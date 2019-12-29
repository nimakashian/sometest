package threadwaitcall;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import threadwaitcall.Broker;
import threadwaitcall.Consumer;
import threadwaitcall.Producer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

public class Main
{

    public static void main(String args[])
    {
        try
        {
            ThreadGroup threadGroup=new ThreadGroup("myGroup");
            ThreadFactory namedThreadFactory =
                    new ThreadFactoryBuilder().setNameFormat("cunsumer-%d").build();
            Broker broker = new Broker();

            ExecutorService threadPool = Executors.newFixedThreadPool(3,namedThreadFactory);

            Producer producer=new Producer(broker);
            threadPool.execute(new Thread(threadGroup,new Consumer("1",broker,producer),"consumer 1"));
            threadPool.execute(new Thread(threadGroup,new Consumer("2",broker,producer),"consumer 2"));
            Future producerStatus = threadPool.submit(new Producer(broker));

            // this will wait for the producer to finish its execution.
            //producerStatus.get();

            threadGroup.destroy();
            threadPool.shutdown();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
