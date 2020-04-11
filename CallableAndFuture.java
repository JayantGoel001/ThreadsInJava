import java.util.concurrent.*;
import java.util.*;
import java.io.*;
import java.lang.*;
class CallableAndFuture
{
    public static void main(String args[])throws Exception
    {
        ExecutorService exe=Executors.newCachedThreadPool();
        Future<Integer> future = exe.submit(/*new Runnable()
        {
            public void run()
            {
                Random rand=new Random();
                int dura=rand.nextInt(4000);
                System.out.println("Starting ...");
                try
                {
                    Thread.sleep(dura);
                }catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println("Finished.");
            }
        }*/
        new Callable<Integer>()
        {
            public Integer call()throws Exception
            {
                Random rand=new Random();
                int dura=rand.nextInt(2000);
                if(dura>2000)
                {
                    throw new IOException("Sleeping for too long.");
                }
                System.out.println("Starting ...");
                try
                {
                    Thread.sleep(dura);
                }catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println("Finished.");
                return dura;
            }
        });
        exe.shutdown();
        try
        {
            System.out.println("Result is: "+future.get());
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        catch(ExecutionException e)
        {
            IOException ex=(IOException)e.getCause();
            System.out.println(ex.getMessage());
        }
        
    }
}