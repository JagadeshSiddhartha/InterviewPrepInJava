import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class First {
    static class Element {
        int len;
        int last;
        Element(int len, int last) {
            this.len = len;
            this.last = last;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split("\\s");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        line = bf.readLine().split("\\s");
        int[] ar = new int[N];
        for(int i = 0; i < N; i++) {
            ar[i] = Integer.parseInt(line[i]);
        }
        /*
        preprocessing and main logic.
         */
        ArrayList<Element> inc = new ArrayList<>();
        ArrayList<Element> dec = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            inc.add(new Element(0,i));
            dec.add(new Element(0,i));
        }
        buildInc(inc, ar, N);
//        System.out.println();
//        for(int i = 0; i < N; i++) {
//            System.out.println((i + 1) + " " + ar[i] + " " + inc.get(i).len + " " + inc.get(i).last);
//        }System.out.println("-------------");
        buildDec(dec, ar, N);
//        for(int i = 0; i < N; i++) {
//            System.out.println((i + 1) + " " + ar[i] + " " + dec.get(i).len + " " + dec.get(i).last);
//        }
        for(int i = 0; i < M; i++) {
            line = bf.readLine().split("\\s");
            int l = Integer.parseInt(line[0]) - 1;
            int r = Integer.parseInt(line[1]) - 1;
            int incCnt = 0, decCnt = 0;
            incCnt = inc.get(r).len - inc.get(l).len;
            decCnt = dec.get(r).len - dec.get(l).len;
            if(l > 0) {
                if(ar[l - 1] < ar[l] && ar[l] < ar[l + 1]) {
                    incCnt += 1;
                }
                if(ar[l - 1] > ar[l] && ar[l] > ar[l + 1]) {
                    decCnt += 1;
                }
            }

//            if(inc.get(r).last >= l) {
//            }else {
//                incCnt = inc.get(r).len - inc.get(l).len - 1;
//            }
//            if(dec.get(r).last >= l) {
//            }else {
//                decCnt = dec.get(r).len - dec.get(l).len - 1;
//            }
//            incCnt = Math.max(0,incCnt);
//            decCnt = Math.max(0, decCnt);
//            System.out.println(incCnt + " " + decCnt);
            System.out.println(incCnt == decCnt ? "YES" : "NO");
        }

    }

    private static void buildInc(ArrayList<Element> inc, int[] ar, int N) {
        int last = 0, cur_len = 0, tot_len = 0, fix_last = 0;
        for(int i = 0; i < N; i++) {
            if( i == N - 1) {
                if(ar[i] > ar[i - 1]) {
                    tot_len += 1;
                }
                inc.set(i, new Element(tot_len, last));
                break;
            }
            if(ar[i] < ar[i + 1]) {
                if(cur_len == 0) last = i;
                cur_len += 1;
                inc.set(i, new Element(tot_len, last));
            }
            else {
                if(cur_len  != 0) {
                    tot_len += 1;
                    inc.set(i, new Element(tot_len, last));
                    cur_len = 0;
                    fix_last = last;
                }
                else {
                    inc.set(i, new Element(tot_len, last));
                }
            }
        }
    }
    private static void buildDec(ArrayList<Element> dec, int[] ar, int N) {
        int last = 0, cur_len = 0, tot_len = 0, fix_last = 0;
        for(int i = 0; i < N; i++) {
            if( i == N - 1) {
                if(ar[i] < ar[i - 1]) {
                    tot_len += 1;
                }
                dec.set(i, new Element(tot_len, last));
                break;
            }
            if(ar[i] > ar[i + 1]) {
                if(cur_len == 0) last = i;
                cur_len += 1;
                dec.set(i, new Element(tot_len, last));
            }
            else {
                if(cur_len  != 0) {
                    tot_len += 1;
                    dec.set(i, new Element(tot_len, last));
                    cur_len = 0;
                }
                else {
                    dec.set(i, new Element(tot_len, last));
                }
            }
        }
    }
}