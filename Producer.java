import java.io.*;
import java.lang.*;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
class Producer
{
    private static BlockingQueue<Integer> bqueue = new ArrayBlockingQueue<Integer>(10);
    public static void main(String args[])throws InterruptedException
    {
        Thread thread1=new Thread(new Runnable()
        {
            public void run()
            {
                try
                {
                    producer();
                }catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2=new Thread(new Runnable()
        {
            public void run()
            {
                try
                {
                    consumer();
                }catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });
        
        thread1.start();
        thread2.start();
        
        thread1.join();
        thread2.join();
    }
    private static void producer()throws InterruptedException
    {
        Random rand = new Random();
        while(true)
        {
            bqueue.put(rand.nextInt(100));
        }
        
    }
    private static void consumer()throws InterruptedException
    {
        Random rand = new Random();        
        while(true)
        {
            Thread.sleep(100);
            if(rand.nextInt(10)==0)
            {
                Integer value = bqueue.take();
                System.out.println("Taken Value: "+value+"\nQueue Size is: "+bqueue.size());
            }
        }
    }
}