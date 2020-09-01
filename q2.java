import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Atahan Ekici
 */
public class q2 
{
    public static void main()         
    {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scan;
        int counter = 0;
        
        while(list.size() != 25)
        {
            System.out.println("Please input a integer around 0 - 100:");
            scan = new Scanner(System.in);
            list.add(scan.nextInt());
        }
        
        for(int i = 0; i < list.size(); i++)
        {
            
            if(list.get(i) < 60 && list.get(i) > 0)
            {
                System.out.println("Fail");
                counter++;
            }
        }
        
        System.out.println(counter);
   }
}