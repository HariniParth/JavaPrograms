package com.company;

import java.util.*;

// https://www.geeksforgeeks.org/detect-cycle-in-a-graph/

public class Main {

    private int V;
    private LinkedList<Integer> adj[];

    Main(int v){
        this.V = v;
        adj = new LinkedList[];
        for(int i=0;i<v;i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    boolean isCycle(int s){
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for(int i=0;i<V;i++){
            visited[i] = false;
            recStack[i] = false;
        }

        for(int i=0;i<V;i++)
            if(isCycleUtil(s, visited, recStack))
                return true;

        return false;
    }

    boolean isCycleUtil(int s, boolean[] visited, boolean[] recStack){
        if(!visited[s]){
            visited[s] = true;
            recStack[s] = true;

            Iterator<Integer> it = adj[s].listIterator();
            while(it.hasNext()){
                int n = it.next();
                if(!visited[n] && isCycleUtil(n, visited, recStack))
                    return true;
                if(recStack[n])
                    return true;
            }
        }
        recStack[s] = false;
        return false;
    }
}
