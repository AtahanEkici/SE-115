package UI;
import Bank.Account;import Bank.Bank;import static Utilities.Utility.readInfo;import java.awt.BorderLayout;import java.awt.Color;import java.awt.Desktop;import java.awt.FlowLayout;import java.awt.Font;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.awt.event.KeyEvent;import java.awt.event.KeyListener;import java.awt.event.MouseEvent;import java.awt.event.MouseListener;import java.awt.event.WindowAdapter;import java.awt.event.WindowEvent;import java.math.BigDecimal;import java.math.MathContext;import java.net.URI;import java.util.ArrayList;import javax.swing.BorderFactory;import javax.swing.ImageIcon;import javax.swing.JButton;import javax.swing.JComboBox;import javax.swing.JFrame;import javax.swing.JLabel;import javax.swing.JMenu;import javax.swing.JMenuBar;import javax.swing.JMenuItem;import javax.swing.JOptionPane;import javax.swing.JPanel;import javax.swing.JPasswordField;import javax.swing.JTextField;import javax.swing.Timer;import javax.swing.event.DocumentEvent;import javax.swing.event.DocumentListener;
/**
 *
 * @author Atahan Ekici
 */
public final class UI extends JFrame implements ActionListener,MouseListener,KeyListener
{    
    private static UI single_instance = null;
    
    private UI()
    {
        try
        {
            Construct_Credential_Frame();
            Construct_Main_Frame();
            Construct_Exchange_Frame();
            refresher();
            balancer();
        }
        catch(Exception e)
        {
              JOptionPane.showMessageDialog(null, e.getMessage(), e.getClass().getCanonicalName(),JOptionPane.ERROR_MESSAGE);
        }   
    }  
    // ------------------------------ Swing Components ------------------------------ //
    private static JFrame main,credential,exchange;
    private static JPanel jp1,jp2;
    private static JButton withdraw,deposit,refresh,exc,SUBMIT,selected;
    private static JMenu aboutMenu;
    private static JMenuBar mb;
    private static JMenuItem jm_about,jm_github;
    private static JLabel info,balanceLabel,info2,warner;
    private static JComboBox box;
    private static JTextField amount;
    private static Timer timer;
    // ------------------------------ Swing Components ------------------------------ // 
    
    private static final Color PALE_BLACK = new Color(33, 37, 41);
    
    private static final String Id = "admin";
    
    private double current_dollar=-1, current_euro=-1;
    
    // Bank and Account //
    private static final Bank bank = new Bank("Banka");
    private static final Account a1 = new Account(bank, "Account1", "admin", "admin", 1000.0);
    // Bank and Account //
    
    private double balance = a1.getBalance();
    private double Euro_balance = 0.0;
    private double Dollar_balance = 0.0;
    private double current_witdraw;
    private double current_deposit;
    
    public static UI getInstance()
    {
        if(single_instance == null)
        {
            single_instance = new UI();
        }
        return single_instance;    
    }
        
    private void balancer()
    {
        Euro_balance = round(Euro_balance);
        Dollar_balance = round(Dollar_balance);
        balance = round(balance);
        balanceLabel.setText("Your Balance is: | Euro: "+Euro_balance+" | Dollar: "+Dollar_balance+" | TL: "+balance+"");
    }
    
private void update()
{
String sample = amount.getText(); // Get Text From //
int index = box.getSelectedIndex(); // Get Selected Currency //
try
{
  double value = Double.parseDouble(sample);
  
  if(index == 0)
  {
      value *= current_dollar;
  }
  else
  {
      value *= current_euro;
  }
  value = round(value);
  warner.setText("Given Amount is : "+value+"");
}
catch(NumberFormatException e)
{
    warner.setText("Please give a Double parameter");
}
  }
    
