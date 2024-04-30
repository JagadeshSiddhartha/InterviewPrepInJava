package RandomSums;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Islands {
    static class island {
        long dis;
        long num;
        island(long dis, long num) {
            this.dis = dis;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        long [][] ar = new long[n][4];
        for(int i=0;i<n;i++) {
            //String line[] = bf.readLine().split("\\s");
            ar[i][0] = sc.nextLong();
            ar[i][1] = sc.nextLong();;
            ar[i][2] = sc.nextLong();
            ar[i][3] = sc.nextLong();
        }
        long warx, wary;
        warx = sc.nextLong();
        wary = sc.nextLong();
        ArrayList<island> islands = new ArrayList<>();
        for(int i=0;i<n;i++) {
            long dis = 0;
            long dis1, dis2, dis3, dis4;
            dis1 = distance(warx, wary, ar[i][0], ar[i][1]);
            dis2 = distance(warx, wary, ar[i][2], ar[i][3]);
            dis3 = distance(warx, wary, ar[i][0], ar[i][3]);
            dis4 = distance(warx, wary, ar[i][2], ar[i][1]);
            //System.out.println(i+1 + " " + dis1 + " " + dis2 + " " + dis3 + " " + dis4) ;
            dis = Math.min(dis1, Math.min(dis2, Math.min(dis3, dis4)));
            islands.add(new island(dis, i));
        }
        Collections.sort(islands, new Comparator<island>() {
            @Override
            public int compare(island o1, island o2) {
                if(o1.dis==o2.dis){
                    return (int) (o2.num-o1.num);
                }
                return (int) (o1.dis - o2.dis);
            }
        });
        for(int i=0;i<islands.size();i++) {
            System.out.print(islands.get(i).num+1 + " ");
        }
        System.out.println();
    }

    private static long distance(long warx, long wary, long i, long j) {
        return Math.abs(warx-i) + Math.abs(wary - j);
    }
}