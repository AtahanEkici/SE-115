package UI;
import Bank.Account;
import Bank.Bank;
import static Utilities.Utility.readInfo;import java.awt.BorderLayout;import java.awt.Color;import java.awt.Desktop;import java.awt.FlowLayout;import java.awt.Font;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URI;import java.util.ArrayList;import java.util.logging.Level;import java.util.logging.Logger;import javax.swing.BorderFactory;import javax.swing.ImageIcon;import javax.swing.JButton;import javax.swing.JFrame;import javax.swing.JLabel;import javax.swing.JMenu;import javax.swing.JMenuBar;import javax.swing.JMenuItem;import javax.swing.JOptionPane;import javax.swing.JPanel;import javax.swing.JTextArea;import javax.swing.JTextField;
import javax.swing.JTextPane;import javax.swing.Timer;
/**
 *
 * @author Atahan Ekici
 */
public final class UI extends JFrame implements ActionListener,MouseListener
{    
    private static UI single_instance = null;
    
    private UI()
    {
        try
        {
            Construct_Credential_Frame();
            //Construct_Main_Frame();
            //setter();
            //refresher();
            //Construct_Exchange_Frame();
        }
        catch(Exception ex)
        {
             Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }  
    // ------------------------------ Swing Components ------------------------------ //
    private JFrame main,credential,exchange;
    private JPanel jp1,jp2,jp3;
    private JButton withdraw,deposit,button3,button4;
    private JTextArea jta;
    private JTextPane jtp;
    private JMenu aboutMenu;
    private JMenuBar mb;
    private JMenuItem jm_about,jm_github;
    private JLabel info,balanceLabel;
    private Timer timer;
    // ------------------------------ Swing Components ------------------------------ //
    
    private static final Color PALE_BLACK = new Color(33, 37, 41);
    
    private static final String Id = "admin";
    
    private double a=-1, b=-1 , c=-1;
    
    // Bank and Account //
    private static final Bank bank = new Bank("Banka");
    private static final Account a1 = new Account(bank, "Account1", "admin", "admin", 1000.0);
    // Bank and Account //
    
    private double balance = a1.getBalance();
    
    private double current_witdraw;
    private double current_deposit;
    
    private void Construct_Credential_Frame()
    {
        credential = new JFrame("Credential Checker");
        ImageIcon image = new ImageIcon(getClass().getResource("/Icons/credential.png"));
        credential.setIconImage(image.getImage());
        credential.getContentPane().setBackground(PALE_BLACK);
        credential.setLayout(null);
        credential.setSize(300,300);
        credential.setResizable(false);
        credential.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        credential.addWindowListener(new WindowAdapter() 
{
    @Override
    public void windowClosing(WindowEvent e) 
    {
        int reply = JOptionPane.showConfirmDialog(null, "Do You Really Want to Quit ?", "Exit ?", JOptionPane.YES_NO_OPTION);
        
        if (reply == JOptionPane.YES_OPTION) 
{
    System.exit(0);
}
    }
}); 
        JLabel label2 = new JLabel("ID:");  
        label2.setBounds(55,40,250,100);
        label2.setForeground(Color.WHITE);
        
        JTextField ID = new JTextField();  
        ID.setBounds(90,82,150,20);  
        
        JTextField Password = new JTextField();  
        Password.setBounds(90,120,150,20);
        
        JLabel label3 = new JLabel("Pass:");  
        label3.setBounds(55,80,250,100);
        label3.setForeground(Color.WHITE);
        
        JButton hundred = new JButton();  
        hundred.setText("SUBMIT");
        hundred.setBounds(100,200,100,40);
        hundred.setFocusable(false);
        hundred.addActionListener((new ActionListener()
        {  
    @Override
    public void actionPerformed(ActionEvent e)
    {  
            String id = ID.getText();
            String Pass = Password.getText();
            
            if(id.matches(Id) && Pass.matches(Id))
            {
                main.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Wrong ID or Password", "Try Again",JOptionPane.ERROR_MESSAGE);
            }
    }  
    }));
        credential.add(label2);
        credential.add(label3);
        credential.add(ID);
        credential.add(Password);
        credential.add(hundred);
        credential.setLocationRelativeTo(null);
        credential.setVisible(true);
    }
    
    private void Construct_Main_Frame() 
    {    
            main = new JFrame("Main Frame");
            ImageIcon image = new ImageIcon(getClass().getResource("/Icons/bank.png"));
            main.setIconImage(image.getImage());
            main.setLayout(new BorderLayout());
            main.setResizable(false);
            main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            main.setSize(600, 400);
            main.getContentPane().setBackground(PALE_BLACK);
            main.getContentPane().setForeground(PALE_BLACK);
            
            balanceLabel = new JLabel("Your Balance is: "+balance+"");  
            balanceLabel.setBounds(60,50,250,100);
            balanceLabel.setForeground(Color.WHITE);
            balanceLabel.setFont(new Font("Serif", Font.PLAIN, 20));
            
            jp1 = new JPanel();
            jp1.setBackground(PALE_BLACK);
            jp1.setForeground(Color.WHITE);
            
            jp2 = new JPanel(new FlowLayout());
            jp2.setBackground(PALE_BLACK);
            jp2.setForeground(Color.WHITE);
            
            info = new JLabel("                 Euro:                 Dolar:                 Altın:                 ");
            //info.setText(readInfo().toString());
            jp1.add(info,BorderLayout.CENTER);
            info.setForeground(Color.WHITE);
            
            mb = new JMenuBar();
            main.setJMenuBar(mb);      
            mb.setBorder(BorderFactory.createLineBorder(PALE_BLACK));
            
            aboutMenu = new JMenu("About");
            aboutMenu.setFocusable(true);
            aboutMenu.setForeground(Color.BLACK);
            aboutMenu.addMouseListener(this);
        
            jm_about = aboutMenu.add("About This Project");
            jm_about.addActionListener(this);
            jm_about.setBackground(Color.WHITE);
            
            jm_github = aboutMenu.add("GitHub Page");
            jm_github.addActionListener(this);
            jm_github.setBackground(Color.WHITE);
            
            mb.add(aboutMenu);
            
            withdraw = new JButton("Withdraw"); 
            withdraw.setFocusable(false);
            withdraw.addActionListener(this);
            withdraw.setBackground(Color.WHITE);
            withdraw.setForeground(PALE_BLACK);
            
            deposit = new JButton("Deposit");
            deposit.setFocusable(false);
            deposit.addActionListener(this);
            deposit.setBackground(Color.WHITE);
            deposit.setForeground(PALE_BLACK);
            
            jp2.add(withdraw);
            jp2.add(deposit);
            
            main.add(balanceLabel,BorderLayout.CENTER);
            main.add(jp1,BorderLayout.NORTH);
            main.add(jp2,BorderLayout.CENTER);
            
            main.setLocationRelativeTo(null);
        }
    
    private void Construct_Exchange_Frame()
    {
        exchange = new JFrame("Exchange Menu");
    }
    
    private void refresh()
    {
        main.setVisible(false);
        main.dispose();
        main.repaint();
        main.revalidate();
        main.setVisible(true);   
    }
    
    private void setter()
    {
        ArrayList<Double> list = readInfo();
        
        double euro = list.get(0);
        double dolar = list.get(1);
        double altın = list.get(2);
        
        String text = null;
        
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
            text = "<html>Euro: <FONT COLOR=RED>" +euro+ "</FONT> ";
        }
        else if(a == euro)
        {
            text = "<html>Euro: <FONT COLOR=YELLOW>" +euro+ "</FONT> ";
        }
        else
        {
            text = "<html>Euro: <FONT COLOR=GREEN>" +euro+ "</FONT> ";
        }
        
        
        if(b < dolar)
        {
            text += " Dolar: <FONT COLOR=RED>" +dolar+ "</FONT> ";
        }
        else if(b == dolar)
        {
            text += " Dolar: <FONT COLOR=YELLOW>" +dolar+ "</FONT> ";
        }
        else
        {
            text += " Dolar: <FONT COLOR=GREEN>" +dolar+ "</FONT> ";
        }
        
        
        if(c < altın)
        {
            text += " Altın: <FONT COLOR=RED>" +altın+ "</FONT></html> ";
            c = altın;
        }
        else if(c == altın)
        {
            text += " Altın: <FONT COLOR=YELLOW>" +altın+ "</FONT></html> ";
            c = altın;
        }
        else
        {
            text += " Altın: <FONT COLOR=GREEN>" +altın+ "</FONT></html> ";
            c = altın;
        } 
        info.setText(text);
    }
    
