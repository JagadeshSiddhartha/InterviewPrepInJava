package CCDSAP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class XORSUB {
    static int[][] dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        while(T --> 0) {
            String[] line = bf.readLine().split("\\s");
            n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);
            int[] ar = new int[n];
            line = bf.readLine().split("\\s");

            for(int i = 0; i < n; i++) {
                ar[i] = Integer.parseInt(line[i]);
            }
            dp = new int[n +  1][1024];
            for(int i = 0; i <= n; i++) {
                for(int j = 0; j <= 1023;j ++) {
                    dp[i][j] = -1;
                }
            }
//            Arrays.fill(dp, -1);
            System.out.println(solve(ar, 0, k));
        }
    }

    private static int solve(int[] ar, int i, int k) {
        //System.out.println(k + " "+ i);
        if(i == n)return k;
        if(dp[i][k] != -1)return dp[i][k];
        dp[i][k] = Math.max(solve(ar, i + 1, ar[i] ^ k), solve(ar, i + 1, k));
        return dp[i][k];
    }
}
