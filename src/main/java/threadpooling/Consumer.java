package threadpooling;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Consumer implements Runnable
{

    private String name;
    private Broker broker;
    private Vector v=new Vector();


    public Consumer(String name, Broker broker)
    {
        this.name = name;
        this.broker = broker;
    }


    @Override
    public void run()
    {
        try
        {
            Integer data = broker.get();

            while (broker.continueProducing || data != null)
            {
                Vector v=new Vector();
                System.out.println(System.currentTimeMillis()+ " Consumer " + this.name + " processing data from broker: " + data);
//                for (int i=0;i<100;i++) v.add(new String("hi"));
                Thread.sleep(1000);
                System.out.println(System.currentTimeMillis()+ " Consumer " + this.name + " processed data from broker: " + data);

                data = broker.get();
            }


            System.out.println("Comsumer " + this.name + " finished its job; terminating.");

            final ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
            long[] allThreadIds = threadMXBean.getAllThreadIds();

            for (long threadId : allThreadIds) {
                ThreadInfo threadInfo = threadMXBean.getThreadInfo(threadId);
                System.out.println(threadInfo+" --- "+threadMXBean.getThreadCpuTime(threadId) / 1000);

            }

        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }

}