import java.io.*;
import java.lang.*;

class ProcessorPools implements Runnable
{
    private int id;
    public ProcessorPools(int id)
    {
        this.id=id;
    }
    public void run()
    {
        System.out.println("Starting: "+id);
        try
        {
            Thread.sleep(5000);
        }
        catch(InterruptedException e)
        {
            
        }
        System.out.println("Completed: "+id);
    }
}