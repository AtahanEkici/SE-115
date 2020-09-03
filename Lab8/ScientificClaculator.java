package Lab8;

import java.util.Scanner;

/**
 *
 * @author Atahan Ekici
 */
public class ScientificClaculator 
{
    public static void displayMenu()
    {
        int secim = 0;
        
    while(secim != 5)
    {
    System.out.println("\nA sample scientific calculator is running now ...\n" +
"Here are the menu options for your choice (1 through 5):\n" +
"*** Press 1 to calculate POWER ***\n" +
"*** Press 2 to calculate SQUARE ROOT ***\n" +
"*** Press 3 to calculate MAXIMUM ***\n" +
"*** Press 4 to calculate LOGARITHM ***\n" +
"*** Press 5 to TERMINATE the program ***");
    System.out.println("Your Choice: ");
    
    Scanner secim_s = new Scanner(System.in);
    
    if(secim_s.hasNextDouble() == false)
    {
        System.out.println("\nPlease provide an double as stated above"); 
    }
    else
    {
        secim = secim_s.nextInt();
        
        switch(secim)
        {
            case 1:
                calculatePower();
                break;
                
            case 2:
                calculateSquareRoot();
                break;
                
            case 3:
                calculateMaximum();
                break;
                
            case 4:
                calculateLogarith();
                break;
                
            case 5:
                System.out.println("Program Terminated by User");
                break; 
    }
   }
  } 
}
    
    public static void calculatePower()
    {
        System.out.println("Please give 2 integer values: ");
        Scanner pow = new Scanner(System.in);
        double x = pow.nextDouble();
        pow = new Scanner(System.in);
        double y = pow.nextDouble();
        System.out.println("\n"+Math.pow(x, y)+"\n");
    }
    
    public static void calculateMaximum()
    {
        System.out.println("Please give 2 integer values: ");
        Scanner max = new Scanner(System.in);
        double x = max.nextDouble();
        max = new Scanner(System.in);
        double y = max.nextDouble();
        System.out.println("\n"+Math.max(x, y)+"\n");
    }
    
    public static void calculateSquareRoot()
    {
        System.out.println("Please give an integer value: ");
        Scanner root = new Scanner(System.in);
        double x = root.nextDouble();
        System.out.println("\n"+Math.sqrt(x)+"\n");
    }
    
    public static void calculateLogarith()
    {
        System.out.println("Please give an integer value: ");
        Scanner log = new Scanner(System.in);
        double x = log.nextDouble();
        System.out.println("\n"+Math.log(x)+"\n");
    }
    
    public static void calculateFactoriel()
    {
        long result = 1;
        
        System.out.println("\nPlease give an integer");
        Scanner fac = new Scanner(System.in);
        long i = fac.nextLong();
        
        if(i == 1 || i == 0)
        {
          System.out.println(1);
        } 
        else
        {
            while(i > 1)  
            {
                result *= i;
                i--;
            }
        }
        System.out.println("Factoriel: "+result);
    }
}
