package com.company;

// https://www.geeksforgeeks.org/greedy-algorithms-set-5-prims-minimum-spanning-tree-mst-2/

public class Main {

    private int V;

    int minKey(int[] key, boolean[] set){
        int min = Integer.MAX_VALUE, minIndex = -1;
        for(int v=0;v<V;v++){
            if(set[v] == false && key[v] < min){
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    void printSolution(int[][] graph, int[] parent){
        for(int i=0;i<V;i++){
            System.out.println(parent[i]+" i "+graph[i][parent[i]]);
        }
    }

    void primMST(int[][] graph){
        int[] parent = new int[V];
        int[] key = new int[V];
        boolean[] set = new boolean[V];

        for(int v=0;v<V;v++){
            key[v] = Integer.MAX_VALUE;
            set[v] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for(int count=0;count<V-1;count++){
            int u = minKey(key, set);
            set[u] = true;

            for(int v=0;v<V;v++){
                if(graph[u][v] != 0 && set[v] == false && graph[u][v] < key[v]){
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }

            printSolution(graph, parent);
        }
    }
}
