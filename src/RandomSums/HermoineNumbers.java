package RandomSums;

import java.io.*;
import java.util.*;
class HermoineNumbers {
    static String src;
    static String dest;
    static String near;
    static long nearVal = 99999999;
    static void permute(String str, int l, int r)
    {
        if (l == r)
        {
            if(Long.parseLong(str) > Long.parseLong(dest) && Long.parseLong(str) - Long.parseLong(dest) < nearVal ) {
                nearVal = Long.parseLong(str) - Long.parseLong(dest);
                near = str;
            }
        }
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }

    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main (String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        src = sc.next();
        dest = sc.next();
        near  = "_";
        permute(src, 0, src.length()-1);
        System.out.println(near);
    }
}