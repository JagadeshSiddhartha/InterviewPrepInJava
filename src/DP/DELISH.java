package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DELISH {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(bf.readLine());
            int[] ar = new int[n];
            String[] line = bf.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                ar[i] = Integer.parseInt(line[i]);
            }
            long[][] left = new long[n][2];
            long[][] right = new long[n][2];
            left[0][0] = ar[0];
            left[0][1] = ar[0];
            right[n - 1][0] = ar[n - 1];
            right[n - 1][1] = ar[n - 1];
            for (int i = 1; i < n; i++) {
                left[i][0] = Math.max(0, left[i - 1][0]) + ar[i];
                left[i][1] = Math.min(0, left[i - 1][1]) + ar[i];
            }

            for (int i = n - 2; i >= 0; i--) {
                right[i][0] = Math.max(right[i + 1][0], 0) + ar[i];
                right[i][1] = Math.min(right[i + 1][1], 0) + ar[i];
            }
            long ans = 0;

            for (int i = 0; i < n-1; i++) {
                ans = Math.max(ans,Math.abs(left[i][0] - right[i+1][1]));
                ans = Math.max(ans,Math.abs(left[i][1] - right[i+1][0]));
            }
            System.out.println(ans);

        }
    }
}


/*
total 18 days..
preperation topics:
Binary Search
Graphs: BFS, DFS, Flood Fill, Union Find
Trees: Traversals and other model problems
Linked Lists, stacks, queues
heaps, segment tree, trie
DP




*/











































