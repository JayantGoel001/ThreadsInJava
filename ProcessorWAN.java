import java.io.*;
import java.lang.*;
import java.util.*;
class ProcessorWAN
{
    public void produce()throws InterruptedException
    {
        synchronized(this)
        {
            System.out.println("Producer thread running....");
            wait();
            System.out.println("Resumed.");
        }
    }
    public void consume()throws InterruptedException
    {
        Scanner sc=new Scanner(System.in);
        Thread.sleep(2000);
        synchronized(this)
        {
            System.out.println("Waiting for return key.");
            sc.nextLine();
            System.out.println("Return key Pressed");
            notify();
            
        }
    }
}
