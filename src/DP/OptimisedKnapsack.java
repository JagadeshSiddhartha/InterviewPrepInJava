package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OptimisedKnapsack {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());

            int[] val = new int[n];
            int[] wt = new int[n];

            String[] st = read.readLine().trim().split("\\s+");
            for (int i = 0; i < n; i++)
                val[i] = Integer.parseInt(st[i]);

            String[] s = read.readLine().trim().split("\\s+");
            for (int i = 0; i < n; i++)
                wt[i] = Integer.parseInt(s[i]);

            System.out.println(optimisedKnapsack(w, wt, val, n));
        }
    }

    private static int optimisedKnapsack(int W, int[] wt, int[] val, int N) {
        int[] dp = new int[W + 1];
        for (int item = 0; item < N; item++) {
            int weight = wt[item];
            int value = val[item];
            for (int w = W - weight; w >= 0; w--) {
                dp[w + weight] = Math.max(dp[w + weight], value + dp[w]);
            }
        }
        int ans = 0;
        for (int value : dp) {
            ans = Math.max(ans, value);
        }
        return ans;
    }

}
