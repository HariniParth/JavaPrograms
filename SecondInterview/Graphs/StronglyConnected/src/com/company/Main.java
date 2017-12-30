package com.company;

import java.util.*;

// https://www.geeksforgeeks.org/connectivity-in-a-directed-graph/

public class Main {

    private int V;
    private  LinkedList<Integer> adj[];

    Main(int v){
        this.V = v;
        adj = new LinkedList[V];
        for(int i=0;i<v;i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean[] visited){
        visited[v] = true;
        Iterator<Integer> it = adj[v].listIterator();
        while(it.hasNext()){
            int n = it.next();
            if(!visited[n])
                DFSUtil(n, visited);
        }
    }

    Main getTranspose(){
        Main graph = new Main(V);
        for(int i=0;i<V;i++){
            Iterator<Integer> it = adj[i].listIterator();
            while(it.hasNext()){
                graph.adj[it.next()].add(i);
            }
        }
        return graph;
    }

    boolean isStronglyConnected(){

        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++)
            visited[i] = false;

        DFSUtil(0, visited);

        for(int i=0;i<V;i++)
            if(visited[i] == false)
                return false;

        for(int i=0;i<V;i++)
            visited[i] = false;

        Main graph = getTranspose();
        graph.DFSUtil(0, visited);

        for(int i=0;i<V;i++)
            if(visited[i] == false)
                return false;

        return true;
    }
}
