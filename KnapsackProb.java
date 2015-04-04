//This is a solution to a modification of the classic knapsack problem, in which you're 
//given a knapsack with a certain capacity and a set of objects with weights w_1, w_2, ....
//Here, we allow for repeats of items: that is, we imagine that we have infinitely many 
//objects of each weight, and the knapsack can contain as many as we like (up to the 
//knapsack's capacity).  

//See https://www.hackerrank.com/challenges/unbounded-knapsack for further details.  

//Note that there are no controls in place to ensure that the user enters a valid input.   

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class KnapsackProb {

    public static int knapSack(int expSum, int[] knap)
    {
        if(knap.length == 0 | expSum == 0)
        {
                return 0;
        }
        else         
        {
            int[] oneLess = Arrays.copyOfRange(knap, 1, knap.length);
            if(knap[0]>expSum)
            {
                return knapSack(expSum, oneLess);
            }
            else 
                return Math.max(knapSack(expSum, oneLess), knap[0]+knapSack(expSum-knap[0],oneLess));
            
        }
    
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tests = input.nextInt();
        for(int i=0; i<tests; i++)
        {
            int size = input.nextInt();
            int arraySize = 0;
            int[] counts = new int[size];
            int[] nums = new int[size];

            int expSum = input.nextInt();
            for(int j=0; j<size; j++)
            {
                int entry = input.nextInt();
                int fits = (int)Math.ceil(expSum/entry);
                arraySize = arraySize+fits;
                counts[j] = fits;
                nums[j]=entry;
            }
            
            int[] knap = new int[arraySize];
            int index = 0;
            for(int j=0; j<size; j++)
                for(int k=0; k<counts[j]; k++)
                {
                    knap[index]=nums[j];
                    index++;
                }
            

            System.out.println(knapSack(expSum, knap));
        }
    }
}