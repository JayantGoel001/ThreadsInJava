import javax.swing.SwingUtilities;
class MultiThreadingInSwing
{
    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new MainFrame("SwingWorkerDemo");
            }   
        });
        
    }
}
