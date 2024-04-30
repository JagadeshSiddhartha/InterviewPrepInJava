package RandomSums;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class BottleNeck {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line[] = bf.readLine().split("\\s");
        int n = Integer.parseInt(line[0]);
        line = bf.readLine().split("\\s");;
        Long ar[] = new Long[n];
        Long mini = 0L;
        for(int i=0;i<n;i++) {
            ar[i] = Long.parseLong(line[i]);
        }
        Arrays.sort(ar);
        Stack<Long> st = new Stack<>();
        st.add(ar[0]);

        for(int i=1;i<ar.length;i++) {
            if(ar[i] == st.peek()) {
                ArrayList<Long> li = new ArrayList<>();
                while(!st.isEmpty()) {
                    if(st.peek() < ar[i]) {
                        st.pop();
                        st.add(ar[i]);
                        break;
                    }
                    li.add(st.pop());
                }
                if(st.isEmpty()) {
                    st.add(ar[i]);
                }
                for(int j = 0;j<li.size();j++) {
                    st.add(li.get(j));
                }

            } else{
                st.pop();
                st.add(ar[i]);
            }
        }
        System.out.println(st.size());

    }
}
