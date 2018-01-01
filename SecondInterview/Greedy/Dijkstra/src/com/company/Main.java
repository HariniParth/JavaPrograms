package com.company;

// https://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/

public class Main {

    private int V;

    int minimumDistance(int[] dist, boolean[] set){
        int min = Integer.MAX_VALUE, minIndex = -1;
        for(int v=0;v<V;v++){
            if(min > dist[v] && set[v] == false){
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    void printSolution(int[] dist){
        for(int v=0;v<V;v++)
            System.out.println(v+" "+dist[v]);
    }

    void dijkstra(int[][] graph, int src){
        int[] dist = new int[V];
        boolean[] set = new boolean[V];

        for(int v=0;v<V;v++){
            dist[v] = Integer.MAX_VALUE;
            set[v] = false;
        }

        dist[src] = 0;
        for(int count=0;count<V-1;count++){
            int u = minimumDistance(dist, set);
            set[u] = true;
            for(int v=0;v<V;v++){
                if(set[v] == false && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
            }
        }
        
        printSolution(dist);
    }
}
