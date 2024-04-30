package DP;

import java.util.Scanner;

public class MaxContinousArraySum2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            System.out.println(maxSumSubArray(a, n));
        }
    }

    private static int maxSumSubArray(int[] a, int n) {
        return 0;
    }
}