    private void Construct_Exchange_Frame()
    {
        exchange = new JFrame("Exchange Menu");
        ImageIcon image = new ImageIcon(getClass().getResource("/Icons/exchange.png"));
        exchange.setIconImage(image.getImage());
        exchange.getContentPane().setBackground(PALE_BLACK);
        exchange.setLayout(null);
        exchange.setSize(300,250);
        exchange.setResizable(false);
        exchange.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        exchange.addKeyListener(this);
        
        final String[] Currencies = {"Dollar", "Euro"};
        
        box = new JComboBox(Currencies);
        box.setSelectedIndex(0);
        box.setSize(100,25);
        box.setLocation(190,0);
        box.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                update();
            }  
        });
        
        info2 = new JLabel();
        info2.setSize(100,25);
        info2.setLocation(10,10);
        info2.setBackground(PALE_BLACK);
        info2.setForeground(Color.WHITE);
        
        JLabel label = new JLabel("Amount:");
        label.setSize(100,25);
        label.setLocation(10, 75);
        label.setForeground(Color.WHITE);
        label.setBackground(PALE_BLACK);
        
        warner = new JLabel();
        warner.setSize(200,20);
        warner.setLocation(50, 110);
        warner.setForeground(Color.WHITE);
        warner.setBackground(PALE_BLACK);
        
        amount = new JTextField();
        amount.setSize(150,25);
        amount.setLocation(65,75);
        amount.addKeyListener(this);
        amount.getDocument().addDocumentListener(new DocumentListener() 
        {
  @Override
  public void changedUpdate(DocumentEvent e)
  {
    update();
  }
  @Override
  public void removeUpdate(DocumentEvent e)
  {
    update();
  }
  @Override
  public void insertUpdate(DocumentEvent e)
  {
    update();
  }
});
        
        selected = new JButton("Exchange");
        selected.setSize(100,25);
        selected.setLocation(100,150);
        selected.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                int selection = box.getSelectedIndex();
                double offset_euro,offset_dolar;
                double value;
                
                switch (selection) 
                {
                    case 0:
                        try
                        {
                            value = Double.parseDouble(amount.getText());
                            value = round(value);
                                    
                            if(value < 0)
                            {
                                JOptionPane.showMessageDialog(null, "You can't enter negative values!!", "Error!!",JOptionPane.ERROR_MESSAGE);
                            }
                            else if(value * current_dollar > balance)
                            {
                                JOptionPane.showMessageDialog(null, "The value you entered is exceeding your balance", "Error!!",JOptionPane.ERROR_MESSAGE);
                            }
                            else
                            {   
                            offset_dolar = value * current_dollar;
                            balance -= offset_dolar;
                            Dollar_balance = value;
                            balancer();
                            JOptionPane.showMessageDialog(null, "Successfully Exchanged","Success",JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                        catch(Exception e)
                        {
                            if(e instanceof NullPointerException)
                            {
                                JOptionPane.showMessageDialog(null, "Nothing is entered", e.getClass().getCanonicalName(),JOptionPane.ERROR_MESSAGE);
                            }
                            else if(e instanceof NumberFormatException)
                            {
                                JOptionPane.showMessageDialog(null, "You need to type double", e.getClass().getCanonicalName(),JOptionPane.ERROR_MESSAGE);
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, e.getLocalizedMessage(), e.getClass().getCanonicalName(),JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        
                        break;
                        
                    case 1:
                        try
                        {
                            value = Double.parseDouble(amount.getText());
                            value = round(value);
                            
                            if(value < 0)
                            {
                                JOptionPane.showMessageDialog(null, "You can't enter negative values!!", "Error!!",JOptionPane.ERROR_MESSAGE);
                            }
                            else if(value * current_euro > balance)
                            {
                                JOptionPane.showMessageDialog(null, "The value you entered is exceeding your balance", "Error!!",JOptionPane.ERROR_MESSAGE);
                            }
                            else
                            {   
                            offset_euro = value * current_euro;
                            balance -= offset_euro;
                            Euro_balance = value;
                            balancer();
                            JOptionPane.showMessageDialog(null, "Successfully Exchanged","Success",JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                        catch(Exception e)
                        {
                            if(e instanceof NullPointerException)
                            {
                                JOptionPane.showMessageDialog(null, "Nothing is entered", e.getClass().getCanonicalName(),JOptionPane.ERROR_MESSAGE);
                            }
                            else if(e instanceof NumberFormatException)
                            {
                                JOptionPane.showMessageDialog(null, "You need to type double", e.getClass().getCanonicalName(),JOptionPane.ERROR_MESSAGE);
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, e.getLocalizedMessage(), e.getClass().getCanonicalName(),JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        break;
                        
                    default:
                        JOptionPane.showMessageDialog(null, "Wrong Input Path", "Error!!",JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }  
        });
        exchange.add(info2);
        exchange.add(box);
        exchange.add(label);
        exchange.add(warner);
        exchange.add(amount);
        exchange.add(selected);
        exchange.setLocationRelativeTo(main);
        exchange.setVisible(false);
    }
    
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
        credential.addKeyListener(this);
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
        label2.addKeyListener(this);
        
        JTextField ID = new JTextField();  // ID Field //
        ID.setBounds(90,82,150,20);  
        ID.addKeyListener(this);
        
        JLabel label3 = new JLabel("Pass:");  
        label3.setBounds(55,80,250,100);
        label3.setForeground(Color.WHITE);
        label3.addKeyListener(this);
        
        JPasswordField Password = new JPasswordField();  // Password Field //
        Password.setBounds(90,120,150,20);
        Password.setEchoChar('*');
        Password.addKeyListener(this);
        
        SUBMIT = new JButton();  
        SUBMIT.setText("SUBMIT");
        SUBMIT.setBounds(100,200,100,40);
        SUBMIT.setFocusable(false);
        SUBMIT.addActionListener((new ActionListener()
        {  
    @Override
    public void actionPerformed(ActionEvent e)
    {  
            String id = ID.getText();
            String Pass = Password.getText();
            
            if(id.equals(Id) && Pass.equals(Id))
            {
                main.setVisible(true);
                credential.dispose();
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
        credential.add(SUBMIT);
        credential.setLocationRelativeTo(null);
        credential.setVisible(true);
    }
    
     private static double round(double value) // Rounds given presicion integer into 3 significant figures //
    {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.round(new MathContext(4));
        value = bd.doubleValue();
        return value;
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
            balanceLabel.setBounds(10,50,600,100);
            balanceLabel.setForeground(Color.WHITE);
            balanceLabel.setFont(new Font("Serif", Font.PLAIN, 20));
            
            jp1 = new JPanel();
            jp1.setBackground(PALE_BLACK);
            jp1.setForeground(Color.WHITE);
            
            jp2 = new JPanel(new FlowLayout());
            jp2.setBackground(PALE_BLACK);
            jp2.setForeground(Color.WHITE);
            
            info = new JLabel("                 Euro:                 Dollar:                 ");
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
            
            refresh = new JButton("Refresh"); 
            refresh.setFocusable(false);
            refresh.addActionListener(this);
            refresh.setBackground(Color.WHITE);
            refresh.setForeground(PALE_BLACK);
            
            exc = new JButton("Exchange"); 
            exc.setFocusable(false);
            exc.addActionListener(this);
            exc.setBackground(Color.WHITE);
            exc.setForeground(PALE_BLACK);
            
            deposit = new JButton("Deposit");
            deposit.setFocusable(false);
            deposit.addActionListener(this);
            deposit.setBackground(Color.WHITE);
            deposit.setForeground(PALE_BLACK);
            
            jp2.add(withdraw);
            jp2.add(deposit);
            jp2.add(exc);
            jp2.add(refresh);
            
            main.add(balanceLabel,BorderLayout.CENTER);
            main.add(jp1,BorderLayout.NORTH);
            main.add(jp2,BorderLayout.CENTER);
            
            main.setLocationRelativeTo(null);
            main.setVisible(false);
        }

    private void refresh()
    {
        main.setVisible(false);
        main.dispose();
        setter();
        main.repaint();
        main.revalidate();
        main.setVisible(true);  
    }
    
    private void setter()
    {
        ArrayList<Double> list = readInfo();
        String text;
        
        String text2;
        double euro = list.get(0);
        double dolar = list.get(1);

        if(current_euro == -1)
        {
           current_euro = euro;
        }
        if(current_dollar == -1)
        {
           current_dollar  = dolar;
        }
        
        if(current_euro < euro)
        {
            text = "<html>Euro: <FONT COLOR=RED> " +euro+ "</FONT> ";
            text2 = "<html>Euro: <FONT COLOR=RED> " +euro+ "</FONT> ";
        }
        else if(current_euro == euro)
        {
            text = "<html>Euro: <FONT COLOR=YELLOW> " +euro+ "</FONT> ";
            text2 = "<html>Euro: <FONT COLOR=YELLOW> " +euro+ "</FONT> ";
        }
        else
        {
            text = "<html>Euro: <FONT COLOR=GREEN> " +euro+ "</FONT> ";
            text2 = "<html>Euro: <FONT COLOR=GREEN> " +euro+ "</FONT> \n";
        }
        
        
        if(current_dollar < dolar)
        {
            text += " Dolar: <FONT COLOR=RED> " +dolar+ "</FONT> ";
            text2 += " Dolar: <FONT COLOR=RED> " +dolar+ "</FONT> ";
        }
        else if(current_dollar == dolar)
        {
            text += " Dolar: <FONT COLOR=YELLOW> " +dolar+ "</FONT> ";
            text2 += " Dolar: <FONT COLOR=YELLOW> " +dolar+ "</FONT> ";
        }
        else
        {
            text += " Dolar: <FONT COLOR=GREEN> " +dolar+ "</FONT> ";
            text2 += " Dolar: <FONT COLOR=GREEN> " +dolar+ "</FONT> ";
        }
        info.setText(text);
        info2.setText(text2);
    }
    
    private void refresher()
    {
        timer = new Timer(5000, (ActionEvent e) -> 
        {
            setter();
        });
        timer.start();
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
                    balancer();
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
                current_deposit = Double.parseDouble(JOptionPane.showInputDialog(null," Please Specify Deposit Amount:"));
                
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
                    balancer();
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
        else if(Event.getSource() == refresh)
        {
            refresh();
            setter();
        }
        
        else if(Event.getSource() == exc)
        {
            exchange.setVisible(true);
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

    @Override
    public void keyPressed(KeyEvent e) 
    {
        if(credential.isActive() == true)
        {
        if (e.getKeyCode()== KeyEvent.VK_ENTER)
        {
            SUBMIT.doClick();
        } 
        }
        else if(exchange.isActive() == true)
        {
            if (e.getKeyCode()== KeyEvent.VK_ENTER)
        {
            selected.doClick();
        }
        }
    }

    // NOT NEEDED //
    @Override
    public void keyTyped(KeyEvent ke){}
    @Override
    public void keyReleased(KeyEvent ke){}
    // NOT NEEDED //
}


