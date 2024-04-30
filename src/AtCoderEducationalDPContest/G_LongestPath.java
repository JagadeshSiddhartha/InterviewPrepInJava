package AtCoderEducationalDPContest;

import java.util.ArrayList;
import java.util.Scanner;

public class G_LongestPath {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] indegree;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) {
        int n, m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>(n);
        indegree = new int[n];
        dist = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++)
            graph.add(i, new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a-1).add(b-1);
            indegree[b-1]++;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i] && indegree[i] == 0) {
                dfs(i);
            }
        }
        int ans = 0;
        for(int dis : dist) {
            ans = Math.max(ans, dis);
        }
        System.out.println(ans);

    }

    private static void dfs(int a) {
        if(visited[a]) return;
        visited[a] = true;
        for (int b : graph.get(a)) {
            dist[b] = Math.max(dist[b],dist[a] + 1);
            indegree[b]--;
            if (indegree[b] == 0) {
                dfs(b);
            }
        }
    }
}
