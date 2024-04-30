package RandomSums;

import java.util.Scanner;

public class CoinsRequired {
    static long[][] filler = {{1,2,1,2,1,2,1,2},{0,0,1,1,2,2,3,3}};
    public static void main(String[] args) {
        long num = new Scanner(System.in).nextLong();
        solve(num);
    }

    private static void solve(long num) {
        int fcnt = 0;
        while(num > 8){
            fcnt++;
            num -= 5;
        }
        //long tot = fcnt + filler[0][(int)num] + filler[1][(int)num];
        System.out.println(fcnt + filler[0][(int)(num-1)] + filler[1][(int)(num-1)] + " " + fcnt + " " + filler[1][(int)(num-1)] + " " + filler[0][(int)(num-1)]);

    }
}
