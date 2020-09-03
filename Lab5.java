package Lab5;

import java.util.Scanner;

/**
 *
 * @author Atahan Ekici
 */
public class Lab5 
{
    public static void printer(int i , String Country)
    {
        Integer.toString(i);
        System.out.println(""+i+" is the calling code For "+Country+"");
    }
    
    public static void question_1()      
    {
        System.out.println("Enter a calling code please");
        
        Scanner scanned = new Scanner(System.in);
        
        int scan = scanned.nextInt();
        
        switch(scan)
        {
            case 1:
                printer(1,"Canada");
                break;
                
            case 32:
                printer(32,"Belgium");
                break;
                
            case 44:
                printer(44,"United Kingdom");
                break;
                
            case 47:
                printer(47,"Norway");
                break;
                
            case 55:
                 printer(55,"Brazil");
                 break;
                 
            case 90:
                 printer(90,"Turkey");
                 break;
                 
            case 234:
                 printer(234,"Nigeria");
                 break;
                 
            default:
                System.out.println("No such Country Code is listed please try again\n");
                question_1();
                break;
        }
    }
    
    public static void question_2()
    {
        System.out.println("Please Enter a degree value(in Celcius):");
        
        Scanner scan = new Scanner(System.in);
        
        int scanned = scan.nextInt();
        
        if(scanned >= 30)
        {
            System.out.println(""+scanned+" is a Hot day");
        }
        else if(scanned < 30 && scanned >= 17)
        {
            System.out.println(""+scanned+" is a Pleasant day");
        }
        else if(scanned < 17)
        {
            System.out.println(""+scanned+" is a Cold day");
        }
        else if(scan.hasNextInt() == false)
        {
            System.out.println("Wrong input please try again");
            question_2();
        }
        else
        {
            System.out.println("Wrong input please try again");
            question_2();
        }
    } 
    
    public static void main(String[] args)
    {
        question_1();
        question_2();
    }
}
