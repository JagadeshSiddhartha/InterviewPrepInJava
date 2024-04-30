package AtCoderEducationalDPContest;
/*
problem link: https://atcoder.jp/contests/dp/tasks/dp_a
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_Frog1 {
    static int abs(int a) {
        return Math.abs(a);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] ar = new int[n];
        String[] line = bf.readLine().split("\\s");
        for (int i = 0; i < n; ++i) {
            ar[i] = Integer.parseInt(line[i]);
        }
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = dp[0] + abs(ar[1] - ar[0]);
        for (int i = 2; i < n; i++) {
            int ab1 = abs(ar[i] - ar[i - 1]);
            int ab2 = abs(ar[i] - ar[i - 2]);
            dp[i] = Math.min(ab1 + dp[i - 1], ab2 + dp[i - 2]);
        }
        System.out.println(dp[n - 1]);
    }
}
