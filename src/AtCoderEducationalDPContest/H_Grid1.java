package AtCoderEducationalDPContest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H_Grid1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split("\\s");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int mod = (int) 1e9 + 7;

        int[][] dp = new int[n][m];
        String e;
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            e = bf.readLine();
            for (int j = 0; j < m; j++) {
                if (e.charAt(j) == '.') {
                    if (i + 1 < n) {
                        dp[i + 1][j] += dp[i][j];
                        if (dp[i + 1][j] > mod) {
                            dp[i + 1][j] -= mod;
                        }
                    }
                    if (j + 1 < m) {
                        dp[i][j + 1] += dp[i][j];
                        if (dp[i][j + 1] > mod) {
                            dp[i][j + 1] -= mod;
                        }
                    }
                }
            }
        }
        System.out.println(dp[n - 1][m - 1]);

    }
}
