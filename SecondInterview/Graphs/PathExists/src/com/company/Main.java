package com.company;

// https://www.geeksforgeeks.org/find-if-there-is-a-path-between-two-vertices-in-a-given-graph/

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

    boolean isReachable(int s, int d){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        boolean[] visited = new boolean[V];
        visited[s] = true;

        while(!queue.isEmpty()){
            Iterator<Integer> it = adj[s].listIterator();
            while(it.hasNext()){
                int n = it.next();
                if(n == d)
                    return true;
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return false;
    }
}
