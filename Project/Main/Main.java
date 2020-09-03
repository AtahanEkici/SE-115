package Main;
import Bank.*;
import UI.*;
/**
 *
 * @author Atahan Ekici
 */
public class Main 
{
    public static void main(String[] args) throws InterruptedException
    {

       Bank bank = new Bank("Banka");
       Account a1 = new Account(bank,"Account1","admin","admin",0.0);
       System.out.println(a1);
       
        UI.getInstance(); 

    }
}
