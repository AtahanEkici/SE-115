package Lab2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Atahan Ekici
 */
public class Lab2 
{
     public static ArrayList<Integer> RNG(int i) // Random Number Generator (i değişkeni ne kadar popülite edileceğini kontrol eder) //
    {
        int counter = 1;
        Random rand = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        
        while(counter <= i)
        {
            list.add(rand.nextInt(100)); // 0 ila 100 arası bir sayı spawnlanır. //
            counter++;
        }
        return list;
    }
    
    public static void question_1()
    {
        System.out.println("Please input an integer that is ranged between 0-100:");
        Scanner scan = new Scanner(System.in);
        int scanned = scan.nextInt();
        
        if(scanned <= 50)
        {
            System.out.println("FF");
        }
        else if(scanned > 50 && scanned <= 59)
        {
            System.out.println("FD");
        }
         else if(scanned > 60 && scanned <= 64)
        {
            System.out.println("DD");
        }
         else if(scanned > 64 && scanned <= 69)
        {
            System.out.println("DC");
        }
           else if(scanned > 69 && scanned <= 74)
        {
            System.out.println("CC");
        }
            else if(scanned > 74 && scanned <= 79)
        {
            System.out.println("CB");
        }
             else if(scanned > 79 && scanned <= 84)
        {
            System.out.println("BB");
        }
         else if(scanned > 84 && scanned <= 89)
        {
            System.out.println("BA");
        }
        
         else if(scanned >= 90)
        {
            System.out.println("AA");
        }
        else
         {
             System.out.println("Please state an integer value");
         }
    }
     public static void question_2()
    {
        System.out.println("Please state how many students you are going to enter");
        Scanner scan = new Scanner(System.in);
        int total = scan.nextInt();
        for(int counter = 0; counter < total; counter++)
        {
            question_1();
        }
    }
      public static void question_3()
    {
        ArrayList<Integer> list;
        list = RNG(25);
        int total_passed = 0;
        
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i) <= 50)
        {
            System.out.println("FF");
        }
        else if(list.get(i) > 50 && list.get(i) <= 59)
        {
            System.out.println("FD");
        }
         else if(list.get(i) > 59 && list.get(i) <= 64)
        {
            total_passed++;
            System.out.println("DD");
        }
         else if(list.get(i) > 64 && list.get(i) <= 69)
        {
            System.out.println("DC");
            total_passed++;
        }
           else if(list.get(i) > 69 && list.get(i) <= 74)
        {
            System.out.println("CC");
            total_passed++;
        }
            else if(list.get(i) > 74 && list.get(i) <= 79)
        {
            System.out.println("CB");
            total_passed++;
        }
             else if(list.get(i) > 79 && list.get(i) <= 84)
        {
            System.out.println("BB");
            total_passed++;
        }
         else if(list.get(i) > 84 && list.get(i) <= 89)
        {
            System.out.println("BA");
            total_passed++;
        }
        
         else if(list.get(i) >= 90)
        {
            System.out.println("AA");
            total_passed++;
        }
        }// for loops' end //
        System.out.println(total_passed);
    }
       public static void question_4()
    {
                ArrayList<Integer> list;
        list = RNG(25);
        int total_passed = 0;
        int FF=0,FD=0,DD=0,DC=0,CC=0,CB=0,BB=0,BA=0,AA=0;
        
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i) <= 50)
        {
            System.out.println("FF");
            FF++;
        }
        else if(list.get(i) > 50 && list.get(i) <= 59)
        {
            System.out.println("FD");
            FD++;
        }
         else if(list.get(i) > 59 && list.get(i) <= 64)
        {
            total_passed++;
            System.out.println("DD");
            DD++;
        }
         else if(list.get(i) > 64 && list.get(i) <= 69)
        {
            System.out.println("DC");
            total_passed++;
            DC++;
        }
           else if(list.get(i) > 69 && list.get(i) <= 74)
        {
            System.out.println("CC");
            total_passed++;
            CC++;
        }
            else if(list.get(i) > 74 && list.get(i) <= 79)
        {
            System.out.println("CB");
            total_passed++;
            CB++;
        }
             else if(list.get(i) > 79 && list.get(i) <= 84)
        {
            System.out.println("BB");
            total_passed++;
            BB++;
        }
         else if(list.get(i) > 84 && list.get(i) <= 89)
        {
            System.out.println("BA");
            total_passed++;
            BA++;
        }
        
         else if(list.get(i) >= 90)
        {
            System.out.println("AA");
            total_passed++;
            AA++;
        }
        }// for loops' end //
        System.out.println(total_passed);
        System.out.println("AA: "+AA+" BA: "+BA+" BB: "+ " BB: " +BB+ ""+"CB: "+CB+" CC: "+CC+" DC: "+DC+" DD: " +DD+" FD: "+FD+" FF: "+FF);
    }
    
    public static void main(String[] args)
    {
        question_1();
        //question_2();
        //question_3();
        //question_4();
    }
}