    private void refresher()
    {
        timer = new Timer(5000, (ActionEvent e) -> 
        {
            setter();
        });
            timer.start();
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
        if(Event.getSource() == withdraw)
        {
            try
            {
                current_witdraw = Double.parseDouble(JOptionPane.showInputDialog(null," Please Specify Withdrawal Amount: "));
                
                if(current_witdraw > balance)
                {
                    JOptionPane.showMessageDialog(null, "Your withdrawal exceeds your balance", "Exceeding Amount",JOptionPane.INFORMATION_MESSAGE);
                }
                else if(current_witdraw < 0)
                {
                    JOptionPane.showMessageDialog(null, "You can not Withdraw negative values", "Error!!",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    balance -= current_witdraw;
                    JOptionPane.showMessageDialog(null, "Your Withdrawal has been processed", "Transaction Successfull",JOptionPane.INFORMATION_MESSAGE);
                    balanceLabel.setText("Your Balance is: "+balance+"");
                } 
            }catch(Exception e)
            {
                if(e instanceof NullPointerException)
                {
                    JOptionPane.showMessageDialog(null, "You Need To Specify Input", e.getClass().getCanonicalName(),JOptionPane.INFORMATION_MESSAGE);
                }
                else if(e instanceof NumberFormatException)
                {
                    JOptionPane.showMessageDialog(null, "Please Input Double", e.getClass().getCanonicalName(),JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, e , e.getClass().getCanonicalName(),JOptionPane.INFORMATION_MESSAGE); 
                } 
            }   
        }
        else if(Event.getSource() == deposit)
        {
           try
            {
                current_deposit = Double.parseDouble(JOptionPane.showInputDialog(null," Please Specify Withdrawal Amount: "));
                
                if(current_deposit > 15000)
                {
                    JOptionPane.showMessageDialog(null, "Limit for Deposit is 15000", "Exceeding Amount",JOptionPane.INFORMATION_MESSAGE);
                }
                else if(current_deposit < 0)
                {
                    JOptionPane.showMessageDialog(null, "You can not deposit negative values", "Error!!",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    balance += current_deposit;
                    JOptionPane.showMessageDialog(null, "Your Depositment has been processed", "Transaction Successfull",JOptionPane.INFORMATION_MESSAGE);
                    balanceLabel.setText("Your Balance is: "+balance+"");
                } 
            }catch(Exception e)
            {
                if(e instanceof NullPointerException)
                {
                    JOptionPane.showMessageDialog(null, "You Need To Specify Input", e.getClass().getCanonicalName(),JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please Input Double", e.getClass().getCanonicalName(),JOptionPane.INFORMATION_MESSAGE); 
                } 
            }   
        }
        else if(Event.getSource() == jm_about)
        {
             try
            {   
                JOptionPane.showMessageDialog(null,"<html><font color=#0066ff> <u> <br> Java Swing Application </br> </u> </font> </html>\n"
                        + "<html><font color=#0066ff><u> <br> Java</br></u>: </font>  1.8.0_111 </html> \n"
                        + "<html><font color=#0066ff> <u> <br> IDE</br></u>: </font>  Apache Netbeans IDE 12.0 </html>\n"
                        + "<html><font color=#0066ff><u> <br> Icons</br></u>: </font>  www.flaticon.com </html>","About This Project",JOptionPane.INFORMATION_MESSAGE);     
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog( null, ""+e+"", "ERROR!", JOptionPane. ERROR_MESSAGE);
            }
        }
        else if(Event.getSource() == jm_github)
        {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) // if the github button is pressed on the main frame //
            {
                try 
                {
                    Desktop.getDesktop().browse(new URI("https://github.com/AtahanEkici/SE-115"));
                } catch (Exception e) 
                {
                JOptionPane.showMessageDialog( null, ""+e.getMessage()+"", ""+e.getClass().getCanonicalName()+"", JOptionPane. ERROR_MESSAGE);
                }
            }
        }
    }    

    @Override
    public void mouseEntered(MouseEvent me) 
    {
        if(me.getSource() == aboutMenu)
        {
            aboutMenu.setSelected(true); // begin hover effect //
        }
    }

    @Override
    public void mouseExited(MouseEvent me) 
    {
        if(me.getSource() == aboutMenu)
        {
            aboutMenu.setSelected(false); // dispose hover effect //
        }
    } 
    // NOT NEEDED //
    @Override
    public void mouseClicked(MouseEvent me){}
    @Override
    public void mousePressed(MouseEvent me){}
    @Override
    public void mouseReleased(MouseEvent me){}
    // NOT NEEDED //
}