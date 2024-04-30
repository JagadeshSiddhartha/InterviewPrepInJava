package AdvancedDS;

public class SegmentTreeRMQ {
    static int[] st;

    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 45, 26, 3, 547, 357};
        int len = ar.length;
        int segSize = (int) Math.ceil(Math.log(len) / Math.log(2));
        segSize = 2 * (int) Math.pow(2, segSize) + 1;
        st = new int[segSize];

        constructSeg(ar, 0, ar.length - 1, 0);
        System.out.println(querySeg(0, 3, 0, ar.length - 1, 0));
        for(int i : st)
            System.out.print(i + " ");
    }

    private static int querySeg(int qstart, int qend, int low, int high, int index) {
        if (qstart < low || qend > high) {
            return Integer.MIN_VALUE;
        }
        if (qstart >= low && qend <= high) {
            return st[index];
        }
        int mid = (low + high) / 2;

        return Math.max(querySeg(qstart, qend, low, mid, 2 * index + 1), querySeg(qstart , qend, mid + 1, high, 2* index + 2));
    }

    private static int constructSeg(int[] ar, int start, int end, int index) {
        if (start == end) {
            st[index] = ar[start];
            return st[index];
        }
        int mid = (start + end) / 2;
        st[index] = Math.max(constructSeg(ar, start, mid, 2 * index + 1),
                constructSeg(ar, mid + 1, end, 2 * index + 2));
        return st[index];
    }

}
