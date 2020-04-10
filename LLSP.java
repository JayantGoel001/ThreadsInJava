import java.io.*;
import java.lang.*;
import java.util.*;
class LLSP
{
    public static void main(String args[])throws IOException
    {
        final ProcessorLLPC wan=new ProcessorLLPC();
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
        try
        {
             t1.join();
             t2.join();
        }catch(InterruptedException e)
        {
             e.printStackTrace();
        }
    }
}