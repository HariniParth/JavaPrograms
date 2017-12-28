package com.company;

import java.util.*;

public class Main {

    private int V;
    private LinkedList<Integer> adj[];

    Main(int v){
        this.V = v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void BFS(int s){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        boolean[] visited = new boolean[V];
        visited[s] = true;

        while(!queue.isEmpty()){
            s = queue.poll();
            System.out.println(s+" ");

            Iterator<Integer> it = adj[s].listIterator();
            while(it.hasNext()){
                int n = it.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
