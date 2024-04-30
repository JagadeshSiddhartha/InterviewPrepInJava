package RandomSums;

import java.util.Scanner;
import java.util.logging.Logger;

public class MinumumBid {
    public static void main(String[] args) {
        String[] st = new Scanner(System.in).nextLine().split("\\s");
        long[] val = new long[st.length];
        int i=0;
        for(String s : st) {
            //Sys
            long loc = 0;
            char ch ='0';
            for(char c: s.toCharArray()) {
                if(c> ch)ch = c;
            }
            if(ch >='A' && ch<='Z') {
                loc = 10 + ch-'A' + 1;
            }else{
                loc = ch-'0' + 1;
            }
            val[i] = Integer.parseInt(Integer.toString(Integer.parseInt(s, (int)loc), 10));
            i++;
        }
        long min = Integer.MAX_VALUE;
        for(long k: val) {
            min = Math.min(min, k);
        }
        System.out.println(min);
    }
}
