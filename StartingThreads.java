import java.io.*;
import java.lang.*;
class StartingThreads
{
    public static void main(String args[])throws IOException
    {
        Runner runner=new Runner();
        runner.start();
        
        Runner runner2=new Runner();
        runner2.start();
    }
}