package com.company;

// https://www.geeksforgeeks.org/count-possible-paths-source-destination-exactly-k-edges/

public class Main {

    private final int V = 4;

    public int countWalks(int[][] graph, int u, int v, int k){

        if(k == 0 && u == v)
            return 1;
        if(k == 1 && graph[u][v] == 1)
            return 1;
        if(k <= 0)
            return 0;

        int count = 0;
        for(int i=0;i<V;i++)
            if(graph[u][i] == 1)
                count += countWalks(graph, i, v, k-1);

        return count;
    }
}
