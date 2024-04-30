package AdvancedDS;

public class HeapConversion {

    static void swap(int ar[], int i , int j ) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
    static void maxHeapToMinHeap(int[] ar, int start, int end) {
        int l = start *2 +1;
        int r = start *2 + 2;
        int largest = start;
        if(l<end && ar[l]<ar[start])
            largest = l;
        if(r<end && ar[r]< ar[largest])
            largest = r;
        if(largest != start) {
            swap(ar, start, largest);
            maxHeapToMinHeap(ar, largest, end) ;
        }
    }

    static void maxToMin(int ar[], int n) {
        for(int i=(n-2)/2;i>=0;i--) {
            maxHeapToMinHeap(ar, i,n);
        }
    }

    public static void main(String[] args) {
        int ar[] = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
        maxToMin(ar, ar.length);
    }
}
