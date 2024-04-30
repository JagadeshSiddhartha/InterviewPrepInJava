package DP;
/*
Given two strings str1 and str2, find the length of the smallest string which has both, str1 and str2 as its sub-sequences.
Input:
2
abcd xycd
efgh jghi
Output:
6
6
 */
import java.util.Scanner;

public class SmallestCommonSuperSequence
{
    public static void main (String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        while(test-- > 0){

            String s1=sc.next();            // Take both the string as input
            String s2=sc.next();
            System.out.println(lcs(s1, s2));
        }
    }

    private static int lcs(String s1, String s2) {
        int p = s1.length();
        int q = s2.length();
        int dp[][] =  new int[p+1][q+1];
        for(int i = 0;i<=p;i++){
            for(int j=0;j<=q;j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if(s1.charAt(i-1) == s2.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }
        return p+q-dp[p][q];
    }
}
