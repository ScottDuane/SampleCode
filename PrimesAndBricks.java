// Another HackerRank challenge.  This one was essentially two problems in one:
// 1) Count the number of primes less than or equal to a particular integer,
// 2) Count the number of configurations of 1x4 and 4x1 bricks in a 4xN space (leaving
//    no holes).
// See the text of the challenge here: https://www.hackerrank.com/challenges/red-john-is-back

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PrimesAndBricks {
	// Counts the number of arrangements of bricks.  Easily made more robust by replacing
	// 4 with a parameter that gets passed in.
    public static int brickCount(int width)
    {
        if(width<4)
            return 1;
        if(width >= 4)
            return brickCount(width-4)+brickCount(width-1);
        
        return 0;
    }
    
    // Tests if the given integer is prime
    public static boolean isPrime(int num)
    {
        int cap = (int)Math.ceil(Math.sqrt(num));
        
        for(int i=2; i<=cap; i++)
            if(num%i == 0)
                return false;

        return true;
    }
    
    //Recursively counts the number of primes less than a given integer
    public static int primes(int num)
    {
        if(num == 1)
            return 0;
        if(num==2)
            return 1;
        if(num>0)
            if(isPrime(num))
            {   
                //System.out.println(num+ " is prime");
                return 1+primes(num-1);
            }
            else
                return primes(num-1);
        return 0;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tests = input.nextInt();

        for(int i=0; i<tests; i++)
        {
            int bricks = input.nextInt();
            System.out.println(primes(brickCount(bricks)));
        }
    }
}