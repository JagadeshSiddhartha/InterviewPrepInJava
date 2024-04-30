package AtCoderEducationalDPContest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class I_Coins {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        int T = Integer.parseInt(line[0]);
        line = bf.readLine().split(" ");
        double[] in = new double[T];
        for (int i = 0; i < T; i++) {
            in[i] = Double.parseDouble(line[i]);
        }
        double[] dp = new double[T + 1];
        dp[0] = 1;
        for (int i = 1; i <= T; i++) {
            dp[i] = dp[i - 1] * in[i - 1];
            for (int j = i - 1; j > 0; j--) {
                dp[j] = dp[j] * (1 - in[i - 1]) + dp[j - 1] * in[i - 1];
            }
            dp[0] = dp[0] * (1 - in[i - 1]);
        }
        double ans = 0;
        for (int i = T / 2 + 1; i <= T; i++) {
            ans += dp[i];
        }
        System.out.println(ans);
    }
}
