package AdvancedDS;

import java.util.Scanner;

/*
problem statement: Given a max heap array mHeap of positive integers of size N and a positive integer k.
The task is to find the kth maximum element of the heap.
Input:
2
7 3
50 40 30 35 38 20 25
9 6
60 55 57 54 53 50 52 51 49

Output:
38
52
Explanation
Testcase 1: The given array 40 38 35 30 20 25 of max heap is as shown:
                                              50(0)
                                             /     \
                                         40(1)      38(2)
                                         /     \
                                     35(3)      30(4)
                                   /      \
                               20(5)     25(6)

Now the top 3 maximum elements are 50 40 38, so the 3rd maximum element will be 38.
 */
public class KthMaxInMaxHeap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while( T --> 0) {
            int n = sc.nextInt(), k = sc.nextInt();
            int[] ar = new int[n];
            for(int i = 0; i < n; i++) {
                ar[i] = sc.nextInt();
            }
        }
    }
}
