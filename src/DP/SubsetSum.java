package DP;
/*
Given a set of numbers, check whether it can be partitioned into two subsets
such that the sum of elements in both subsets is same or not.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubsetSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        while(T --> 0) {
            int n = Integer.parseInt(bf.readLine());
            String[] line = bf.readLine().split("\\s");
            int[] ar = new int[n];
            int total = 0;
            for (int i = 0; i < n; i++) {
                ar[i] = Integer.parseInt(line[i]);
                total += ar[i];
            }
            if(total % 2 == 1) {
                System.out.println("NO");
            } else {
                System.out.println(isFine(ar, n, total/2) ? "YES" : "NO");
            }

        }
    }

    private static boolean isFine(int[] ar, int n, int total) {

        boolean[][] dp = new boolean[n+1][total+1];
        for(int i = 0;i <= n; i++) {
            for(int j = 0; j <= total; j++) {
                if(i==0) {
                    dp[i][j] = false;
                } else if(j == 0) {
                    dp[i][j] = true;
                } else {
                    if(j < ar[i-1]) {
                        dp[i][j] = dp[i-1][j];
                    }
                    else dp[i][j] = dp[i-1][j] || dp[i-1] [j-ar[i-1]];
                }
            }
        }
        return dp[n][total];
    }
}
