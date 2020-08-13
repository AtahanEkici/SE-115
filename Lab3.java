import java.util.Scanner;

/**
 *
 * @author Atahan Ekici
 */
public class Lab3 
{
    public static void question1()      
    {
       int min = Integer.MAX_VALUE;
       int max = Integer.MIN_VALUE;
       int sum = 0;
       double avg;
       int scanned;
       
       Scanner scan = new Scanner(System.in);
       
       for(int i = 0; i < 10; i++)
       {
          scanned = scan.nextInt();
          sum += scanned;
          
          if(scanned < min)
          {
              min = scanned;
          }
          
          if(scanned > max)
          {
              max = scanned;
          }
       }
       avg = sum / 10;
       System.out.println("AVG: "+avg+" SUM: "+sum+" MAX: "+max+"  MIN: "+min+" ");
       
    }
    
    public static void question2()      
    {
        int scanned;
       
       Scanner scan = new Scanner(System.in);
       
       for(int i = 0; i < 10; i++)
       {
           scanned = scan.nextInt();
           
           if(scanned == 51)
           {
               System.out.println("Yes");
           }
           else
           {
                System.out.println("No");
           }
       }

    }
    
    public static void question3()      
    {
        int scanned;
        int wanted_value;
       
       Scanner scan = new Scanner(System.in);
       
       System.out.println("Which number you want found?");
       wanted_value = scan.nextInt();
       
        for(int i = 0; i < 10; i++)
       {
           scanned = scan.nextInt();
           
           if(scanned == wanted_value)
           {
               System.out.println("Yes");
           }
           else
           {
                System.out.println("No");
           }
       }
    }
    
    public static void question4()      
    {
       int scanned;
       int wanted_value;
       int number_of_occurs = 0;
       
       Scanner scan = new Scanner(System.in);
       
       System.out.println("Which number you want found?");
       wanted_value = scan.nextInt();
       
        for(int i = 0; i < 10; i++)
       {
           scanned = scan.nextInt();
           
           if(scanned == wanted_value)
           {
               number_of_occurs++;
           }
       }
        System.out.println("Number of Occurences: "+number_of_occurs+" ");
    }

    public static void main(String[] args)
    {
        question1();
        //question2();
        //question3();
        //question4();
    }
}
