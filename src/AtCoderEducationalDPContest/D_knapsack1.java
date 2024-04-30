package AtCoderEducationalDPContest;
/*
problem link: https://atcoder.jp/contests/dp/tasks/dp_d
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D_knapsack1 {
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
        long[][] dp = new long[n + 1][w + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= w; j++) {

                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[n][w]);


    }
}
