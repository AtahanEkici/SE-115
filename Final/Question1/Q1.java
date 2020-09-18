package Question1;
/**
 *
 * @author Atahan Ekici
 */
public class Q1 
{
    public static int recursivePower(int a, int b)
    {
       if ( b == 0 ) 
       {
        return 1;
       }
    return ( a * recursivePower(a , b - 1));
    }
    
    public static void iterativePower(int a , int b)
    {
        int temp = a;
        
        while(b > 1)
        {
            --b;
            temp *= a;  
        }
        System.out.println(temp);
    }
    
    public static void main(String[] args)
    {
       // System.out.println( recursivePower(6,2));
       iterativePower(6,1);
    }
    
}