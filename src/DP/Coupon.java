package DP;

import java.io.IOException;
import java.util.Scanner;

/*
Problem link: https://www.codechef.com/problems/COUPON
 */
public class Coupon {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] prices = new int[n][m];
            int[][] discount = new int[n][m];
            long[][] dp = new long[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    prices[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    discount[i][j] = sc.nextInt();
                }
            }

            long cur_min = Long.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                dp[0][j] = prices[0][j];
                cur_min = Math.min(cur_min, dp[0][j]);
            }

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dp[i][j] = Math.min(cur_min + prices[i][j], dp[i - 1][j] + Math.max(0, prices[i][j] - discount[i - 1][j]));
                }
                cur_min = Long.MAX_VALUE;
                for (int j = 0; j < m; j++) {
                    cur_min = Math.min(cur_min, dp[i][j]);
                }
            }
            System.out.println(cur_min);
        }
    }
}
