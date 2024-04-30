package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value
in the knapsack. Note that we have only one quantity of each item.
In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 */
public class Knapsack {
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());

            int val[] = new int[n];
            int wt[] = new int[n];

            String st[] = read.readLine().trim().split("\\s+");
            for(int i = 0; i < n; i++)
                val[i] = Integer.parseInt(st[i]);

            String s[] = read.readLine().trim().split("\\s+");
            for(int i = 0; i < n; i++)
                wt[i] = Integer.parseInt(s[i]);

            System.out.println(knapSack(w, wt, val, n));
        }
    }

    private static int knapSack(int w, int[] wt, int[] val, int n) {
        /*
        if(w == 0 || n == 0)return 0;
        if(wt[n-1] > w)return knapSack(w,wt, val, n-1);
        else {
            return Math.max(knapSack(w, wt, val, n-1), val[n-1]+knapSack(w-wt[n-1], wt, val,n-1));
        }
         */
        int dp[][] = new int[n+1][w+1];
        for(int i=0;i<=n;i++) {
            for(int j = 0;j <= w; j++) {
                if( i == 0 || j == 0) dp[i][j] =  0;
                else {
                    if(wt[i-1] > j) dp[i][j] = dp[i-1][j];
                    else dp[i][j] = Math.max(dp[i-1][j], val[i-1]+dp[i-1][j-wt[i-1]]);
                }
            }
        }
        return dp[n][w];


    }
}
