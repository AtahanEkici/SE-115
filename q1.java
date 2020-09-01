import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Atahan Ekici
 */
public class q1
{
     public static void main()        
     {
         ArrayList <Integer> list = new ArrayList<>();
         Scanner scan;
         int Max = Integer.MIN_VALUE;
         
         System.out.println("Please Input 6 numbers");
         
         while(list.size() <= 6)
         {
             scan = new Scanner(System.in);
             
             if(scan.nextInt() < 0)
             {
                 list.add(-1 * scan.nextInt());
             }
             else
             {
                 list.add(scan.nextInt());
             }
             
             if(scan.nextInt() > Max)
             {
                 Max = scan.nextInt();
             }
         }
         System.out.println(list);
         System.out.println(Max);
     }
}
