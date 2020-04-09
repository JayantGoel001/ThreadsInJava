import java.io.*;
import java.lang.*;
class WaitAndNotify
{
    public static void main(String args[])throws Exception
    {
        final ProcessorWAN wan=new ProcessorWAN();
        Thread t1=new Thread(new Runnable()
        {
            public void run()
            {
                try
                {
                    wan.produce();
                }catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }   
        });
        Thread t2 = new Thread(new Runnable()
        {
            public void run()
            {
                try
                {
                    wan.consume();
                }catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }   
        });
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
    }
}