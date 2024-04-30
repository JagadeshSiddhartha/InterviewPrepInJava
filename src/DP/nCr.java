package DP;

import java.lang.*;
import java.util.*;

public class nCr {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int testcase = s.nextInt();
        while (testcase > 0) {
            int n = s.nextInt();
            int r = s.nextInt();
            System.out.println(nCrModp(n, r));

            testcase--;
        }
    }

    public static int nCrModp(int n, int r) {
        int p = 1000000007;
        int[][] dp = new int[n + 1][r + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, r); j++) {
                if (j == 0 || j == i)
                    dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    dp[i][j] %= p;
                }
            }
        }
        return dp[n][r] % p;
    }

}


