package DPAgain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        while(T-->0) {
            int target = Integer.parseInt(bf.readLine());
            int n = Integer.parseInt(bf.readLine());
            String[] line = bf.readLine().split("\\s");
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = Integer.parseInt(line[i]);
            }
//            System.out.println(numberOfWays(ar, n, target));
        }
    }
}
