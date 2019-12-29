package threadpooling;

public class Producer implements Runnable
{
    private Broker broker;

    public Producer(Broker broker)
    {
        this.broker = broker;
    }


    @Override
    public void run()
    {
        try
        {
            for (Integer i = 1; i < 5 + 1; ++i)
            {
                System.out.println("Producer produced: " + i);
                Thread.sleep(1000);
                broker.put(i);
            }

            this.broker.continueProducing = Boolean.FALSE;
            System.out.println("Producer finished its job; terminating.");
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }

    }
}