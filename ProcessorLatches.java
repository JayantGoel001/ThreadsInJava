import java.io.*;
import java.lang.*;
import java.util.concurrent.CountDownLatch;
class ProcessorLatches implements Runnable
{
    private CountDownLatch latch;
    ProcessorLatches(CountDownLatch latch)
    {
        this.latch=latch;
    }
    public void run()
    {
        System.out.println("Started.");
        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        latch.countDown();
    }
}