import java.io.*;
import java.lang.*;

class SynchronizedKeyword
{
    private int count=0;
    public synchronized void increment()//Every object in java has monitor lock or mutex synchronized object is called here  
    {                                   //Only one thread can aquire monitor lock snychronized aquire lock
        count++;
    }
    public static void main(String args[])throws IOException
    {
        SynchronizedKeyword sk=new SynchronizedKeyword();
        sk.doWork();
    }
    public void doWork()
    {
        Thread t1=new Thread(new Runnable()
        {
            public void run()
            {
                for(int i=0;i<1000;i++)
                {
                    increment();
                }
            }
        });
        Thread t2=new Thread(new Runnable()
        {
            public void run()
            {
                for(int i=0;i<1000;i++)
                {
                    increment();
                }
            }
        });
        t1.start();
        t2.start();
        //make threads stop until its execution
        try
        {
            t1.join();
            t2.join();
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("Count is: "+count);
    }
}