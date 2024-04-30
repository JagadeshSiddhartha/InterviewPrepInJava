package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;

/*
problem statement: You are given a 2D square matrix of dimensions N*N. The matrix is filled with odd and even numbers
randomly. Now you start at the (0,0) cell and your goal is to reach (N-1,N-1) cell. Now, condition is that you can only
 move in down direction a cell or in right direction a cell. Also, you can only move to cells that have even numbers in
 them. The  number at (0,0) doesn't matter as you start in that cell.
Input:
The first line of input is T denoting the number of testcases. T testcases follow. Each testcase contains two lines of input. The first line is N. The second line contains N*N elements of the matrix separated by spaces.

Output:
For each testcase, print 1 if it is possible to reach (N-1,N-1) from (0,0) cell, else print 0

Input:
2
2
1 2 3 4
3
1 2 3 4 5 6 7 8 9
Output:
1
0
 */
public class MatrixDestination {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(bf.readLine());
            int[][] ar = new int[n][n];
            String[] line = bf.readLine().split("\\s");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    ar[i][j] = Integer.parseInt(line[k]);
                    k++;
                }
            }
            boolean res = find(ar, 0, 0, n - 1, n - 1);
            System.out.println(res ? 1 : 0);
        }
    }

    private static boolean find(int[][] ar, int sx, int sy, int ex, int ey) {
        if (sx > ex || sy > ey) {
            return false;
        }
        if((sx == ex) && (sy == ey)) {
            return ar[sx][sy] % 2 == 0;
        } else if (sx == ex) {
            return ((ar[sx][sy + 1] % 2) == 0) ? find(ar, sx, sy + 1, ex, ey) : false;
        } else if (sy == ey) {
            return ((ar[sx + 1][sy] % 2) == 0) ? find(ar, sx + 1, sy, ex, ey) : false;
        }
        if ((ar[sx + 1][sy] % 2 == 0) && (ar[sx][sy + 1] % 2 == 0)) {
            return find(ar, sx + 1, sy, ex, ey) || find(ar, sx, sy + 1, ex, ey);
        } else if (ar[sx + 1][sy] % 2 == 0) {
            return find(ar, sx + 1, sy, ex, ey);
        } else if (ar[sx][sy + 1] % 2 == 0) {
            return find(ar, sx, sy + 1, ex, ey);
        } else {
            return false;
        }
    }
}
