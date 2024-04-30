package CCDSAP;
/*
problem link: https://www.codechef.com/problems/DBOY

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DBOY {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(bf.readLine());
            int[] houses = new int[n];
            int[] fuels = new int[n];
            String[] line = bf.readLine().split("\\s");
            int max_distance = 0;
            for (int i = 0; i < n; i++) {
                houses[i] = 2 * Integer.parseInt(line[i]);
                max_distance = Math.max(max_distance, houses[i]);
            }
            line = bf.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                fuels[i] = Integer.parseInt(line[i]);
            }
            Arrays.sort(fuels);
            int[] dp = new int[max_distance + 1];
            Arrays.fill(dp, 100000);
            dp[0] = 0;
            for (int i = 1; i <= max_distance; i++) {
                for (int j = 0; j < fuels.length; j++) {
                    if (fuels[j] <= i) {
                        dp[i] = Math.min(dp[i], 1 + dp[i - fuels[j]]);
                    }
                }
            }
            int total = 0;
            for (int i : houses) {
                total += dp[i];
            }
            System.out.println(total);

        }
    }
}
