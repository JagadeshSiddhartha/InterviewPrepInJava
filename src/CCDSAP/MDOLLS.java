package CCDSAP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class MDOLLS {
    static class doll {
        int width;
        int height;
        doll(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(bf.readLine());
            String[] line = bf.readLine().split("\\s");
            doll[] ar = new doll[n];
            for (int i = 0, l = 0; l < 2 * n;i++) {
                ar[i] = new doll(Integer.parseInt(line[l]), Integer.parseInt(line[l + 1]));
                l += 2;
            }
//            Collections.sort(ar);
            Arrays.sort(ar, new Comparator<>() {
                @Override
                public int compare(doll o1, doll o2) {
                    if(o1.width != o2.width)
                        return o2.width - o1.width;
                    else
                        return o2.height - o1.height;
                }
            });
//            for(doll d :ar) {
//                System.out.println(d.width + " " + d.height);
//            }
            System.out.println(solve(ar));
        }
    }

    private static int solve(doll[] ar) {
        int n = ar.length;
        boolean[] vis = new boolean[n];
        int i = 0;
        int blocks = 0;
        while(i<n) {
            if(vis[i]) {
                while(vis[i]) {
                    i++;
                    if(i==n)break;
                }
            }
            if(i==n)break;
            vis[i] = true;
            int st = i;
            blocks++;
            doll prev = ar[i];
            for(;st < n;st++) {
                if(!vis[st] && less(ar[st], prev)) {
                    vis[st] = true;
                    prev = ar[st];
                }
            }
            i++;
//            for(boolean b : vis) System.out.print(b + " ");
//            System.out.println();
        }
        return blocks;
    }

    private static boolean less(doll doll, doll prev) {
        if(doll.height >= prev.height || doll.width >= prev.width)return false;
        return true;
    }
}
