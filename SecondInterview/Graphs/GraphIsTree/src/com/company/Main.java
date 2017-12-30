package com.company;

import java.util.*;

// https://www.geeksforgeeks.org/check-given-graph-tree/

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
        adj[v].add(w);
    }

    boolean isTree(){
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++)
            visited[i] = false;

        if(isCycleUtil(0, visited, -1))
            return false;

        for(int i=0;i<V;i++)
            if(visited[i] == false)
                return false;

        return true;
    }

    boolean isCycleUtil(int v, boolean[] visited, int parent){
        visited[v] = true;
        Iterator<Integer> it = adj[v].listIterator();
        while(it.hasNext()){
            int n = it.next();
            if(!visited[n]){
                if(isCycleUtil(n, visited, v))
                    return true;
            }
            else if(n != parent)
                return true;
        }
        return false;
    }
}
