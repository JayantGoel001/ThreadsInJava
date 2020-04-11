import java.io.*;
import java.lang.*;
import java.util.concurrent.*;
class Semaphores
{
    public static void main(String args[])throws Exception
    {
        ExecutorService exe=Executors.newCachedThreadPool();
        for(int i=0;i<200;i++)
        {
            exe.submit(new Runnable()
            {
                public void run()
                {
                    try
                    {
                        Connection.getInstance().connect();
                    }catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            });
        }
        exe.shutdown();
        exe.awaitTermination(1,TimeUnit.DAYS);
    }
}
