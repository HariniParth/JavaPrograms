package com.company;

import java.util.*;

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

    void DFS(int s){
        boolean[] visited = new boolean[V];
        DFSUtil(s, visited);
    }

    void DFSUtil(int s, boolean[] visited){
        visited[s] = true;
        System.out.print(s+" ");

        Iterator<Integer> it = adj[s].listIterator();
        while(it.hasNext()){
            int n = it.next();
            if(!visited[n])
                DFSUtil(n, visited);
        }
    }
}
