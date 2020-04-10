import java.io.*;
import java.lang.*;
import java.util.*;
class ReEntrant
{
    public static void main(String args[])throws IOException
    {
        final ReEntrantRunner wan=new ReEntrantRunner();
        Thread t1=new Thread(new Runnable()
        {
            public void run()
            {
                try
                {
                    wan.firstThread();
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
                    wan.secondThread();
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
        wan.finished();
    }
}