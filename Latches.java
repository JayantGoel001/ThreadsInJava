import java.io.*;
import java.lang.*;
import java.util.concurrent.*;
class Latches
{
    public static void main(String args[])throws IOException
    {
        CountDownLatch latch=new CountDownLatch(3);
        ExecutorService exe=Executors.newFixedThreadPool(3);
        for(int i=0;i<3;i++)
        {
            exe.submit(new ProcessorLatches(latch));
        }
        try
        {
            latch.await();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("Completed");
    }
}
