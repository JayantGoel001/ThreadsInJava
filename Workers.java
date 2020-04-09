import java.io.*;
import java.lang.*;
import java.util.*;
class Workers
{
    private List<Integer> list1=new ArrayList<Integer>();
    private List<Integer> list2=new ArrayList<Integer>();
    
    private Object lock1=new Object();
    private Object lock2=new Object();
    
    private Random random=new Random();
    public void main()
    {
        System.out.println("Starting...");
        long start = System.currentTimeMillis();
        Thread thread1 = new Thread(new Runnable()
        {
            public void run()
            {
                process();            
            }
        });        
        Thread thread2 = new Thread(new Runnable()
        {
            public void run()
            {
                process();            
            }
        });
        thread1.start();
        thread2.start();
        
        try
        {
            thread1.join();
            thread2.join();
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
       
        long end=System.currentTimeMillis();
        
        System.out.println("Time taken:"+(end-start));
        System.out.println("List 1: "+list1.size()+"\nList 2: "+list2.size());
        System.out.println("End...");
    }
    public void stageOne()
    {
        synchronized(lock1)
        {
            try
            {
                Thread.sleep(1);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            list1.add(random.nextInt(100));
        }
    }
    public void stageTwo()
    {
        synchronized(lock2)
        {
            try
            {
                Thread.sleep(1);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            list2.add(random.nextInt(100));
        }
    }
    public void process()
    {
        for(int i=0;i<1000;i++)
        {
            stageOne();
            stageTwo();
        }
    }
}