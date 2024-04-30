package Graphs;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class StronglyConnectedComponents {
    static ArrayList<ArrayList<Integer>> list;
    int size;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-- > 0)
        {
            list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg  =sc.nextInt();
            nov += 1;
            for(int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());

            for(int i = 1; i <= edg; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                //list.get(v).add(u);
            }
            boolean vis[] = new boolean[nov];
            for(int i = 0; i < nov; i++)
                vis[i] = false;
            StronglyConnectedComponents scc = new StronglyConnectedComponents();
            System.out.println(scc.getSCCs(nov));
        }
    }

    private int getSCCs(int nov) {
        Stack st = new Stack();
        boolean vis[] = new boolean[nov];
        for(int i = 0; i < nov; i++)
            vis[i] = false;

        for (int i = 0; i < nov; i++) {
            if( vis[i] == false) {
                fill(i, vis, st);
            }
        }
        ArrayList<ArrayList<Integer>> reversedList = getTransposed(nov);
        for(int i = 0; i < nov; i++)
            vis[i] = false;
        int cnt = 0;
        while(!st.empty()) {
            int v = (int)st.pop();
            if(vis[v] == false) {
                size = 0;
                dfs(reversedList, v, vis);
                cnt = Math.max(cnt, size);
//                System.out.println("_" + size);
            }
        }
        return cnt;
    }

    private  void dfs(ArrayList<ArrayList<Integer>> reversedList, int src, boolean[] vis) {
        vis[src] = true;
        size++;
//        System.out.print(src + " ");
        for(int i = 0;i < reversedList.get(src).size(); i++) {
            int vertex = reversedList.get(src).get(i);
            if(!vis[vertex]) {
               dfs(reversedList, vertex, vis);
            }
        }
    }

    private ArrayList<ArrayList<Integer>> getTransposed(int nov) {
        ArrayList<ArrayList<Integer>> reversedList = new ArrayList<>() ;
        for(int i = 0; i <= nov; i++)
            reversedList.add(i, new ArrayList<Integer>());
        for(int i = 0; i < nov; i ++) {
            for(int j = 0; j < list.get(i).size(); j ++) {
                reversedList.get(list.get(i).get(j)).add(i);
            }
        }
        return reversedList;
    }

    private void fill(int src, boolean[] vis, Stack st) {
        vis[src] = true;
        for(int i = 0;i < list.get(src).size(); i++) {
            int vertex = list.get(src).get(i);
            if(!vis[vertex]) {
                fill(vertex, vis, st);
            }
        }
        st.add(src);
    }
}
