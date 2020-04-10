import java.io.*;
import java.lang.*;
import java.util.concurrent.locks.*;
import java.util.Scanner;
class ReEntrantRunner
{
    int count=0;
    Lock lock = new ReentrantLock();
    private Condition cond=lock.newCondition();
    void increment()
    {
        for(int i=0;i<10000;i++)
        {
            count++;
        }
    }
    void firstThread()throws InterruptedException
    {
        lock.lock();
        System.out.println("Waiting....");
        cond.await();
        System.out.println("Woken up!");
        
        try
        {
            increment();
        }
        finally
        {
            lock.unlock();
        }
    }
    void secondThread()throws InterruptedException
    {
        Thread.sleep(1000);
        lock.lock();
        System.out.println("Press the return key!");
        new Scanner(System.in).nextLine();
        System.out.println("GOT the return key!");
        cond.signal();
        try
        {
            increment();
        }
        finally
        {
            lock.unlock();
        }
    }
    void finished()
    {
        System.out.println("Count is: "+count);
    }
}
