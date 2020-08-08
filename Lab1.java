public class Lab1 
{
    public static int readtwo(int a , int b) // 1 numara //
    {
        int sum = a + b;
        
        return sum;
    }
    
    public static void evenorodd(int a) // 2 numara //
    {
                if(a % 2 == 0)
                {
                    System.out.println(""+a+" is an even number");
                }
                else 
                {
                    System.out.println(""+a+" is an odd number");
                }     
    }
    
    public static void howmany(int a , int b , int c , int d) // 3. ve son soru //
    {
        int odd_counter = 0;
        int even_counter = 0;
        
        if(a % 2 == 0)
        {
            System.out.println(""+a+" is even");
            even_counter++;
        }
        else
        {
            System.out.println(""+a+" is odd");
            odd_counter++;
        }
        
       if(b % 2 == 0)
        {
            System.out.println(""+b+" is even");
            even_counter++;
        }
        else
        {
            System.out.println(""+b+" is odd");
            odd_counter++;
        }
       
       if(c % 2 == 0)
        {
            System.out.println(""+c+" is even");
            even_counter++;
        }
        else
        {
            System.out.println(""+c+" is odd");
            odd_counter++;
        }
       
       if(d % 2 == 0)
        {
            System.out.println(""+d+" is even");
            even_counter++;
        }
        else
        {
            System.out.println(""+d+" is odd");
            odd_counter++;
        }
       
       System.out.println("Total Even number:"+even_counter+"");
       System.out.println("Total Odd number:"+odd_counter+"");
    }
    
     public static void main(String[] args)
    {
        System.out.println(readtwo(2,6)); // answer should be 8 //
        evenorodd(5); // answer should be odd //
        howmany(4,8,9,3); // answer should be 2 odd 2 even //
    }
} 