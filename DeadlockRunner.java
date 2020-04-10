import java.io.*;
import java.lang.*;
import java.util.concurrent.locks.*;
import java.util.*;
class DeadlockRunner
{
    private DeadLockAccount acc1=new DeadLockAccount();
    private DeadLockAccount acc2=new DeadLockAccount();
    
    private Lock lock1=new ReentrantLock();
    private Lock lock2=new ReentrantLock();
    
    private void acquireLocks(Lock firstLock,Lock secondLock)throws InterruptedException
    {
        while(true)
        {
            boolean gotFirstLock=false;
            boolean gotSecondLock=false;
            try
            {
                gotFirstLock=firstLock.tryLock();
                gotSecondLock=secondLock.tryLock();
            }
            finally
            {
                if(gotFirstLock && gotSecondLock)
                {
                    return;
                }
                if(gotFirstLock)
                {
                    firstLock.unlock();
                }
                if(gotSecondLock)
                {
                    secondLock.unlock();
                }
            }
            Thread.sleep(1);
        }
    }
    void firstThread()throws InterruptedException
    {
        Random rand=new Random();
        for(int i=0;i<10000;i++)
        {
            acquireLocks(lock1,lock2);
            try
            {
                DeadLockAccount.transfer(acc1,acc2,rand.nextInt(100));
            }
            finally
            {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }
    void secondThread()throws InterruptedException
    {
        Random rand=new Random();
        for(int i=0;i<10000;i++)
        {
            acquireLocks(lock2,lock1);
            try
            {
                DeadLockAccount.transfer(acc2,acc1,rand.nextInt(100));
            }
            finally
            {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }
    void finished()
    {
       System.out.println("Account 1 Balance: "+acc1.getBalance());
       System.out.println("Account 2 Balance: "+acc2.getBalance());
       System.out.println("Total Balance: "+(acc1.getBalance()+acc2.getBalance()));
    }
}
