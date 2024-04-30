package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
You are given an amount denoted by value. You are also given an array of coins. The array contains the denominations of the give coins.
You need to find the minimum number of coins to make the change for value using the coins of given denominations.
Also, keep in mind that you have infinite supply of the coins.
If making the change is not possible then print "Not Possible"
 */
public class MinimumCoins {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        while(T-->0) {
            int target = Integer.parseInt(bf.readLine());
            int n = Integer.parseInt(bf.readLine());
            String[] line = bf.readLine().split("\\s");
            int[] ar = new int[n];
            for(int i=0;i<n;i++) {
                ar[i] = Integer.parseInt(line[i]);
            }
            int[] dp = new int[target+1];
            int max = Integer.MAX_VALUE;
            dp[0] = 0;
            for(int i=1;i<=target;i++) {
                dp[i] = max;
                for(int j=0;j<ar.length;j++) {
                    if(ar[j] <= i) {
                        dp[i] = Math.min(dp[i] , 1+dp[i-ar[j]]);
                    }
                }
                System.out.print(dp[i] + " ");
            }
            System.out.println(dp[target]);
        }
    }
}
