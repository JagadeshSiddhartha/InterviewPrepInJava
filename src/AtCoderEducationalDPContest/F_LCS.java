package AtCoderEducationalDPContest;
/*
problem link: https://atcoder.jp/contests/dp/tasks/dp_f
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F_LCS {
    public static void main(String[] args) throws IOException {
        String s;
        String t;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split("\\s");
        s = line[0];
        line = bf.readLine().split("\\s");
        t = line[0];
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        String ans = "";
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max((dp[i - 1][j]), dp[i][j - 1]);
                }
            }
        }
        int i = s.length(), j = t.length();
        while (i > 0 && j > 0) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                ans += s.charAt(i - 1);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        String rev = "";
        j = ans.length();
        while (j > 0) {
            rev += ans.charAt(j - 1);
            j--;
        }
        System.out.println(rev);
    }
}
