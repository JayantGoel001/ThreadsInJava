import java.io.*;
import java.lang.*;
class StartingThreads3
{
    public static void main(String args[])throws IOException
    {
        Thread t1=new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for(int i=0;i<10;i++)
                {
                    System.out.println("Hello "+i);
                    try
                    {
                        Thread.sleep(100);
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
    }
}