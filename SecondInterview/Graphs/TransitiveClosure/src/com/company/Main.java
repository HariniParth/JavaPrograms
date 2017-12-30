package com.company;

import java.util.*;

// https://www.geeksforgeeks.org/transitive-closure-of-a-graph-using-dfs/

public class Main {

    private int V;
    private boolean[][] visitable;
    private LinkedList<Integer> adj[];

    Main(int v){
        this.V = v;
        visitable = new boolean[V][V];

        adj = new LinkedList[V];
        for(int i=0;i<v;i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    void DFSUtil(int s, int d){
        visitable[s][d] = true;
        Iterator<Integer> it = adj[d].listIterator();
        while(it.hasNext()){
            int n = it.next();
            if(!visitable[s][n])
                DFSUtil(s, n);
        }
    }

    void transitiveClosure(){
        for(int i=0;i<V;i++)
            DFSUtil(i, i);
    }
}
