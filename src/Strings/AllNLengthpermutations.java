package Strings;

public class AllNLengthpermutations {

    static void printPermutations(String res, String src, int n) {
        if(res.length() == n) {
            System.out.println(res);
            return;
        }
        for(int i=0;i<src.length();i++) {
            char c = src.charAt(i);
            printPermutations(res + c, src.substring(0,i) + src.substring(i+1), n);
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        printPermutations("", s, 2);
    }
}
