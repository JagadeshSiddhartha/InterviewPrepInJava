package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
/*
In the social media network facebook, people look forward to connect to each other. 2 people mutually decides
to connect. In this problem you will be given 2 type of tasks, letsbefriends and arewefriends. In the
letsbefriends query, you will be given 2 person and they will be added to each other circle. In the
arewefriends query, you will be given 2 person and you have to tell whether they are connected
directly/indirectly or they are independent. 2 people are considered friends if they are directly or indirectly
connected.

 */
public class FindFriends_UnionFindProblem {

    static class subset {
        int parent;
        int rank;
    }

    static int find(subset [] subsets , int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets,
                    subsets[i].parent);
        return subsets[i].parent;
    }
    static int findParent(subset[] subsets, int x, int y) {
        int xp = find(subsets, x);
        int yp = find(subsets, y);
        if(xp == yp)return 1;
        return 0;
    }

    static void Union(subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[yroot].rank < subsets[xroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[xroot].parent = yroot;
            subsets[yroot].rank++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        while(T --> 0) {
            int N = Integer.parseInt(bf.readLine());
            String[] names = new String[N];
            String[] line = bf.readLine().split("\\s");
            HashMap<String, Integer> map = new HashMap<>();
            subset [] subsets = new subset[N];
            for(int i = 0; i < N; i++) {
                names[i] = line[i];
                map.put(names[i], i);
                subsets[i] = new subset();
                subsets[i].parent = i;
                subsets[i].rank = 0;
            }
            int K = Integer.parseInt(bf.readLine());
            for(int i = 0;i < K; i++) {
                line = bf.readLine().split("\\s");
                if(line[0].equals("letsbefriends")) {
                    Union(subsets, map.get(line[1]), map.get(line[2]));
                } else if( line[0].equals("arewefriends")) {
                    System.out.println(findParent(subsets, map.get(line[1]), map.get(line[2])));
                }
            }
        }
    }
}
