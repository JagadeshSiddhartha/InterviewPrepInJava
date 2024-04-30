package DP;
/*
Given an array of integers where each element represents the max number of steps that can be made forward from that element.
The task is to find the minimum number of jumps to reach the end of the array (starting from the first element).
If an element is 0, then cannot move through that element.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumJumps {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        while (T-- > 0) {
//            int target = Integer.parseInt(bf.readLine());
            int n = Integer.parseInt(bf.readLine());
            String[] line = bf.readLine().split("\\s");
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = Integer.parseInt(line[i]);
            }
            int[] dp = new int[n + 1];
            dp[1] = 0;
            int maxi = Integer.MAX_VALUE;
            for (int i = 2; i <= n; i++) dp[i] = maxi;
            for (int size = 2; size <= n; size++) {
                for (int i = 1; i < size; i++) {
                    if (dp[size] > dp[i] + 1 && (ar[i - 1] + i >= size) && dp[i] != maxi)
                        dp[size] = dp[i] + 1;
                }
            }
            System.out.println(dp[n] == maxi ? -1 : dp[n]);
        }
    }
}


