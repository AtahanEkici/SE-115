package Lab11;

import java.util.Scanner;

/**
 *
 * @author Atahan Ekici
 */
public class Test 
{
    public static Student searchStudentArray(Student[] array , String keyName)
    {
        for(int i = 0;i<array.length;i++)
        {
            if(array[i].getName().matches(keyName))
            {
                return array[i];
            }
        }
        return null;
    }
    
    public static int countStudentArray(Student[] array , int keyScore)
    {    
        int counter = 0;
        
        for(int i = 0;i<array.length;i++)
        {
            if(array[i].getScore() >= keyScore)
            {
                counter++;
            }
        }
        return counter;
    }
    
    public static void main(String[] args)
    {
        Scanner scan = null;
        Student[] allStudents = new Student[5];
        String Name;
        int Score;
        
        for(int i = 0;i < allStudents.length;i++)
        {
            allStudents[i] = new Student();
            System.out.println("Enter the name of the student at index " + i + ": ");
            scan = new Scanner(System.in);
            Name = scan.nextLine();
            System.out.println("Enter the exam score of the student at index " + i + ": ");
            Score = scan.nextInt();
            
            allStudents[i].setName(Name);
            allStudents[i].setScore(Score);
        }
        
        System.out.println("\nEnter a name to search a student in the array: ");
        scan = new Scanner(System.in);
        Name = scan.nextLine();
        
        Student searched = searchStudentArray(allStudents, Name);
        
        if(searched == null)
        {
            System.out.println("Not Found");
        }
        else
        {
            System.out.println(searched); // since toString method is overriden i can directly call system output for showing the information //
        }
        
        System.out.println("Enter the minimum passing grade: ");
        scan = new Scanner(System.in);
        Score = scan.nextInt();
        
        System.out.println("Total passed student number is "+countStudentArray(allStudents,Score)+"");
        scan.close();
    }
}
