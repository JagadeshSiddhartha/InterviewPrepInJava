/*
Given an integer S represented as a string, the task is to get the sum of all possible sub-strings of this string.
 */
package DP;
import java.util.*;
import java.lang.*;
import java.io.*;
public class SumOfAllSubstrings {
    public static void main (String[] args) {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        while(t-->0)
        {
            String str=scan.next();

            System.out.println(sumSubstrings(str));

        }
    }

    private static long sumSubstrings(String str) {
        if(str.length() == 1) return Long.parseLong(str);
        long ans = Long.parseLong( str.charAt(0)+"");
        for(int i = 1;i < str.length();i++) {
            long local = Long.parseLong(str.charAt(i)+"");
            for(int j = i-1;j >= 0;j--) {
                local += Long.parseLong(str.substring(j,i+1));
            }
            ans += local;
        }
        return ans;
    }
}
