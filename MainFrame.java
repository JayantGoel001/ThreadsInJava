import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.concurrent.ExecutionException;
class MainFrame extends JFrame
{
    private JLabel countLabel=new JLabel("0");
    private JLabel statusLabel=new JLabel("Task Not completed.");
    private JButton startButton=new JButton("Start");
    MainFrame(String title)
    {
        super(title);
        setLayout(new GridBagLayout());
        GridBagConstraints gc=new GridBagConstraints();
        gc.fill=GridBagConstraints.NONE;
        gc.gridx=0;
        gc.gridy=0;
        
        gc.weightx=1;
        gc.weighty=1;
        add(countLabel,gc);
        
        gc.gridx=0;
        gc.gridy=1;
        gc.weightx=1;
        gc.weighty=1;
        add(statusLabel,gc);
        
        gc.gridx=0;
        gc.gridy=2;
        gc.weightx=1;
        gc.weighty=1;
        add(startButton,gc);
        
        startButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                start();
            }
        });
        setSize(200,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void start()
    {
        SwingWorker<Boolean,Integer> worker=new SwingWorker<Boolean,Integer>()
        {
            public Boolean doInBackground()throws Exception
            {
                for(int i=0;i<30;i++)
                {
                    Thread.sleep(100);
                    System.out.println("Hello :"+i);
                    publish(i);
                }
                return false;
            }
            protected void done()
            {
                try
                {
                    Boolean status=get();
                    statusLabel.setText("Completed with status: "+status);
                }catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                catch(ExecutionException e)
                {
                    e.printStackTrace();
                }
                System.out.println("Done");
            }
            protected void process(List<Integer> chunks)
            {
                Integer value=chunks.get(chunks.size()-1);
                countLabel.setText("Current value: "+value);
            }
        };
        worker.execute();
    }
}
