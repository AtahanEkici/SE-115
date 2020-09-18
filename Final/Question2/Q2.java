/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question2;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author ataha
 */
public class Q2 
{
    static int[] myArray;
    
    public Q2(int size)
    {
        myArray = new int[size];
    }
    
    public void fillArray(int limit)
    {
        for(int i=0;i<myArray.length;i++)
        {
            Random random = new Random();
            int randomized  = random.nextInt(limit);
            myArray[i] = randomized;
    }
    }
        
        public void print()
        {
            System.out.println(Arrays.toString(myArray));
        }
}
