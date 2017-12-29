package com.company;

import java.util.*;

// https://www.geeksforgeeks.org/find-paths-given-source-destination/

public class Main {

    private int V;
    private LinkedList<Integer> adj[];

    Main(int v){
        this.V = v;
        adj = new LinkedList[V];
        for(int i=0;i<v;i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void printAllPaths(int s, int d){
        boolean[] visited = new boolean[V];
        int[] path = new int[V];
        int index = 0;

        for(int i=0;i<V;i++)
            visited[i] = false;

        printAllPathsUtil(s, d, path, visited, index);
    }

    void printAllPathsUtil(int s, int d, int[] path, boolean[] visited, int index){
        visited[s] = true;
        path[index] = s;
        index++;

        if(s == d){
            for(int i=0;i<index;i++)
                System.out.print(path[i]+" ");
        } else {
            Iterator<Integer> it = adj[s].listIterator();
            while(it.hasNext()){
                int n = it.next();
                if(!visited[n])
                    printAllPathsUtil(n, d, path, visited, index);
            }
        }

        index--;
        visited[s] = false;
    }
}
