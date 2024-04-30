package DP;
/*
You are given an array A of size N. The array contains integers and is of even length.
The elements of the array represent N coin of values V1, V2, ....Vn. You play against an opponent in an alternating way.


 */
import java.util.Scanner;

public class OptimalStrategy {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            System.out.println(countMaximum(arr, 0, n));
        }
    }

    private static long countMaximum(int[] arr,int start, int end) {
        if(start >= arr.length-1 || end <= 0)return 0;
        if(start == end)return arr[start];
        if(start +1 == end) return Math.max(arr[start], arr[end]);
        if(start > end)return 0;
        //F(i, j)  = Max(Vi + min(F(i+2, j), F(i+1, j-1) ),
        //                   Vj + min(F(i+1, j-1), F(i, j-2) ))
        return Math.max(arr[start] + Math.min(countMaximum(arr, start+2, end), countMaximum(arr, start+1, end-1)),
                        arr[end-1] + Math.min(countMaximum(arr, start + 1, end-1), countMaximum(arr, start, end-2)));
    }
}
