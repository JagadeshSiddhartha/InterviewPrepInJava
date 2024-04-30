package DP;

import java.util.Scanner;

/*
problem statement:
You are given an array A of size N. You need to find the maximum-sum of the array provided that you cannot sum
neighboring elements. So for each element of the array, you need to find maximum-sum from initial index till the
element's index.
Examples:
Input:
1
5
4 5 6 7 8
Output:
4 5 10 12 18

 */
public class SumArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T --> 0) {
            int n = sc.nextInt();
            int[] ar = new int[n];
            for(int i = 0; i < n; i++) {
                ar[i] = sc.nextInt();
            }
            int[] dp = new int[n];
            dp[0] = ar[0];
            if(n == 1) {
                System.out.println(dp[0]);
                continue;
            }
            dp[1] = Math.max(ar[1], dp[0]);
            for(int i = 2; i < n; i++) {
                dp[i] = Math.max(dp[i-1], dp[i-2] + ar[i]);
            }
            for(int i : dp) System.out.print(i + " ");
            System.out.println();
        }
    }
}
