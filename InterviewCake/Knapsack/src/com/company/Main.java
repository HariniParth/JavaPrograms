package com.company;

// https://www.geeksforgeeks.org/knapsack-problem/

public class Main {

    // Time Complexity: O(2^n)

    public int knspsack(int W, int[] wt, int[] v, int n){

        if(W == 0 || n == 0)
            return 0;

        if(wt[n-1] > n)
            return knspsack(W, wt, v, n-1);

        return Math.max(v[n-1] + knspsack(W - wt[n-1], wt, v, n-1), knspsack(W, wt, v, n-1));
    }

    // Time Complexity: O(nW)

    public int knapsack(int W, int[] wt, int[] v, int n){

        if(W ==0 || n == 0)
            return 0;

        int[][] knapsack = new int[n+1][W+1];

        for(int i=0;i<=n;i++){
            for(int w=0;w<=W;w++){
                if(i == 0 || w == 0)
                    knapsack[i][w] = 0;
                else if(wt[i-1] <= w)
                    knapsack[i][w] = Math.max(v[i-1] + knapsack[i-1][w - wt[i-1]], knapsack[i-1][w]);
                else
                    knapsack[i][w] = knapsack[i-1][w];
            }
        }

        return knapsack[n][W];
    }
}
