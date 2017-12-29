package com.company;

import java.util.*;

// https://www.geeksforgeeks.org/detect-cycle-undirected-graph/

public class Main {

    private int V;
    private LinkedList<Integer> adj[];

    Main(int v){
        this.V = v;
        adj = new LinkedList[V];
        for(int i=0;i<v;i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    boolean isCyclic(int s){
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i])
                if(isCyclicUtil(i, visited, -1))
                    return true;
        }
        return false;
    }

    boolean isCyclicUtil(int s, boolean[] visited, int parent){
        visited[s] = true;
        Iterator<Integer> it = adj[s].listIterator();
        while(it.hasNext()){
            int n = it.next();
            if(!visited[n])
                if(isCyclicUtil(n, visited, s))
                    return true;
            else
                if(n != parent)
                    return true;
        }
        return false;
    }
}
