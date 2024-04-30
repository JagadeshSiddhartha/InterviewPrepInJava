package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinChangeWays {

    public static long numberOfWays(int coins[],int numberOfCoins,int value)
    {
        long ways[]=new long[value+1];
        ///We declare an array that will contain the number of--
        //ways to make change for all values from 0 to value
        //This is done as we are working from bottom up. So, obviously, we need to make change for smaller values--
        //before we can make change for the given values.

        ways[0]=1;//We can make change for 0 in 1 ways, that is by choosing nothing.

        for(int coin:coins)//Using a coin, one at a time
        {
            for(int i=1;i<value+1;i++)
            {
                if(i>=coin)//Since it makes no sense to create change for value smaller than coin's denomination
                {
                    ways[i] +=  ways[i-coin];
                }
            }
        }
        return ways[value];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        while(T-->0) {
            int target = Integer.parseInt(bf.readLine());
            int n = Integer.parseInt(bf.readLine());
            String[] line = bf.readLine().split("\\s");
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = Integer.parseInt(line[i]);
            }
            System.out.println(numberOfWays(ar, n, target));
        }
    }
}
/*
2
4
3
1 2 3
10
4
2 5 3 6
 */