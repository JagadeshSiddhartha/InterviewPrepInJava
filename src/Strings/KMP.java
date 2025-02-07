package Strings;

import java.util.Base64;

public class KMP {
    static int[] lcs;

    public static void main(String[] args) {
        String text = "ABABDABACDAABCCCBABABCABAB";
        String pattern = "AABAACAABAA";
        findWithKMP(text, pattern);
    }

    private static void findWithKMP(String text, String pattern) {
        lcs = new int[pattern.length()];

        fillLCS(pattern);
        for(int i : lcs)
            System.out.print(i + " ");
        System.out.print("\n");

        int i = 0, j = 0;
        int n = text.length(), m = pattern.length();

        while(i<n) {
            if(pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if(j == m) {
                System.out.println("match found at " + (i-j));
                j = lcs[j-1];
            }
            else if(i < n && pattern.charAt(j) != text.charAt(i)) {
                if(j != 0)
                    j = lcs[j-1];
                else
                    i ++;
            }
        }
    }

    private static void fillLCS(String pattern) {
        int i = 1;
        int len = 0;
        lcs[0] = 0;
        while(i< pattern.length()) {
            if(pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lcs[i] = len;
                i++;
            } else {
              if(len == 0) {
                lcs[i] = 0;
                i++;
              } else {
                  len = lcs[len-1];
              }
            }
        }
    }
}
