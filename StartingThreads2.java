import java.io.*;
import java.lang.*;
class StartingThreads2
{
    public static void main(String args[])throws IOException
    {
        Thread t1=new Thread(new Runner2());
        Thread t2=new Thread(new Runner2());
        
        t1.start();
        t2.start();
    }
}