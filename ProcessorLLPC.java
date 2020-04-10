import java.util.*;
class ProcessorLLPC
{
    private LinkedList<Integer> list = new LinkedList<Integer>();
    private final int LIMIT=10;
    private Object lock =new Object();
    public void produce()throws InterruptedException
    {
        int value=0;
        while(true)
        {
            synchronized(lock)
            {
                while(list.size()==LIMIT)
                {
                    lock.wait();
                }
                list.add(value++);
                lock.notify();
            }
        }
    }
    public void consume()throws InterruptedException
    {
        Random rand= new Random();
        while(true)
        {
            synchronized(lock)
            {
                while(list.size()==0)
                {
                    lock.wait();
                }
                System.out.println("List size is: "+list.size());
                int value=list.removeFirst();
                System.out.println("Value is: "+value);
                lock.notify();
            }
            Thread.sleep(rand.nextInt(1000));
        }
    }
}
