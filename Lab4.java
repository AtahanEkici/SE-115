package Lab4;

import java.util.Scanner;

/**
 *
 * @author Atahan Ekici
 */
public class Lab4 
{
    
    public static void question_1()
    {
        System.out.println("Please state your name");
        Scanner scan = new Scanner(System.in);
        System.out.println("Your name is (as you stated): "+scan.nextLine()); // nextLine gets the String from scanner //
    }
    
    public static void question_2()
    {
        int first;
        int second;
        int sum;
        Scanner scan;
        
        System.out.println("Please enter an integer"); // Ask the first input //
        scan = new Scanner(System.in); // initialize scanner //
        first = scan.nextInt(); // Save the first input //
        
        System.out.println("Please enter another integer"); // Ask the final input //
        scan = new Scanner(System.in); // initialize the scanner for the final input //
        second = scan.nextInt();// Save the second input //
        scan.close();
        
        
        sum = first + second; // Add the two integers that we gathered from our Scanner and sum them up and save the result in the integer sum //
        System.out.println("\nTotal Sum: "+sum); // Print the sum //
    }
    
    public static void question_3()
    {
        int scanned;
        Scanner scan;
        
        System.out.println("Please provide an integer:");
        scan = new Scanner(System.in);
        scanned = scan.nextInt();
        
        if(scanned % 2 == 0)
        {
            System.out.println("\nThe number is even");
        }
        else
        {
            System.out.println("\nThe number is odd");
        }
    }
    
    public static void question_4()
    {
        int first;
        int second;
        Scanner scan;
        
        System.out.println("Please provide an integer:");
        scan = new Scanner(System.in);
        first = scan.nextInt();
        
        System.out.println("Please provide another integer");
        scan = new Scanner(System.in);
        second = scan.nextInt();
        scan.close();
        
        if(first > second)    
        {
            System.out.println("The first number("+first+") is greater than the second one("+second+")");
        }
        else if(first < second)
        {
            System.out.println("The second number("+second+") is greater than the first one("+first+")");
        }
        else if(first == second)
        {
            System.out.println("They are equal");
        }
        else
        {
            System.out.println("Hata");
        }
    }
    
    public static void main(String[] args)
    {
        //question_1();
        //question_2();
        //question_3();
        question_4();
    }
}
