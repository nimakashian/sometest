package threadpooling;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

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


            threadPool.execute(new Thread(threadGroup,new Consumer("1",broker),"consumer 1"));
            threadPool.execute(new Thread(threadGroup,new Consumer("2",broker),"consumer 2"));
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
