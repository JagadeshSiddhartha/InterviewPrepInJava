package RandomSums;

import java.util.Scanner;
import java.util.Stack;

public class BalancingStars {
    static class StackElement {
        char bracket;
        int count = 0;
        public StackElement(char c) {
            this.bracket = c;
        }
    }
    static boolean b = true;

    public static void main(String[] args) {
        String string  = new Scanner(System.in).nextLine();
        Stack<StackElement> stack = new Stack<>();
        int cnt = solve(string, 0);
        if (b == false || cnt == 0){
            System.out.print("No ");
        } else {
            System.out.print("Yes ");
        }
        System.out.print(cnt);
    }
    static char comp(char c) {
        if(c =='{')return '}';
        else if(c == '[') return ']';
        else return ')';
    }

    private static int solve(String s, int start) {

        char c ='_';
        int i;
        for(i=0;i<s.length();i++) {
            c = s.charAt(i);
            if(c == '{' || c =='[' || c =='(')
            {
                break;
            }
            else if(c=='}' || c == ']' || c==')'){
                b = false;
            }
        }
        if( i ==s.length())
            return 0;
        int star = 0;
        for(int j= s.length()-1;j>=i+1;j--)
        {
           if(s.charAt(j) == comp(c)){
               for(int k=i+1;k<j;k++){
                   if(s.charAt(k) == '{' || s.charAt(k) =='[' || s.charAt(k) =='(')
                   {
                       b = false;
                   }
                   if(s.charAt(k) == '*')star++;
               }
                if(star > 1) {
                    return 1 + solve(s.substring(i+1,j) + s.substring(j+1), i+1);
                } else {
                    b = false;
                    return solve(s.substring(i+1), i+1);
                }
            }
        }
        b = false;
        return solve(s.substring(i+1), i+1);
    }
}
