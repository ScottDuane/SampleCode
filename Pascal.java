// A HackerRank challenge to produce Pascal's triangle.  Producing Pascal's triangle is
// a trivial problem.  The challenging part here is that the numbers get very large, 
// which Java doesn't handle particularly well.  
// See the text of the challenge here: https://www.hackerrank.com/challenges/ncr-table

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Pascal {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tests = input.nextInt();
        BigInteger[][] pascal = new BigInteger[1000][1000];
        BigInteger ONE = new BigInteger("1");
        pascal[0][0] = ONE;
        pascal[1][0] = ONE;
        pascal[1][1] = ONE;
        BigInteger TheBigGuy = new BigInteger("1000000000");
        for(int i=2; i<1000; i++)
        {
            for(int j=0; j<i+1; j++)
            {
                if(j==0 | j==i)
                    pascal[i][j]= ONE;
                else
                    pascal[i][j] = pascal[i-1][j-1].add(pascal[i-1][j]);
                    
            }
        }    
        
        for(int k=0; k<tests; k++)
        {
            int size = input.nextInt();
            for(int i=0; i<=size; i++)
                System.out.print(pascal[size][i].mod(TheBigGuy)+" ");
            
            System.out.println();
        }
    }
}