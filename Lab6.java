package Lab6;

import java.util.Scanner;

/**
 *
 * @author Atahan Ekici
 */
public class Lab6 
{
    public static long factoriel(long i)
    {
        long result = 1;
        
        if(i == 1 || i == 0)
        {
          return 1; 
        } 
        else
        {
            while(i > 1)  
            {
                result *= i;
                i--;
            }
        }
        return result;
    }
    
    public static void question_1()
    {
       long scanned;
       Scanner scan;
       
       System.out.println("Please specify the factoriel number:");
       scan = new Scanner(System.in);
       
       if(scan.hasNextLong() == false)
       {
           System.out.println("\nWrong Input\n");
           question_1();
       }
       else
       {
        scanned = scan.nextInt();
        System.out.println("Factoriel Of "+scanned+": "+factoriel(scanned));
        System.out.println();
       }
    }
    
    public static void question_2()
    {
        Scanner scan;
        int pd=0,cd=0,hd=0,value;
        double total_temp = 0;
        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
        boolean initialized = false;

       System.out.println("\n Please Enter degree values in Celcius (-1000 to quit):");
        
        while(true)
        {
         
       scan = new Scanner(System.in);
        
        value = scan.nextInt();
        
        if(initialized == false)
        {
            if(value == - 1000)
            {
                System.exit(0);
                break;
            }
                        
            max = value;
            min = value;
            initialized = true;
        }
        
         if(value == - 1000)
          {
              int sum = cd + pd + hd;
              double avg = (total_temp / sum);
              
              System.out.println();
              System.out.println("Number of cold days: "+cd+"");
              System.out.println("Number of pleasant days: "+pd+"");
              System.out.println("Number of hot days: "+hd+"");
              
              System.out.println();
              System.out.println("The lowest temperature is "+min+" degrees Celcius.");
              System.out.println("The highest temperature is "+max+" degrees Celcius.");
              System.out.println("The average temperature is "+avg+" degrees Celcius.");
              
              System.exit(0);
              
              break;
          }
        
          if(max < value)
          {
              max = value;
          }
          if(min > value)
          {
              min = value;
          }
   
         if(value >= 30)
          {
              hd++;
              total_temp += value;
              System.out.println(""+value+" is a hot day");
          }
          else if(value <= 29 && value >= 17)
          {
              pd++;
              total_temp += value;
              System.out.println(""+value+" is a pleasant day");
          }
          else if(value <= 16)
          {
              cd++;
              total_temp += value;
              System.out.println(""+value+" is a cold day");
          }
          else
          {
              System.out.println("Please enter a integer value");
          }
        }
    }
    
    public static void main(String[] args)
    {
         question_1();
         question_2();
    }
}
