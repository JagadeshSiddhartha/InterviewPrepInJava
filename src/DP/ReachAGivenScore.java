package DP;

import java.util.Scanner;

/*
Consider a game where a player can score 3 or 5 or 10 points in a move. Given a total score n,
find number of distinct combinations to reach the given score.
 */
public class ReachAGivenScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0) {
            int n = sc.nextInt();
            int dp[] = new int[n+1];
            dp[0] = 1;
            for(int i = 3;i <= n; i++ ){
                dp[i] += dp[i-3];
            }
            for(int i = 5;i <= n; i++ ){
                dp[i] += dp[i-5];
            }
            for(int i = 10;i <= n; i++ ){
                dp[i] += dp[i-10];
            }
            System.out.println(dp[n]);
        }
    }
}
