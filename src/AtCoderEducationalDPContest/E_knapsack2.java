package AtCoderEducationalDPContest;
/*
problem link: https://atcoder.jp/contests/dp/tasks/dp_e
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E_knapsack2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = line = bf.readLine().split("\\s");
        int n = Integer.parseInt(line[0]);
        int w = Integer.parseInt(line[1]);
        int[] wt = new int[n];
        int[] val = new int[n];

        for (int i = 0; i < n; ++i) {
            line = bf.readLine().split("\\s");
            wt[i] = Integer.parseInt(line[0]);
            val[i] = Integer.parseInt(line[1]);
        }
        int total_value = 0;
        for (int value : val) total_value += value;
        long[] dp = new long[total_value + 1];
        dp[0] = 0;
        long INF = Long.MAX_VALUE - Integer.MAX_VALUE; // Just a very long value, to be taken as Infinity.
        for (int i = 1; i < total_value + 1; i++) {
            dp[i] = INF;
        }
        for (int i = 0; i < n; i++) {
            for (int v = total_value - val[i]; v >= 0; v--) {
                dp[v + val[i]] = Math.min(dp[v + val[i]], dp[v] + wt[i]);
            }
        }
        long ans = 0;
        for (int i = 0; i <= total_value; i++) {
            if (dp[i] <= w) {
                ans = Math.max(ans, i);
            }
        }
        System.out.println(ans);
    }
}
