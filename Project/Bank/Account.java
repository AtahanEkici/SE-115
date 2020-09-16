package Bank;
/**
 *
 * @author Atahan Ekici
 */
public class Account extends Bank
{
    private final Bank bank;
    private String User_Name;
    private String password;
    private double balance;
    
    public Account(Bank bank,String Account_Name,String User_Name,String password,double balance)
    {
        super(bank.toString());
        this.bank = bank;
        this.User_Name = User_Name;
        this.password = password;
        this.balance = balance;
    }
    
    public void setUserName(String user_name)
    {
        this.User_Name = user_name;
    }
    public String getUserName()
    {
        return this.User_Name;
    }
    
    public String setPassword()
    {
        return this.password;
    }
    public void getPassword(String password)
    {
        this.password = password;
    }
      
    public void setBalance(double balance)
    {
        this.balance = balance;
    }
    public double getBalance()
    {
        return this.balance;
    }

    @Override
    public String toString() 
    { 
        return String.format("\n-------\nBank: %s\nUser Name:%s\nPassword: %s\nBalance: %s\n-------\n",bank, this.User_Name,this.password,this.balance); 
    } 
}
