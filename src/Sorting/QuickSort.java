package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort {
    static int[] ar;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        while(T-->0) {
            //int target = Integer.parseInt(bf.readLine());
            int n = Integer.parseInt(bf.readLine());
            String[] line = bf.readLine().split("\\s");
            ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = Integer.parseInt(line[i]);
            }
            quickSort(0, n-1);
            for(int i: ar)System.out.print(i + " ");
        }
    }

    private static void quickSort( int start, int end) {
        if(start < end) {
            int ind = partition(start, end);
            quickSort( start, ind - 1);
            quickSort(ind + 1, end);
        }
    }

    private static int partition(int start, int end) {
        int pivot = ar[end];
        int i = start - 1;
        for(int j = start;j< end; j++) {
                if(ar[j] > pivot) {
                    i++;
                    swap(i, j);
                }
        }
        swap(i+1, end);
        return i+1;
    }

    private static void swap( int i, int end) {
        int tem = ar[i];
        ar[i] = ar[end];
        ar[end] = tem;
    }
}
