package Bank;
/**
 *
 * @author Atahan Ekici
 */
public class Bank 
{
    private final String bankName;
    
    public Bank(String bankName)
    {
        this.bankName = bankName;
    }
    
    public String getBankName()
    {
        return this.bankName;
    }
    
    @Override
    public String toString() 
    { 
        return this.bankName;
    } 
}
