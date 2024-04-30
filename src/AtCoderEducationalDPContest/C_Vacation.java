package AtCoderEducationalDPContest;
/*
problem link: https://atcoder.jp/contests/dp/tasks/dp_c
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C_Vacation {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = null;
        int n = Integer.parseInt(bf.readLine());
        int[] ar = new int[n];
        int[] br = new int[n];
        int[] cr = new int[n];

        for (int i = 0; i < n; ++i) {
            line = bf.readLine().split("\\s");
            ar[i] = Integer.parseInt(line[0]);
            br[i] = Integer.parseInt(line[1]);
            cr[i] = Integer.parseInt(line[2]);
        }
        int[][] dp = new int[n][3];
        dp[0][0] = ar[0];
        dp[0][1] = br[0];
        dp[0][2] = cr[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2]) + ar[i];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + br[i];
            dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) + cr[i];
        }
        System.out.println(Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2])));


    }
}
