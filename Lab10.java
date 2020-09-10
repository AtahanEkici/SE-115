import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author Atahan Ekici
 */
public class Lab10 
{
    public static void question1()
    {
        ArrayList<String> students = new ArrayList<>();
        final ArrayList<String> houses = new ArrayList<>(4);
        ArrayList<String> matchedStudents = new ArrayList<>();
        int random;
        Scanner scan;
        String scanned;
        
        houses.add("Gryffindor");
        houses.add("Hufflepuff");
        houses.add("Ravenclaw");
        houses.add("Slytherin");
        
        System.out.println("Please Enter the students' names:");
        
        for(int i = 0;i<5;i++)
        {
            scan = new Scanner(System.in);   
            
            if(scan.hasNextLine() == false)
            {
               System.out.println("Please provide a string"); 
            }
            else
            {
                scanned = scan.nextLine();
                students.add(scanned);
            }
        }
        
         for(int i = 0;i<students.size();i++)
         {
             random = ThreadLocalRandom.current().nextInt(1,5); // Randomizer //
             
             switch(random)
             {
                 case 1:
                    matchedStudents.add(students.get(i)+" has joined to " + houses.get(0));
                    break;
                     
                 case 2:
                    matchedStudents.add(students.get(i)+" has joined to " + houses.get(1));
                    break;
                     
                 case 3:
                    matchedStudents.add(students.get(i)+" has joined to " + houses.get(2));
                    break;
                     
                 case 4:
                    matchedStudents.add(students.get(i)+" has joined to " + houses.get(3));
                    break;
                     
                 default:
                    System.out.println("Error");
                    break;     
             }
         }
         
        System.out.println("\nHogwarts sorting Hat has just matched the students with their houses in the following manner:");
        
       for(int i =0;i<matchedStudents.size();i++)
       {
        System.out.println(matchedStudents.get(i));
       }   
    }
    
    public static void search(int[] array,int value)
    {
        for(int i = 0; i<array.length;i++)
        {
            if(array[i] == value)
            {
                System.out.println("value found on index number: "+i+"");
            }
        }
    }
    
    public static void question2()
    {
        int[] myFirstArray = new int[5];
        int[] mySecondArray = new int[5];
        Scanner scan;
        int scanned;
         
        for(int i=0;i<myFirstArray.length;i++)
        {
            scan = new Scanner(System.in);
             
            if(scan.hasNextInt() == false)
            {
                System.out.println("Please provide an integer");
            }
            else
            {
                scanned = scan.nextInt();
                myFirstArray[i] = scanned;
            }
         }
        
        search(myFirstArray,50);
        
        Arrays.sort(myFirstArray);
        
        int sortedValue= Arrays.binarySearch(myFirstArray,60);
        
        if(sortedValue > 0)
        {
            System.out.println("value found on index number: "+sortedValue+"");
        }
        else
        {
            System.out.println("Given value does not exists");
        }
        
        for(int i=0;i<mySecondArray.length;i++)
        {
            scan = new Scanner(System.in);
             
            if(scan.hasNextInt() == false)
            {
                System.out.println("Please provide an integer");
            }
            else
            {
                scanned = scan.nextInt();
                mySecondArray[i] = scanned;
            }
         }
        
        System.out.println(Arrays.toString(mySecondArray));
        System.arraycopy(myFirstArray,0,mySecondArray,0,myFirstArray.length);
        System.out.println("First Array: "+Arrays.toString(myFirstArray));
        System.out.println("Second Array: "+Arrays.toString(mySecondArray));
    }
    
    public static void main(String[] args)
    {
        question1();
        question2();        
    }
}