import java.io.*;
import java.lang.*;
import java.util.concurrent.*;
class ThreadPools
{
    public static void main(String args[])throws IOException
    {
        ExecutorService executor=Executors.newFixedThreadPool(2);
        for(int i=0;i<5;i++)
        {
            ProcessorPools pro=new ProcessorPools(i);
            executor.submit(pro);
        }
        executor.shutdown();
        System.out.println("All tasks submitted.");
        try
        {
            executor.awaitTermination(1,TimeUnit.DAYS);
        }catch(InterruptedException e)
        {
            
        }
        System.out.println("All tasks completed.");
    }
}