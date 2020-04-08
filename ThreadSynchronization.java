import java.io.*;
import java.lang.*;
import java.util.*;
class ThreadSynchronization
{
    public static void main(String args[])throws IOException
    {
        Processor pro=new Processor();
        pro.start();
        
        Scanner sc=new Scanner(System.in);
        sc.nextLine();
        
        pro.shutdown();
    }
}