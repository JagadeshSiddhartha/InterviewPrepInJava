package DP;
/*
Given two sequences, find the length of longest subsequence present in both of them. Both the strings are of uppercase.
 */

import java.util.Scanner;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int p = sc.nextInt();             // Take size of both the strings as input
            int q = sc.nextInt();

            String s1 = sc.next();            // Take both the string as input
            String s2 = sc.next();
            System.out.println(lcs(p, q, s1, s2));

        }
    }

    private static int lcs(int p, int q, String s1, String s2) {
        int[][] dp = new int[p + 1][q + 1];
        for (int i = 0; i <= p; i++) {
            for (int j = 0; j <= q; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[p][q];
    }
}
