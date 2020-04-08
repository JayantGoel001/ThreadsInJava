import java.io.*;
import java.lang.*;
class Processor extends Thread
{
    private volatile boolean running=true;//volatile helps the program to run efficiently on different system without crashes.
    public void run()
    {
        while(running)
        {
            System.out.println("Hello");
            try
            {
                Thread.sleep(100);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
    public void shutdown()
    {
        running=false;
    }
}