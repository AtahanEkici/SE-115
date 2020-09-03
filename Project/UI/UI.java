package UI;
import static Utilities.Utility.readInfo;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.util.ArrayList;
import java.util.logging.Level;import java.util.logging.Logger;import javax.swing.JButton;import javax.swing.JFrame;import javax.swing.JLabel;
import javax.swing.JMenuBar;import javax.swing.JPanel;
import javax.swing.JTextArea;import javax.swing.UIManager;import javax.swing.UnsupportedLookAndFeelException;
/**
 *
 * @author Atahan Ekici
 */
public final class UI extends JFrame implements ActionListener
{    
    private static UI single_instance = null;
    
    private UI()
    {
        try
        {
            Construct_Main_Frame();
        }
        catch(Exception ex)
        {
             Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
    // ------------------------------ Swing Components ------------------------------ //
    JFrame main = new JFrame("Main Frame");
    JPanel jp1,jp2;
    JButton button1,button2;
    JTextArea jta;
    JMenuBar mb;
    JLabel info;
    // ------------------------------ Swing Components ------------------------------ //
    
    
    protected double a=-1, b=-1 , c=-1;
    
    private void Construct_Main_Frame() throws UnsupportedLookAndFeelException, InstantiationException, ClassNotFoundException, IllegalAccessException   
    {
       
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
            main.setLayout(new BorderLayout());
            main.setResizable(false);
            main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            main.setSize(600, 400);
            
            jp1 = new JPanel();
            jp2 = new JPanel();
            
            info = new JLabel("                 Euro:                 Dolar:                 Altın:                 ");
            //info.setText(readInfo().toString());
            jp1.add(info,BorderLayout.CENTER);
            
            button1 = new JButton("Deneme1"); 
            button1.setFocusable(false);
            button1.addActionListener(this);
            
            button2 = new JButton("Deneme2");
            button2.setFocusable(false);
            button2.addActionListener(this);
            
            jp2.add(button1);
            jp2.add(button2);
            
            main.add(jp1,BorderLayout.NORTH);
            main.add(jp2,BorderLayout.CENTER);
            
            main.setLocationRelativeTo(null);
            main.setVisible(true);
        }
    
    private void setter()
    {
        ArrayList<Double> list = readInfo();
        
        double euro = list.get(0);
        double dolar = list.get(1);
        double altın = list.get(2);
        
        String text;
        
        if(a == -1)
        {
            a = euro;
        }
        if(b == -1)
        {
            b = dolar;
        }
        if(c == -1)
        {
            c = altın;
        }
        
        
        if(a < euro)
        {
            text = "<html>                 Euro:<FONT COLOR=RED>"+euro+"</FONT>                 ";
            a = euro;
        }
        else
        {
            text = "<html>                 Euro:<FONT COLOR=GREEN>"+euro+"</FONT>                 ";
            a = euro;
        }
        
        
        if(b < dolar)
        {
            text += "                 Dolar:<FONT COLOR=RED>"+dolar+"</FONT>                 ";
            b = dolar;
        }
        else
        {
            text += "                 Dolar:<FONT COLOR=GREEN>"+dolar+"</FONT>                 ";
            b = dolar;
        }
        
        
        if(c < altın)
        {
            text += "                 Altın:<FONT COLOR=RED>"+altın+"</FONT>                 </html>";
            c = altın;
        }
        else
        {
            text += "                 Altın:<FONT COLOR=GREEN>"+altın+"</FONT>                 </html>";
            c = altın;
        } 
        info.setText(text);
    }
    
    public static UI getInstance()
    {
        if(single_instance == null)
        {
            single_instance = new UI();
        }
            return single_instance;    
    }

    @Override
    public void actionPerformed(ActionEvent Event) // Action Listener instructions //
    {
        if(Event.getSource() == button1)
        {
            setter();
        }
        else if(Event.getSource() == button2)
        {
            System.out.println("Buton 2");
        }
    }
     
}