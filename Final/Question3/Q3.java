/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question3;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author ataha
 */
public class Q3 
{
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<>();
        
        int random;
        
        for(int i=0;i<100;i++)
        {
        random = ThreadLocalRandom.current().nextInt(1,7);
        list.add(random);
        }
        
        findDistribution(list);
        
    }
    
    private static void findDistribution(ArrayList<Integer> list)
    {
        for(int i=0;i<list.size();i++)
        {
            int temp = list.get(i);
            
            switch (temp)
            {
                case 6:
                    System.out.println("******");
                    break;
                case 5:
                    System.out.println("*****");
                    break;
                case 4:
                    System.out.println("****");
                    break;
                case 3:
                    System.out.println("***");
                    break;
                case 2:
                    System.out.println("**");
                    break;
                case 1:
                    System.out.println("*");
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
            
        }
    }
}
