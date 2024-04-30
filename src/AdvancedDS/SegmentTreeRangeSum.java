package AdvancedDS;

public class SegmentTreeRangeSum {

    static int[] st;

    public static void main(String[] args) {
        int[] ar = {1, 2, 4, 5, 6};
        int len = ar.length;

        int segSize = (int) Math.ceil(Math.log(len) / Math.log(2));
        segSize = 2 * (int) Math.pow(2, segSize) + 1;
        st = new int[segSize];

        constructSegTree(ar, 0, len - 1, 0);

        System.out.println(querySeg(0, 3, 0, len - 1, 0));

        int diff = 5 - ar[2];
        ar[2] = 5;

        updateSeg(0, len - 1, 2, diff, 0);
        System.out.println(querySeg(0, 3, 0, len - 1, 0));

    }

    private static void updateSeg(int start, int end, int index, int diff, int cur) {
        if (index < start || index > end) return;
        st[cur] += diff;
        if (start != end) {
            int mid = (start + end) / 2;
            updateSeg(start, mid, index, diff, cur * 2 + 1);
            updateSeg(mid + 1, end, index, diff, cur * 2 + 2);
        }
    }

    private static int querySeg(int qstart, int qend, int low, int high, int index) {
        if (qstart > high || qend < low)
            return 0;
        if (qstart <= low && qend >= high)
            return st[index];
        int mid = (low + high) / 2;
        return querySeg(qstart, qend, low, mid, index * 2 + 1) + querySeg(qstart, qend, mid + 1, high, index * 2 + 2);
    }

    private static int constructSegTree(int[] ar, int start, int end, int index) {
        if (start == end) {
            st[index] = ar[start];
            return st[index];
        }
        int mid = (start + end) / 2;
        st[index] = constructSegTree(ar, start, mid, 2 * index + 1) +
                constructSegTree(ar, mid + 1, end, 2 * index + 2);
        return st[index];
    }
}
