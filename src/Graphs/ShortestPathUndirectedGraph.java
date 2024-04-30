package Graphs;

import java.util.*;

/*
Problem statement:  You have an undirected connected graph having V nodes and E edges. Edges have weight representing
the time in seconds it takes to travel through that edge. An adventure tour is being organised on this graph. Given a
source node from where you will begin the tour and K distinct flags, corresponding to K distinct nodes, are also kept
at the source node. You have to post these flags at their respective nodes (flag 1 will be placed at node 1, 2 will be
at node 2, and so on...), by carrying them to those nodes one by one. You can visit nodes in any order of your choice.
At a particular instance, you can only carry one flag along with you. Tour ends when all the K flags have been posted
at their respective nodes. Find the minimum time in seconds to complete the tour, starting from the source node.
Output:
Print the minimum time in seconds, required to complete the tour.
Input:
2
5 7
1 2 11
1 3 2
1 4 11
1 5 10
2 4 12
3 4 13
3 5 13
4 2
2 5
2 1
1 2 5
1 1
2

Output:
45
5

 */
public class ShortestPathUndirectedGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt(), E = sc.nextInt();
            ArrayList<ArrayList<node>> data = new ArrayList<>(V);
            for(int i = 0; i < V; i++) {
                data.add(new ArrayList<>());
            }
            for(int i = 0; i < E; i++) {
                int src, dest, dist;
                src = sc.nextInt();
                dest = sc.nextInt();
                dist = sc.nextInt();
                data.get(src - 1).add(new node(dest - 1, dist));
                data.get(dest - 1).add(new node(src - 1, dist));
            }
            int S = sc.nextInt(), K = sc.nextInt();
            ArrayList<Integer> flags = new ArrayList<>();
            for(int i = 0; i < K; i++) {
                int tem = sc.nextInt();
                flags.add(tem);
            }
            ArrayList<Integer> distance = new ArrayList<>();
            for(int i = 0; i < V; i++) {
                distance.add(Integer.MAX_VALUE);
            }
            findShort(data, S-1, distance);
            ArrayList<Integer> flagsDistance = new ArrayList<>();
            for(int i: flags) {
                flagsDistance.add(distance.get(i-1));
            }
            int totalDistance = 0;
            Collections.sort(flagsDistance);
            for(int i = 0; i < flagsDistance.size() - 1; i++) {
                totalDistance += flagsDistance.get(i) * 2;
            }
            if(flagsDistance.size() > 0)
                totalDistance += flagsDistance.get(flagsDistance.size() - 1);
            //for(int i : distance)System.out.print(i + " ");
            System.out.println(totalDistance);
        }
    }

    private static void findShort(ArrayList<ArrayList<node>> list, int src, ArrayList<Integer> distance) {
        Queue<Integer> que = new LinkedList<>();
        que.add(src);
        boolean[] vis = new boolean[distance.size()];
        vis[src] = true;
        distance.set(src, 0);
        while(!que.isEmpty())
        {
            Integer top = que.poll();
            //System.out.print(top + " ");
            for(int i=0;i<list.get(top).size();i++)
            {
                int dest = list.get(top).get(i).dest;
                if(!vis[dest] && distance.get(dest) == Integer.MAX_VALUE)
                {
                    if(distance.get(dest) > distance.get(top) + list.get(top).get(i).dist)
                        distance.set(dest, distance.get(top) + list.get(top).get(i).dist);
                    vis[dest] = true;
                    que.add(dest);
                } else if( vis[dest]) {
                    if(distance.get(dest) > distance.get(top) + list.get(top).get(i).dist)
                        distance.set(dest, distance.get(top) + list.get(top).get(i).dist);
                }
            }
        }
    }

    static class node {
        int  dest, dist;

        node(int dest, int dist) {
            this.dest = dest;
            this.dist = dist;
        }
    }
}
/*
1
4 4
1 2 10
1 3 1
1 4 2
3 2 2
1 2
2 4
 */