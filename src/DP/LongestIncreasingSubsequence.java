package DP;
import java.util.*;
import java.lang.*;
import java.io.*;
/*
Given a sequence A of size N, find the length of the longest increasing subsequence from a given sequence .
The longest increasing subsequence means to find a subsequence of a given sequence in which the subsequence's elements are in sorted order,
lowest to highest, and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.
 */

public class LongestIncreasingSubsequence {
    
    public static void main (String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        while(t-- > 0)
        {
            int n=in.nextInt();
            int arr[]=new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = in.nextInt();
            }


            System.out.println(longestSubsequence(n, arr));

        }
    }

    private static long longestSubsequence(int n, int[] arr) {
        long dp[] = new long[n+1];
        for(int i=0;i<=n;i++)dp[i]=1;
        for(int i=1;i<n;i++) {
            for(int j = 0;j<i;j++) {
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        long max = 0;
        for(long  i:dp)max = Math.max(max, i);
        return max;
    }
}