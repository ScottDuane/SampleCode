// This is standard quicksort with the adaptation that the subarrays being sorted 
// are printed at every recursive iteration.  See https://www.hackerrank.com/challenges/quicksort2
// for a detailed description of the expected output.  

import java.util.*;
public class QuickSortOf {
       
        static int[] quickSort(int[] ar){
            int size = ar.length;
            
            // Base cases: sizes 0, 1, and 2.  
            if(size == 1 | size == 0)
                return ar;
            if(size == 2)
            {
                if(ar[0]>ar[1])
                {
                    int temp = ar[0];
                    ar[0] = ar[1];
                    ar[1] = temp;
                    printArray(ar);
                    return ar;
                }
                else
                {
                    printArray(ar);
                    return ar;
                }
            }
            
            // Iterative case
            else
            {
                int p=ar[0];
                int[] moreTemp = new int[size];
                int[] lessTemp = new int[size];
                int moreCount = 0;
                int lessCount = 0;

                
                for(int j=1; j<size; j++)
                {
                    if(ar[j]>p)
                    {
                        moreTemp[moreCount]= ar[j];
                        moreCount++;
                    }
                    else
                    {
                        lessTemp[lessCount] = ar[j];
                        lessCount++;
                    }
                }
                
                int[] more = new int[moreCount];
                int[] less = new int[lessCount];
                for(int m=0; m<moreCount; m++)
                    more[m] = moreTemp[m];
                for(int k=0; k<lessCount; k++)
                    less[k] = lessTemp[k];
                
                int[] piece1 = new int[lessCount];
                int[] piece2 = new int[moreCount];
                
                // Perform Quicksort on the subarray of smaller elements
                if(lessCount>2)
                {    
                    piece1 = quickSort(less);
                    printArray(piece1);
                }
                else
                    piece1 = quickSort(less);
                
                // Perform Quicksort on the subarray of larger elements 
                if(moreCount>2)
                {
                    piece2 = quickSort(more);
                    printArray(piece2);
                }
                else 
                    piece2 = quickSort(more);
                    
                return merge(piece1, p, piece2);
            }
                
        }

     static int[] merge(int[] array1, int p, int[] array2)
     {
        int size = array1.length + array2.length +1;
        int[] ans = new int[size];
        for(int i = 0; i<size; i++)
        {
            if(i<array1.length)
            {
                ans[i] = array1[i];
                //if(i != array1.length-1)
                    //System.out.print(ans[i] + " ");
            }
            if(i>array1.length)
            {
                ans[i] = array2[i-array1.length-1];
                //if(i != size-1 | array2.length==0 |array1.length==0)
                  //  System.out.print(ans[i]+" ");
            }
            if(i==array1.length)
                ans[i] = p;
        }
        //printArray(ans);
        return ans;
    }
 
 	 // A method for printing the array (since we utilize it a few times in this
 	 // modified version of quicksort)
     static void printArray(int[] ar) {
         for(int n: ar){
            System.out.print(n+" ");
         }
           System.out.println("");
      }


       
      public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int n = in.nextInt();
           int[] ar = new int[n];
           for(int i=0;i<n;i++){
              ar[i]=in.nextInt(); 
           }
           printArray(quickSort(ar));
       }    
   }