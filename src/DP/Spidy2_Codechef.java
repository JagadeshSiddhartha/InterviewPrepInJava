package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
problem link: https://www.codechef.com/problems/SPIDY2
 */
public class Spidy2_Codechef {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] line = bf.readLine().split("\\s");
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(line[i]);
        }
        long[] dp = new long[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) dp[i] = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= i; j <<= 1) {
                dp[i] = Math.min(dp[i], dp[i - j] + Math.abs(ar[i] - ar[i - j]));
            }
        }
        System.out.println(dp[n - 1]);
    }
}
