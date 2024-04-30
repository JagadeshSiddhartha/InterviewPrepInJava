package AtCoderEducationalDPContest;
/*
problem link: https://atcoder.jp/contests/dp/tasks/dp_b
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_Frog2 {
    static int abs(int a) {
        return Math.abs(a);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split("\\s");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        int[] ar = new int[n];
        line = bf.readLine().split("\\s");
        for (int i = 0; i < n; ++i) {
            ar[i] = Integer.parseInt(line[i]);
        }
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = abs(ar[1] - ar[0]);
        for (int i = 2; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = Math.max(0, i - k); j < i; j++) {
                dp[i] = Math.min(dp[i], dp[j] + Math.abs(ar[i] - ar[j]));
            }
        }
        System.out.println(dp[n - 1]);
    }
}
